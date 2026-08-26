package backedusecure.demo.repository;

import backedusecure.demo.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProvaRepository extends JpaRepository<Prova, UUID> {
}
