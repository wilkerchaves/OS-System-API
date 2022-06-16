package OS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OS.model.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

}
