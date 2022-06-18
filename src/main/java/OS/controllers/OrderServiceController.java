package OS.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		List<OrderServiceDTO> orderServiceDTOs = service
				.findAll()
				.stream()
				.map(obj->new OrderServiceDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(orderServiceDTOs);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderServiceDTO> findById(@PathVariable Integer id) {
		OrderServiceDTO orderServiceDTO = new OrderServiceDTO(service.getById(id));
		return ResponseEntity.ok().body(orderServiceDTO);

	}
	
	@PostMapping
	public ResponseEntity<OrderServiceDTO> save(@Valid @RequestBody OrderServiceDTO dto){
		dto = new OrderServiceDTO(service.save(dto));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping
	public ResponseEntity<OrderServiceDTO> update(@Valid @RequestBody OrderServiceDTO dto) {
		dto = new OrderServiceDTO(service.update(dto));
		return ResponseEntity.ok().body(dto);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
