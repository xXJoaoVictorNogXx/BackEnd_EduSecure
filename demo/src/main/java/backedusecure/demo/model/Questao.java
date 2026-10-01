package backedusecure.demo.model;
import backedusecure.demo.enums.CategoriaQuestoes;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor // OBRIGATÓRIO PARA O JPA
@Entity
@Table(name="tb_questao")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idQuestao;

    // Salva o texto do enum, não o número
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaQuestoes categoria;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String enunciado;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String dificuldade;

    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternativa> alternativas;

    @Column(nullable = false)
    private String alternativaCorreta;

    // SE QUISER REUTILIZAR QUESTÕES EM VÁRIAS PROVAS (Recomendado):
    @ManyToMany(mappedBy = "questoes")
    private List<Prova> provas;



}