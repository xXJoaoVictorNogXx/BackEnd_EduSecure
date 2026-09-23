package backedusecure.demo.controller;

import backedusecure.demo.dto.response.DashboardMetricasDTO;
import backedusecure.demo.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000/") //Libera acesso para teste local
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/metricas")

    public ResponseEntity<DashboardMetricasDTO> getMetricas() {
        return  ResponseEntity.ok(dashboardService.obterMetricasDashboard());
    }

}
