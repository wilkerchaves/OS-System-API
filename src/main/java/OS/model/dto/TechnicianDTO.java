package OS.model.dto;

import java.io.Serializable;
import java.util.Objects;

import OS.model.Technician;


public class TechnicianDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String cpf;
	private String phone;
	public TechnicianDTO() {
	
	}
	public TechnicianDTO(Technician technician) {
		super();
		this.id = technician.getId();
		this.name = technician.getName();
		this.cpf = technician.getCpf();
		this.phone = technician.getPhone();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
		TechnicianDTO other = (TechnicianDTO) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "TechnicianDTO [id=" + id + ", name=" + name + ", cpf=" + cpf + ", phone=" + phone + "]";
	}
	
	
	

}
