package OS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OS.model.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

	@Query("SELECT obj FROM technician obj WHERE obj.cpf=:cpf")
	Technician getByCPF(@Param("cpf") String cpf);

}
