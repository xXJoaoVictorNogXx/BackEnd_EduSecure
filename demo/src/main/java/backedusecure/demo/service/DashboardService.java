package backedusecure.demo.service;


import backedusecure.demo.dto.response.DashboardMetricasDTO;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    public DashboardMetricasDTO getDashboardMetricas() {
        return new DashboardMetricasDTO(
                48,
                "+12%",
                7.4,
                "+0.6",
                92,
                312
        );
    }
}
