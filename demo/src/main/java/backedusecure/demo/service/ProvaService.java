package backedusecure.demo.service;

import backedusecure.demo.dto.request.ProvaRequestDTO;
import backedusecure.demo.dto.response.ProvaResponseDTO;
import backedusecure.demo.mappers.ProvaMapper;
import backedusecure.demo.mappers.QuestaoMapper; // Supondo que você crie um mapper para questões
import backedusecure.demo.model.Prova;
import backedusecure.demo.model.Questao;
import backedusecure.demo.repository.ProvaRepository;
import backedusecure.demo.repository.QuestaoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProvaService {

    private final ProvaRepository provaRepository;
    private final QuestaoRepository questaoRepository; // Injetamos o repositório de questões
    private final ProvaMapper provaMapper;
    private final QuestaoMapper questaoMapper; // Injetamos o mapper de questões

    @Transactional
    public ProvaResponseDTO criarProva(ProvaRequestDTO request) {

        // 1. O Mapper converte a Prova (título, professor, etc)
        Prova novaProva = provaMapper.toEntity(request);

        // 2. Extraímos as questões que vieram no Request (elas vieram completas do front)
        // Convertendo os DTOs das questões que vieram do OpenTDB para a sua Entidade Questao
        List<Questao> questoesConvertidas = request.questoes().stream()
                .map(questaoMapper::toEntity)
                .collect(Collectors.toList());

        // 3. Salvamos essas questões novas no SEU banco de dados local
        // Se você não salvar antes, vai dar erro ao tentar vincular com a Prova
        List<Questao> questoesSalvas = questaoRepository.saveAll(questoesConvertidas);

        // 4. Agora sim, vinculamos as questões já salvas à nova Prova
        novaProva.setQuestoes(questoesSalvas);

        // 5. Salvamos a Prova
        Prova provaSalva = provaRepository.save(novaProva);

        // 6. Retorna para o Frontend/Flutter
        return provaMapper.toResponseDTO(provaSalva);
    }
}
