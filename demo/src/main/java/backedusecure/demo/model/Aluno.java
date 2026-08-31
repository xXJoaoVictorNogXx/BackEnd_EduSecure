package backedusecure.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)//unique = true: Garante que o valor não ira se repetir na tabela
    private String matricula;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;


}
