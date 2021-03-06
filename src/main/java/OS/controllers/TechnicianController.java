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

import OS.model.Technician;
import OS.model.dto.TechnicianDTO;
import OS.services.TechnicianService;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/technicians")
public class TechnicianController {

	@Autowired
	private TechnicianService service;

	@GetMapping
	public ResponseEntity<List<TechnicianDTO>> findAll() {
		List<TechnicianDTO> technicianDTOs = service.findAll().stream().map(obj -> new TechnicianDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(technicianDTOs);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
		TechnicianDTO dto = new TechnicianDTO(service.getById(id));
		return ResponseEntity.ok().body(dto);

	}

	@PostMapping
	public ResponseEntity<TechnicianDTO> save(@Valid @RequestBody TechnicianDTO dto) {
		Technician obj = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> update(@PathVariable Integer id, @Valid @RequestBody TechnicianDTO dto) {
		TechnicianDTO objDto = new TechnicianDTO(service.update(id, dto));
		return ResponseEntity.ok().body(objDto);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
