package OS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import OS.model.Technician;
import OS.repositories.TechnicianRepository;

@Service
public class TechnicianService {

	@Autowired
	private TechnicianRepository technicianRepository;
	
	public List<Technician> findAll(){
		return technicianRepository.findAll();
	}
	
	public Technician save(Technician technician) {
		return technicianRepository.save(technician);
	}
}
