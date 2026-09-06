package backedusecure.demo.model;

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

    @ManyToOne
    @JoinColumn(name = "alternativa_id")
    private Alternativa idalternativaEscolhida;

    @Column(nullable = false)
    private LocalDateTime dataHoraResposta;
}
