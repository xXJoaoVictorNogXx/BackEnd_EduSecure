package backedusecure.demo.dto.response;

import java.util.List;

public record DashboardMetricasDTO(ProgressoTurmaDTO progresso,
                                   double taxaIntegridade,
                                   double mediaGeral,
                                   int questoesDisponiveis,
                                   List<AlunoSyncStatusDTO> listaSincronizacao,
                                   List<AlertaAuditoriaDTO> feedAlertas) {
}
