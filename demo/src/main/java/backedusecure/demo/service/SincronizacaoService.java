package backedusecure.demo.service;

import backedusecure.demo.dto.request.RespostaMarcadaDTO;
import backedusecure.demo.dto.request.SincronizacaoRequestDTO;
import backedusecure.demo.enums.StatusEnvio;
import backedusecure.demo.model.Prova;
import backedusecure.demo.model.ProvaAluno;
import backedusecure.demo.model.RespostaAluno;
import backedusecure.demo.repository.ProvaAlunoRepository;
import backedusecure.demo.repository.ProvaRepository;
import backedusecure.demo.repository.RespostaAlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SincronizacaoService {

    private final ProvaRepository provaRepository;

    private final RespostaAlunoRepository respostaAlunoRepository;

    private final ProvaAlunoRepository provaAlunoRepository;

    @Transactional
    public void processarSincronizacao(SincronizacaoRequestDTO request) {

        // 1. Busca a tentativa do aluno ou explode uma exceção se não achar
        ProvaAluno provaDoAluno = provaAlunoRepository.findByAlunoIdAndProvaId(request.idAluno(), request.idProva())
                .orElseThrow(() -> new RuntimeException("Tentativa de prova não encontrada para este aluno."));

        // 2. VALIDAÇÃO DE DUPLICIDADE (Anti-Fraude)
        // Se o status já for SINCRONIZADA, o app não pode enviar de novo (evita reenvio malicioso ou duplo clique)
        if (provaDoAluno.getStatusEnvio() == StatusEnvio.SINCRONIZADA) {
            throw new RuntimeException("Atenção: Esta prova já foi sincronizada anteriormente.");
        }

        // 3. VALIDAÇÃO DE PRAZO (Auditoria Offline)
        LocalDateTime dataLimiteProva = provaDoAluno.getIdProva().getDataLimite();

        if (LocalDateTime.now().isAfter(dataLimiteProva)) {
            throw new RuntimeException("Fraude de tempo: O prazo limite para entrega desta avaliação já expirou.");
        }

        if(request.getRespostas() != null) {
            for(RespostaMarcadaDTO respDTO : request.getRespostas()) {
                RespostaAluno respostaAluno = new RespostaAluno();
                respostaAluno.setIdAluno(request.getAlunoId());
                respostaAluno.setIdProva(request.getProvaId());
                respostaAluno.setIdQuestao(respDto.getQuestaoId());
                respostaAluno.setAlternativaEscolhida(respDto.getAlternativaEscolhida());
                respostaAluno.setDataHoraResposta(respDto.getDataHoraResposta());

                respostaAlunoRepository.save(respostaAluno);
            }
        }


        // 4. PASSOU NAS VALIDAÇÕES: Atualiza o status para sucesso
        provaDoAluno.setStatusEnvio(StatusEnvio.SINCRONIZADA);
        provaDoAluno.setDataSincronizacao(LocalDateTime.now()); // Carimba o horário que o servidor recebeu

        // 5. Salva a alteração da tentativa no banco
        provaAlunoRepository.save(provaDoAluno);

        // (Próximo passo futuro: salvar a lista de respostas e calcular a nota)
    }
}
