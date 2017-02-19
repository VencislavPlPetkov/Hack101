package DroneDeliverySystem.request;

public class Request {
	/**
	private String dateStamp;
	
	private int rowAdress;
	
	private int columnAdress;
	**/
	private int id;
	private int quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Request(int id, int quantity) {
		setId(id);
		setQuantity(quantity);
	}
}