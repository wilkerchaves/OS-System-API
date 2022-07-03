package OS.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
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

	public OrderService update(@Valid OrderServiceDTO dto) {
		getById(dto.getId());
		return fromDto(dto);
	}

	private OrderService fromDto(OrderServiceDTO dto) {
		OrderService newObj = new OrderService();		
		newObj.setId(dto.getId());
		newObj.setObservation(dto.getObservation());
		newObj.setPriority(OrderPriority.valueOf(dto.getPriority().getCode()));
		newObj.setStatus(OrderStatus.valueOf(dto.getStatus().getCode()));
		if(dto.getStartDate() != null) {
			newObj.setStartDate(dto.getStartDate());
			
		}		
		Technician technician = technicianService.getById(dto.getTechnician());
		Client client = clientService.getById(dto.getClient());		
		if(dto.getStatus().getCode().equals(3)) {
			newObj.setFinishDate(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		}
		newObj.setClient(client);
		newObj.setTechnician(technician);
		System.out.println(newObj);
		return orderServiceRepository.save(newObj);
		
	}

}
