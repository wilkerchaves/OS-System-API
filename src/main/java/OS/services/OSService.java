package OS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.OrderService;
import OS.repositories.OrderServiceRepository;
import OS.services.exceptions.ObjectNotFoundException;

@Service
public class OSService {

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	public List<OrderService> findAll() {
		return orderServiceRepository.findAll();
	}

	public OrderService save(OrderService orderService) {
		return orderServiceRepository.save(orderService);
	}

	public OrderService getById(Integer id) {
		OrderService obj = orderServiceRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ". Tipo: " + OrderService.class.getName()));
		return obj;
	}

}
