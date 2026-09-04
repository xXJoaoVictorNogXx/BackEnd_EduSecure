package backedusecure.demo.model;

import backedusecure.demo.enums.StatusEnvio;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

//Tabela para auditoria das provas
@Entity
@Table(name = "tb_historico_envio")
public class HistoricoEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAuditoria;

    @Column(nullable = false)
    private UUID idProva;

    @Column(nullable = false)
    private UUID idAluno;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_envio", nullable = false)
    private StatusEnvio statusEnvio;

    @Column(nullable = false)
    private LocalDateTime dataProcessamento;
}
