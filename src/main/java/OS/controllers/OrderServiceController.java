package OS.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OS.model.OrderService;
import OS.model.dto.OrderServiceDTO;
import OS.services.OSService;

@RestController
@RequestMapping(value = "/orders")
public class OrderServiceController {

	@Autowired
	private OSService service;

	@GetMapping
	public ResponseEntity<List<OrderServiceDTO>> findAll() {
		List<OrderServiceDTO> orderServiceDTOs = new ArrayList<>();
		List<OrderService> list = service.findAll();
		for (OrderService orderService : list) {
			OrderServiceDTO dto = new OrderServiceDTO(orderService);
			orderServiceDTOs.add(dto);
		}
		return ResponseEntity.ok().body(orderServiceDTOs);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderServiceDTO> findById(@PathVariable Integer id) {
		OrderServiceDTO orderServiceDTO = new OrderServiceDTO(service.getById(id));
		return ResponseEntity.ok().body(orderServiceDTO);

	}

}
