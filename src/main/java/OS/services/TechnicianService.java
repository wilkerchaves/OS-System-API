package OS.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.Technician;
import OS.model.dto.TechnicianDTO;
import OS.repositories.TechnicianRepository;
import OS.services.exceptions.DataIntegrityViolationException;
import OS.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService {

	@Autowired
	private TechnicianRepository repository;

	public List<Technician> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Technician save(TechnicianDTO dto) {
		if(getByCPF(dto)!=null) {
			throw new DataIntegrityViolationException("CPF já cadastrado no banco de dados!");
		}
		return repository.saveAndFlush(new Technician(null, dto.getName(), dto.getCpf(), dto.getPhone()));
	}

	public Technician getById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ". Tipo: " + Technician.class.getName()));
	}
	
	private Technician getByCPF(TechnicianDTO dto) {
		return (repository.getByCPF(dto.getCpf())!=null)?repository.getByCPF(dto.getCpf()):null;
	}

}
