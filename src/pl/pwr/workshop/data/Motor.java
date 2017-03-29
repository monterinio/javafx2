package pl.pwr.workshop.data;

public class Motor extends ValveMotor {
	private String power;
	private String type;

	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
