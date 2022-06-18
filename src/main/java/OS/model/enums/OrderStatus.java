package OS.model.enums;

public enum OrderStatus {
	ABERTO(1,"ABERTO"),
	EM_ANDAMENTO(2,"EM ANDAMENTO"),
	ENCERRADO(3, "ENCERRADO");
	
	private Integer code;
	private String describ;
	
	private OrderStatus(int code,String describ) {
		this.code = code;
		this.describ = describ;
	}

	
	public Integer getCode() {
		return code;
	}
	
	public String getDescrib() {
		return describ;
	}
	
	public static OrderStatus valueOf(Integer code) {
		for (OrderStatus orderStatus:OrderStatus.values()) {
			if(code.equals(orderStatus.getCode())) {
				return orderStatus;
			}
		}
		throw new IllegalArgumentException("Invalid Status code");
		
	}


	
	
	
}
