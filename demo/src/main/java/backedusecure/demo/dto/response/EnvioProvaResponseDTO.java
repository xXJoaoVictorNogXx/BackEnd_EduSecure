package backedusecure.demo.dto.response;

import backedusecure.demo.enums.StatusEnvio;

import java.time.LocalDateTime;
import java.util.UUID;

public record EnvioProvaResponseDTO(StatusEnvio statusSincronizacao, UUID idProva, LocalDateTime dataProcessamento) {

}
