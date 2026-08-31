package backedusecure.demo.dto.ResponseDTO;

import java.util.UUID;

public record AlunoResponseDTO(UUID idAluno, String nomeAluno, String matricula) {
}
