package backedusecure.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_prova")
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)// @GeneratedValue: Delega a responsabilidade de criar a chave primária ao banco de dados
    private UUID id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false)
    private String disciplina;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}

