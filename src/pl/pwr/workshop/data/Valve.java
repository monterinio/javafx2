package pl.pwr.workshop.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Valve extends ValveMotor {
	private SimpleStringProperty type;
	private SimpleIntegerProperty size;
	private SimpleStringProperty fullName;

	public int getSize() {
		return size.get();
	}
	public void setSize(int size) {
		this.size = new SimpleIntegerProperty(size);
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
	public Valve(String name, String type, int size, int quantity) {
		super(name, quantity);
		this.type = new SimpleStringProperty(type);
		this.size = new SimpleIntegerProperty(size);
		this.setFullName(this.name.get() + "; typ:" + getType() + "; rozm:" + getSize());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fullName.get() == null) ? 0 : fullName.get().hashCode());
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
		Valve other = (Valve) obj;
		if (fullName.get() == null) {
			if (other.fullName.get() != null)
				return false;
		} else if (!fullName.get().equals(other.fullName.get()))
			return false;
		return true;
	}

}
