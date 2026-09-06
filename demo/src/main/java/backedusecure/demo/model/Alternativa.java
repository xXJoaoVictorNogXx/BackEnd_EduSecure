package backedusecure.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_alternativa")
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idAlternativa;

    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private String letra;

    @Column(nullable = false)
    private Boolean correta;

    @ManyToOne
    @JoinColumn(name = "questao_id", nullable = false)// Cria a chave estrangeira no banco
    private Questao questao;

}
