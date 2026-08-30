package backedusecure.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tb_questao")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, columnDefinition = "TEXT")//Text é util caso o enunciado seja longo
    private String enunciado;

    //mappedby= "questao": Diz que o mapeamento esta sendo controlado pelo atributo questão la na classe Alternativa
    //cascade = Cascade.ALL: Significa que se caso salve uma questão, o Spring salva automativamente todas as alternativas dela de uma vez
    //orphanRemoval = true: Se for removida uma alterantiva da lista, ela é apagada do banco automaticamente
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alternativa> alternativas;

    @Column(nullable = false)
    private String alternativaCorreta;

    @Column(nullable = false)
    private Integer peso;

    //A anotação @Column nunca deve ser usada junto com anotações de relacionamento como @ManyToOne, @OneToMany, @OneToOne ou @ManyToMany
    //O relacionamenteo @ManyToOne lida com objetos e cria uma chave estrangeira, sendo assim o certo é para gerar a chave seria utilizar o join column
    @ManyToOne
    @JoinColumn(name = "prova_id", nullable = false)
    private Prova prova;
}
