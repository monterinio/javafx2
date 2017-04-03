package pl.pwr.workshop.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pipe extends PipeCable {
	private SimpleStringProperty material;
	private SimpleIntegerProperty diameter;
	private String fullName;

	public String getMaterial() {
		return material.get();
	}
	public void setMaterial(String material) {
		this.material = new SimpleStringProperty(material);
	}
	public int getDiameter() {
		return diameter.get();
	}
	public void setDiameter(int diameter) {
		this.diameter = new SimpleIntegerProperty(diameter);
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Pipe(String name, String material, int diameter, int length) {
		super(name, length);
		this.material = new SimpleStringProperty(material);
		this.diameter = new SimpleIntegerProperty(diameter);
		this.setFullName(this.name.get() + " " + this.material.get() + " " + this.getDiameter());
	}
}
