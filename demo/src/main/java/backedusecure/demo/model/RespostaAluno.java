package backedusecure.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class RespostaAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRespostaAluno;

    @ManyToOne
    @JoinColumn(name ="aluno_id", nullable = false)
    private Aluno idAluno;

    @ManyToOne
    @JoinColumn(name="prova_id", nullable = false)
    private Prova idProva;

    @ManyToOne
    @JoinColumn(name = "questao_id", nullable = false)
    private Questao idQuestao;

    @Column(nullable = false)
    private String alternativaEscolhida;

    @Column(nullable = false)
    private LocalDateTime dataHoraResposta;
}
