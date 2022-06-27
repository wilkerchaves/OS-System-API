package OS.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.Person;
import OS.model.Technician;
import OS.model.dto.TechnicianDTO;
import OS.repositories.PersonRepository;
import OS.repositories.TechnicianRepository;
import OS.services.exceptions.DataIntegrityViolationException;
import OS.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService {

	@Autowired
	private TechnicianRepository repository;
	
	@Autowired
	private  PersonRepository personRepository;

	public List<Technician> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Technician save(TechnicianDTO dto) {
		if (getByCPF(dto) != null) {
			throw new DataIntegrityViolationException("CPF já cadastrado no banco de dados!");
		}
		return repository.saveAndFlush(new Technician(null, dto.getName(), dto.getCpf(), dto.getPhone()));
	}

	public Technician getById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ". Tipo: " + Technician.class.getName()));
	}

	public Technician update(Integer id, @Valid TechnicianDTO dto) {
		Technician oldObj = getById(id);
		if (getByCPF(dto) != null && getByCPF(dto).getId() != id) {
			System.out.println(getByCPF(dto));
				System.out.println(getByCPF(dto).getId() != id)
			
			throw new DataIntegrityViolationException("Erro: novo CPF é diferente do registrado!"+getByCPF(dto));
		}
		oldObj.setName(dto.getName());
		oldObj.setCpf(dto.getCpf());
		oldObj.setPhone(dto.getPhone());
		return repository.save(oldObj);
	}
	

	public void delete(Integer id) {
		Technician obj = getById(id);
		if(obj.getOrderServices().size()>0) {
			throw new DataIntegrityViolationException("Técnico não pode ser deletado pois possui ordens de serviços!");
		}
		repository.deleteById(id);
		
	}

	private Person getByCPF(TechnicianDTO dto) {
		return (personRepository.getByCPF(dto.getCpf()) != null) ? personRepository.getByCPF(dto.getCpf()) : null;
	}


}
