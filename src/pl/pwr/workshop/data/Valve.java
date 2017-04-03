package pl.pwr.workshop.data;

public class Valve extends ValveMotor {
	private String type;
	private int size;

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Valve(String name, String type, int size, int quantity) {
		super(name, quantity);
		this.type = type;
		this.size = size;
	}
}
