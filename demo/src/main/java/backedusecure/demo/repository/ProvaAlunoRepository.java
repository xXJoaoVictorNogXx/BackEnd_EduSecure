package backedusecure.demo.repository;

import backedusecure.demo.model.ProvaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ProvaAlunoRepository extends JpaRepository<ProvaAluno, UUID> {

    /**
     * O Optional indica que o registro pode não existir no banco.
     * Usamos o '.orElseThrow' para evitar o NullPointerException, lançando uma
     * exceção customizada caso a prova não seja encontrada.
     */
    @Query("SELECT pa FROM ProvaAluno pa WHERE pa.idAluno = :idAluno AND pa.idProva = :idProva")
    Optional<ProvaAluno> findByAlunoIdAndProvaId(@Param("idAluno") UUID idAluno, @Param("idProva") UUID idProva);
}
