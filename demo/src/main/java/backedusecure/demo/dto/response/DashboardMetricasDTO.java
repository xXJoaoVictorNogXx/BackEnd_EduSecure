package backedusecure.demo.dto.response;

public record DashboardMetricasDTO(Integer provasAplicadas,
                                   String provasTrend,
                                   Double mediaTurma,
                                   String mediaTrend,
                                   Integer taxaConclusao,
                                   Integer questoesBanco) {
}
