package OS.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.Client;
import OS.model.OrderService;
import OS.model.Technician;
import OS.model.dto.OrderServiceDTO;
import OS.repositories.OrderServiceRepository;
import OS.services.exceptions.ObjectNotFoundException;

@Service
public class OSService {

	@Autowired
	private OrderServiceRepository orderServiceRepository;

	public List<OrderService> findAll() {
		return orderServiceRepository.findAll();
	}

	public OrderService getById(Integer id) {
		OrderService obj = orderServiceRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ". Tipo: " + OrderService.class.getName()));
		return obj;
	}

	public OrderService save(OrderServiceDTO dto) {
		return orderServiceRepository.save(
				new OrderService(
						null, 
						dto.getPriority(), 
						dto.getObservation(), 
						dto.getStatus(), 
						new Technician(dto.getTechnician().getId(), dto.getTechnician().getName(), dto.getTechnician().getCpf(), dto.getTechnician().getPhone()), 
						new Client(dto.getClient().getId(), dto.getClient().getName(), dto.getClient().getCpf(), dto.getClient().getPhone())
						)
				);
	}

	public OrderService update(Integer id, @Valid OrderServiceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
