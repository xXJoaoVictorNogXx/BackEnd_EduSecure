package backedusecure.demo.repository;

import backedusecure.demo.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuestaoRepository extends JpaRepository<Questao, UUID> {
}
