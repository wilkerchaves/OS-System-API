package OS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import OS.model.OrderService;
import OS.repositories.OrderServiceRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderServiceController {
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@GetMapping
	public ResponseEntity<List<OrderService>> findAll(){
		return ResponseEntity.ok().body(orderServiceRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderService> findById(@PathVariable Integer id){
		if(orderServiceRepository.findById(id).isPresent()) {
			return ResponseEntity.ok().body(orderServiceRepository.findById(id).get());
		}
		return ResponseEntity.notFound().build();
		
	}

}
