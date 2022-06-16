package OS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import OS.model.OrderService;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Integer> {

}
