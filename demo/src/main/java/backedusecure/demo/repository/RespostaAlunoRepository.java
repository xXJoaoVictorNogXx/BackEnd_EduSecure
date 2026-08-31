package backedusecure.demo.repository;

import backedusecure.demo.model.RespostaAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RespostaAlunoRepository extends JpaRepository<RespostaAluno, UUID> {
}
