package OS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import OS.model.Client;
import OS.model.OrderService;
import OS.model.Technician;
import OS.model.dto.ClientDTO;
import OS.model.dto.OrderServiceDTO;
import OS.model.dto.TechnicianDTO;
import OS.model.enums.OrderPriority;
import OS.model.enums.OrderStatus;
import OS.services.ClientService;
import OS.services.OSService;
import OS.services.TechnicianService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private OSService service;

	@Autowired
	private ClientService clientService;

	@Autowired
	private TechnicianService technicianService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	@Bean
	public boolean init() {
	
		if(ddl.equals("create")) {
			Technician t1 = new Technician(null, "André Silva", "861.414.100-90", "93 88888888");
			Client c1 = new Client(null, "Maria Eduarda", "152.197.520-57", "93 87875454");
			Client c2 = new Client(null, "João Silva", "321.946.910-81", "93 85462123");
			OrderService os = new OrderService(null, OrderPriority.BAIXA, "", OrderStatus.EM_ANDAMENTO, t1, c1);
			t1.getOrderServices().add(os);
			c1.getOrderServices().add(os);

//			technicianService.save(new TechnicianDTO(t1));
//			clientService.save(new ClientDTO(c1));
//			clientService.save(new ClientDTO(c2));
//			service.save(new OrderServiceDTO(os));
		}
		return false;

	}
}
