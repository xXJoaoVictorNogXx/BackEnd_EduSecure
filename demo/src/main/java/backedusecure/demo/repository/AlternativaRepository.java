package backedusecure.demo.repository;

import backedusecure.demo.model.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface  AlternativaRepository extends JpaRepository<Alternativa, UUID> {
}
