package OS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "client")
public class Client extends Person {

	@OneToMany(mappedBy = "client")	
	private List<OrderService> orderServices = new ArrayList<>();
	public Client() {
		super();
		
	}

	public Client(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
		
	}

	@JsonIgnore
	public List<OrderService> getOrderServices() {
		return orderServices;
	}

	public void setOrderServices(List<OrderService> orderServices) {
		this.orderServices = orderServices;
	}
	

}
