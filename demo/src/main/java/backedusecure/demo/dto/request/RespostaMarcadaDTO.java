package backedusecure.demo.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record RespostaMarcadaDTO(UUID idQuestao, UUID idAlternativaEscolhida, LocalDateTime dataHoraResposta) {
}
