package backedusecure.demo.dto.request;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record SincronizacaoRequestDTO(UUID idAluno, UUID idProva, LocalDateTime dataFinalizacaoMobile, List<RespostaMarcadaDTO> respostas) {
}
