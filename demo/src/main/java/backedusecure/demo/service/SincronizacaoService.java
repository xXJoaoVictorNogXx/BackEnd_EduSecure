package backedusecure.demo.service;

import backedusecure.demo.dto.request.RespostaMarcadaDTO;
import backedusecure.demo.dto.request.SincronizacaoRequestDTO;
import backedusecure.demo.enums.StatusEnvio;
import backedusecure.demo.model.*;
import backedusecure.demo.repository.ProvaAlunoRepository;
import backedusecure.demo.repository.RespostaAlunoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SincronizacaoService {

    private final RespostaAlunoRepository respostaAlunoRepository;

    private final ProvaAlunoRepository provaAlunoRepository;

    @Transactional
    public void processarSincronizacao(SincronizacaoRequestDTO request) {

        ProvaAluno provaDoAluno = provaAlunoRepository.findByAlunoIdAndProvaId(request.idAluno(), request.idProva())
                .orElseThrow(() -> new RuntimeException("Tentativa de prova não encontrada para este aluno."));

        // Se o status já for SINCRONIZADA, o app não pode enviar de novo (evita reenvio malicioso ou duplo clique)
        if (provaDoAluno.getStatusEnvio() == StatusEnvio.SINCRONIZADA) {
            throw new RuntimeException("Atenção: Esta prova já foi sincronizada anteriormente.");
        }

        //VALIDAÇÃO DE PRAZO (Auditoria Offline)
        LocalDateTime dataLimiteProva = provaDoAluno.getIdProva().getDataLimite();

        if (LocalDateTime.now().isAfter(dataLimiteProva)) {
            throw new RuntimeException("Fraude de tempo: O prazo limite para entrega desta avaliação já expirou.");
        }

        if(request.respostas() != null) {
            List<RespostaAluno> respostasParaSalvar = new ArrayList<>();
            for(RespostaMarcadaDTO respDTO : request.respostas()) {
                RespostaAluno respostaAluno = new RespostaAluno();

                Aluno aluno = new Aluno();
                aluno.setIdAluno(request.idAluno());
                respostaAluno.setIdAluno(aluno);

                Prova prova = new Prova();
                prova.setIdProva(request.idProva());
                respostaAluno.setIdProva(prova);

                Questao questao = new Questao();
                questao.setIdQuestao(respDTO.idQuestao());
                respostaAluno.setIdQuestao(questao);

                Alternativa alternativa = new Alternativa();
                alternativa.setIdAlternativa(respDTO.idAlternativaEscolhida());
                respostaAluno.setIdalternativaEscolhida(alternativa);

                respostaAluno.setDataHoraResposta(respDTO.dataHoraResposta());
                respostasParaSalvar.add(respostaAluno);
            }
                respostaAlunoRepository.saveAll(respostasParaSalvar);
        }


        provaDoAluno.setStatusEnvio(StatusEnvio.SINCRONIZADA);
        provaDoAluno.setDataSincronizacao(LocalDateTime.now());
        provaAlunoRepository.save(provaDoAluno);

    }
}
