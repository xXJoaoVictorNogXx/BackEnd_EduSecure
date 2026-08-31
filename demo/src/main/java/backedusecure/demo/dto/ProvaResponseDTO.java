package backedusecure.demo.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProvaResponseDTO(UUID id, String titulo, String disciplina, LocalDateTime dataCriacao) {
}
