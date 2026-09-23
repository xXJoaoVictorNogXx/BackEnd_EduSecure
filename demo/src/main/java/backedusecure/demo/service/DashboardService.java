package backedusecure.demo.service;

import backedusecure.demo.dto.response.AlertaAuditoriaDTO;
import backedusecure.demo.dto.response.AlunoSyncStatusDTO;
import backedusecure.demo.dto.response.DashboardMetricasDTO;
import backedusecure.demo.dto.response.ProgressoTurmaDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class DashboardService {

    public DashboardMetricasDTO obterMetricasDashboard() {

        // 1. Mock dos Cartões Superiores (KPIs)
        ProgressoTurmaDTO progresso = new ProgressoTurmaDTO(38, 5, 2, 45);
        double taxaIntegridade = 92.5;
        double mediaGeral = 7.8;
        int questoesDisponiveis = 120; // Questões já puxadas do OpenTDB

        // 2. Mock da Tabela de Sincronização (Visão de Infraestrutura)
        List<AlunoSyncStatusDTO> listaAlunos = List.of(
                new AlunoSyncStatusDTO("João V. ***", "20241001", "ONLINE", "Agora"),
                new AlunoSyncStatusDTO("Maria S. ***", "20241045", "OFFLINE", "Há 12 min"),
                new AlunoSyncStatusDTO("Pedro H. ***", "20241088", "PENDENTE", "Há 2 min"),
                new AlunoSyncStatusDTO("Ana L. ***", "20241092", "ONLINE", "Agora")
        );

        // 3. Mock do Feed de Auditoria (Timeline de Fraudes e Eventos)
        List<AlertaAuditoriaDTO> alertas = List.of(
                new AlertaAuditoriaDTO(
                        UUID.randomUUID().toString(),
                        "CRITICO",
                        "Tentativa de Consulta Externa - Aplicativo minimizado",
                        "Maria S. ***",
                        "10:15"
                ),
                new AlertaAuditoriaDTO(
                        UUID.randomUUID().toString(),
                        "AVISO",
                        "Perda de conexão Wi-Fi. Entrando em modo offline seguro.",
                        "Pedro H. ***",
                        "10:12"
                ),
                new AlertaAuditoriaDTO(
                        UUID.randomUUID().toString(),
                        "SUCESSO",
                        "Prova sincronizada com sucesso e pacote criptografado.",
                        "João V. ***",
                        "10:10"
                )
        );

        // 4. Montagem e Retorno
        return new DashboardMetricasDTO(
                progresso,
                taxaIntegridade,
                mediaGeral,
                questoesDisponiveis,
                listaAlunos,
                alertas
        );
    }
}