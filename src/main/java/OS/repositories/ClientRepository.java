package OS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import OS.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query("SELECT obj FROM client obj WHERE obj.cpf=:cpf")
	Client getByCPF(@Param("cpf") String cpf);

}
