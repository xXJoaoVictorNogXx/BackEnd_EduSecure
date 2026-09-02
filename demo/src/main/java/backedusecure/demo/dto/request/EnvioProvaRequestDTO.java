package backedusecure.demo.dto.request;

import java.util.List;
import java.util.UUID;

public record EnvioProvaRequestDTO(UUID idAluno, UUID idProva, List<RespostaQuestaoDTO> respostas) {
}
