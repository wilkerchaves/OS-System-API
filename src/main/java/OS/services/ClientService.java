package OS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.Client;
import OS.model.dto.ClientDTO;
import OS.repositories.ClientRepository;
import OS.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	
	public Client getById(Integer id) {
		Client obj = clientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. ID: " + id + ". Tipo: " + Client.class.getName()));
		return obj;
	}
	public Client save(ClientDTO dto) {
		return clientRepository.save(new Client(dto.getId(), dto.getName(), dto.getCpf(), dto.getPhone()));
	}
}
