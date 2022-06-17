package OS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import OS.model.Client;
import OS.model.OrderService;
import OS.model.Technician;
import OS.model.enums.OrderPriority;
import OS.model.enums.OrderStatus;
import OS.services.ClientService;
import OS.services.OSService;
import OS.services.TechnicianService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private OSService service;

	@Autowired
	private ClientService clientService;

	@Autowired
	private TechnicianService technicianService;

	@Bean
	public void init() {
		Technician t1 = new Technician(null, "André Silva", "861.414.100-90", "93 88888888");
		Client c1 = new Client(null, "Maria Eduarda", "152.197.520-57", "93 87875454");
		Client c2 = new Client(null, "João Silva", "321.946.910-81", "93 85462123");
		OrderService os = new OrderService(null, OrderPriority.BAIXA, "", OrderStatus.EM_ANDAMENTO, t1, c1);
		t1.getOrderServices().add(os);
		c1.getOrderServices().add(os);

		technicianService.save(t1);
		clientService.save(c1);
		clientService.save(c2);
		service.save(os);

	}
}
