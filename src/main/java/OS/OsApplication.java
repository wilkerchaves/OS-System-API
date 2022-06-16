package OS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import OS.model.Client;
import OS.model.OrderService;
import OS.model.Technician;
import OS.model.enums.OrderPriority;
import OS.model.enums.OrderStatus;
import OS.services.ClientService;
import OS.services.OSService;
import OS.services.TechnicianService;

@SpringBootApplication
public class OsApplication implements CommandLineRunner {
	
	@Autowired
	private OSService service;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private TechnicianService technicianService;
	

	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Technician t1 = new Technician(null, "André Silva", "861.414.100-90", "93 88888888");
		Client c1 = new Client(null, "Maria Eduarda", "152.197.520-57", "93 87875454");
		OrderService os = new OrderService(null, OrderPriority.BAIXA, "", OrderStatus.EM_ANDAMENTO, t1, c1);
		t1.getOrderServices().add(os);
		c1.getOrderServices().add(os);
		
	
		technicianService.save(t1);
		clientService.save(c1);
		service.save(os);
		
	}

}
