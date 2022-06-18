package OS.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.Client;
import OS.model.Person;
import OS.model.dto.ClientDTO;
import OS.repositories.ClientRepository;
import OS.repositories.PersonRepository;
import OS.services.exceptions.DataIntegrityViolationException;
import OS.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	
	@Autowired
	private  PersonRepository personRepository;
	
	
	
	public List<Client> findAll() {
		return repository.findAll();
	}

	
	public Client getById(Integer id) {
		Client obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ". Tipo: " + Client.class.getName()));
		return obj;
	}
	public Client save(ClientDTO dto) {
		if (getByCPF(dto) != null) {
			throw new DataIntegrityViolationException("CPF já cadastrado no banco de dados!");
		}
		return repository.saveAndFlush(new Client(null, dto.getName(), dto.getCpf(), dto.getPhone()));
	}


	public Client update(Integer id, @Valid ClientDTO dto) {
		Client oldObj = getById(id);
		if (getByCPF(dto) != null && getByCPF(dto).getId() != id) {
			throw new DataIntegrityViolationException("Erro: novo CPF é diferente do registrado!");
		}
		oldObj.setName(dto.getName());
		oldObj.setCpf(dto.getCpf());
		oldObj.setPhone(dto.getPhone());
		return repository.save(oldObj);
		
	}
	
	public void delete(Integer id) {
		Client obj = getById(id);
		if(obj.getOrderServices().size()>0) {
			throw new DataIntegrityViolationException("Técnico não pode ser deletado pois possui ordens de serviços!");
		}
		repository.deleteById(id);
	}


	private Person getByCPF(@Valid ClientDTO dto) {
		return (personRepository.getByCPF(dto.getCpf()) != null) ? personRepository.getByCPF(dto.getCpf()) : null;
	}


	
}
