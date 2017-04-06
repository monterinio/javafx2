package pl.pwr.workshop.data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Motor extends ValveMotor {
	private SimpleStringProperty type;
	private SimpleDoubleProperty power;
	private SimpleStringProperty fullName;

	public double getPower() {
		return power.get();
	}
	public void setPower(double power) {
		this.power = new SimpleDoubleProperty(power);
	}
	public String getType() {
		return type.get();
	}
	public void setType(String type) {
		this.type = new SimpleStringProperty(type);
	}
	public void setFullName(String fullName) {
		this.fullName = new SimpleStringProperty(fullName);
	}
	public String getFullName() {
		return fullName.get();
	}
	public Motor(String name, String type, double power, int quantity) {
		super(name, quantity);
		this.type = new SimpleStringProperty(type);
		this.power = new SimpleDoubleProperty(power);
		this.setFullName(this.name.get() + "; typ:" + getType() + ", " + getPower() + "kW");
	}
}
