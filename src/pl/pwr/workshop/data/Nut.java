package pl.pwr.workshop.data;

import javafx.beans.property.SimpleStringProperty;

public class Nut extends Element {

	private SimpleStringProperty fullName;
	public Nut(String name, String type, String threadType, int quantity) {
		super(name, type, threadType, quantity);
		this.setFullName(this.name.get() + "; " + this.getType() + "; " + this.getThreadType());
	}
	public String getFullName() {
		return fullName.get();
	}
	public void setFullName(String fullName) {
		this.fullName = new SimpleStringProperty(fullName);
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
		Nut other = (Nut) obj;
		if (fullName.get() == null) {
			if (other.fullName.get() != null)
				return false;
		} else if (!fullName.get().equals(other.fullName.get()))
			return false;
		return true;
	}


}
