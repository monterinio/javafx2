package pl.pwr.workshop.data;

public abstract class Element extends StoredItem {
	private int quantity;
	private String type;
	private String threadType;

	public String getThreadType() {
		return threadType;
	}
	public void setThreadType(String threadType) {
		this.threadType = threadType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
