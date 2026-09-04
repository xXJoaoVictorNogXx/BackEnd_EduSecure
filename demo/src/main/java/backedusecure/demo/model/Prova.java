package backedusecure.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

//@Data Tomar cuidado ao utilizar @Data em entities, ele pode causar erros no código
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_prova")
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)// @GeneratedValue: Delega a responsabilidade de criar a chave primária ao banco de dados
    private UUID idProva;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false)
    private String disciplina;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_limite")
    private LocalDateTime dataLimite;
}

