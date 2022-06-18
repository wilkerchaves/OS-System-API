package OS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OS.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT obj FROM tb_person obj WHERE obj.cpf=:cpf")
	Person getByCPF(@Param("cpf") String cpf);

}
