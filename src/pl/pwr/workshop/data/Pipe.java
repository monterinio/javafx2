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
	public void addQuantity(Pipe pipe) {
		this.quantity.set(this.getQuantity()+pipe.getQuantity());
	}
	public Pipe(String name, String material, int diameter, int length) {
		super(name, length);
		this.material = new SimpleStringProperty(material);
		this.diameter = new SimpleIntegerProperty(diameter);
		this.setFullName(this.name.get() + " " + this.material.get() + " " + this.getDiameter());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pipe other = (Pipe) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		return true;
	}
}
