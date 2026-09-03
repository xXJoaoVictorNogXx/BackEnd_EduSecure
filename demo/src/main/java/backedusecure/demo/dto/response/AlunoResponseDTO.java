package backedusecure.demo.dto.response;

import java.util.UUID;

public record AlunoResponseDTO(UUID idAluno, String nomeAluno, String matricula) {
}
