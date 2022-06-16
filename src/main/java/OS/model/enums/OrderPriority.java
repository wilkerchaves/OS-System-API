package OS.model.enums;

public enum OrderPriority {
	BAIXA(1),
	MÉDIA(2),
	ALTA(3);
	
	private int code;
	
	private OrderPriority(int code) {
		this.code = code;
	}

	
	public int getCode() {
		return code;
	}
	
	public static OrderPriority valueOf(Integer code) {
		for (OrderPriority priority:OrderPriority.values()) {
			if(code.equals(priority.getCode())) {
				return priority;
			}
		}
		throw new IllegalArgumentException("Invalid Priority code");
		
	}
	
	
}
