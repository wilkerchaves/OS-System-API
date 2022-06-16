package OS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OS.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
