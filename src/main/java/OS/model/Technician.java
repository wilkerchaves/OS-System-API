package OS.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "technician")
public class Technician extends Person{

	@OneToMany(mappedBy = "technician")
	private List<OrderService> orderServices = new ArrayList<>();
	public Technician() {
		super();
	
	}

	public Technician(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
		
	}

	public List<OrderService> getOrderServices() {
		return orderServices;
	}

	public void setOrderServices(List<OrderService> orderServices) {
		this.orderServices = orderServices;
	}
	
	

}
