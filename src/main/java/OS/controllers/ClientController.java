package OS.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import OS.model.Client;
import OS.model.dto.ClientDTO;
import OS.services.ClientService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientDTO>> findAll() {
		List<ClientDTO> clientDTOs = service
				.findAll()
				.stream()
				.map(obj->new ClientDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(clientDTOs);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Integer id) {
		ClientDTO dto = new ClientDTO(service.getById(id));
		return ResponseEntity.ok().body(dto);

	}
	
	@PostMapping
	public ResponseEntity<ClientDTO> save(@Valid @RequestBody ClientDTO dto){
		Client obj = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @Valid @RequestBody ClientDTO dto) {
		ClientDTO objDto = new ClientDTO(service.update(id, dto));
		return ResponseEntity.ok().body(objDto);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
