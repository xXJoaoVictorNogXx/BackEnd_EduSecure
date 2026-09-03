package backedusecure.demo.dto.request;

import java.util.UUID;

public record AlunoLoginRequestDTO(UUID idAluno, String matricula) {
}
