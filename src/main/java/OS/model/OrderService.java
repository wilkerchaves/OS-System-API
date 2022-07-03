package OS.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import OS.model.enums.OrderPriority;
import OS.model.enums.OrderStatus;

@Entity(name = "tb_order_service")
public class OrderService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime startDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime finishDate;
	private Integer priority;
	private String observation;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "technician_id")
	private Technician technician;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public OrderService() {
		super();
		this.setStartDate(LocalDateTime.now(ZoneId.systemDefault()));
		this.setPriority(OrderPriority.BAIXA);
		this.setStatus(OrderStatus.ABERTO);
		
	}

	public OrderService(Integer id, OrderPriority priority,
			String observation, OrderStatus status, Technician technician, Client client) {
		super();
		this.id = id;
		this.setStartDate(LocalDateTime.now(ZoneId.systemDefault()));
		this.priority = (priority == null) ? 0 : priority.getCode();
		this.observation = observation;
		this.status = (status == null) ? 0 : status.getCode();
		this.technician = technician;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDateTime finishDate) {
		this.finishDate = finishDate;
	}

	public OrderPriority getPriority() {
		return OrderPriority.valueOf(this.priority);
	}

	public void setPriority(OrderPriority priority) {
		this.priority = priority.getCode();
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public OrderStatus getStatus() {
		return OrderStatus.valueOf(this.status);
	}

	public void setStatus(OrderStatus status) {
		this.status = status.getCode();
	}


	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderService other = (OrderService) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "OrderService [id=" + id + ", startDate=" + startDate + ", finishDate=" + finishDate + ", priority="
				+ priority + ", observation=" + observation + ", status=" + status + ", technician=" + technician
				+ ", client=" + client + "]";
	}

}
