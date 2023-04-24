package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Part;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    Optional<Part> findPartByPartName(String partName);
}
