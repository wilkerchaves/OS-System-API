package OS.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.Client;
import OS.model.OrderService;
import OS.model.Technician;
import OS.model.dto.OrderServiceDTO;
import OS.model.enums.OrderPriority;
import OS.model.enums.OrderStatus;
import OS.repositories.OrderServiceRepository;
import OS.services.exceptions.ObjectNotFoundException;

@Service
public class OSService {

	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@Autowired
	private TechnicianService technicianService;
	
	@Autowired
	private ClientService clientService;

	public List<OrderService> findAll() {
		return orderServiceRepository.findAll();
	}

	public OrderService getById(Integer id) {
		OrderService obj = orderServiceRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ". Tipo: " + OrderService.class.getName()));
		return obj;
	}

	public OrderService save(OrderServiceDTO dto) {
		return fromDto(dto);
	}

	public OrderService update(Integer id, @Valid OrderServiceDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	private OrderService fromDto(OrderServiceDTO dto) {
		OrderService newObj = new OrderService();
		
		newObj.setId(dto.getId());
		newObj.setObservation(dto.getObservation());
		newObj.setPriority(OrderPriority.valueOf(dto.getPriority()));
		newObj.setStatus(OrderStatus.valueOf(dto.getStatus()));
		
		
		Technician technician = technicianService.getById(dto.getTechnician());
		Client client = clientService.getById(dto.getClient());
		
		newObj.setClient(client);
		newObj.setTechnician(technician);
		return orderServiceRepository.save(newObj);
		
	}

}
