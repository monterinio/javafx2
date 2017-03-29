package pl.pwr.workshop.data;

public abstract class ValveMotor extends StoredItem {
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
