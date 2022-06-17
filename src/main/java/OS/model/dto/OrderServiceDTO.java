package OS.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import OS.model.OrderService;
import OS.model.enums.OrderPriority;
import OS.model.enums.OrderStatus;

public class OrderServiceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;	
	private LocalDateTime startDate;
	private LocalDateTime finishDate;
	private Integer priority;
	private String observation;
	private Integer status;
	private TechnicianDTO technician;
	private ClientDTO client;

	public OrderServiceDTO() {
	}

	public OrderServiceDTO(OrderService orderService) {
		this.id = orderService.getId();
		this.startDate = orderService.getStartDate();
		this.finishDate = orderService.getFinishDate();
		this.priority = orderService.getPriority().getCode();
		this.observation = orderService.getObservation();
		this.status = orderService.getStatus().getCode();
		this.technician = new TechnicianDTO(orderService.getTechnician());
		this.client = new ClientDTO(orderService.getClient());
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

	public TechnicianDTO getTechnician() {
		return technician;
	}

	public void setTechnician(TechnicianDTO technician) {
		this.technician = technician;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
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
		OrderServiceDTO other = (OrderServiceDTO) obj;
		return Objects.equals(id, other.id);
	}

}
