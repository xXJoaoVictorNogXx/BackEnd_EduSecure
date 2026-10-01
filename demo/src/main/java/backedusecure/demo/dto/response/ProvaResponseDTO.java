package backedusecure.demo.dto.response;

import backedusecure.demo.dto.request.QuestaoRequestDTO;
import backedusecure.demo.model.Questao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ProvaResponseDTO(UUID id, String titulo, String disciplina, List<Questao> questoes, LocalDateTime dataCriacao) {
}
