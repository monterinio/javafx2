package pl.pwr.workshop.data;

public class Motor extends ValveMotor {
	private String type;
	private double power;

	public double getPower() {
		return power;
	}
	public void setPower(double power) {
		this.power = power;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Motor(String name, String type, double power, int quantity) {
		super(name, quantity);
		this.type = type;
		this.power = power;
	}
}
