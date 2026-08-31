package backedusecure.demo.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.UUID;

public class RespostaAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name ="aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name="prova_id", nullable = false)
    private Prova prova;

    @ManyToOne
    @JoinColumn(name = "questao_id", nullable = false)
    private Questao questao;

    @Column(nullable = false)
    private String alternativaEscolhida;

    @Column(nullable = false)
    private LocalDateTime dataHoraResposta;
}
