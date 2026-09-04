package backedusecure.demo.model;


import backedusecure.demo.enums.StatusEnvio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_prova_aluno")
public class ProvaAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idProvaAluno;

    @ManyToOne(fetch = FetchType.LAZY)//Evita carregar a prova sem necessidade
    @JoinColumn(name = "id_prova",  nullable = false)
    private Prova idProva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno idAluno;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnvio statusEnvio;

    private LocalDateTime dataSincronizacao;


}
