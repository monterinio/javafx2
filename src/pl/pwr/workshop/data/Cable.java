package pl.pwr.workshop.data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cable extends PipeCable {
	private SimpleIntegerProperty noOfWires;
	private SimpleDoubleProperty crossSection;
	private SimpleStringProperty fullName;

	public int getNoOfWires() {
		return noOfWires.get();
	}
	public void setNoOfWires(int noOfWires) {
		this.noOfWires = new SimpleIntegerProperty(noOfWires);
	}
	public double getCrossSection() {
		return crossSection.get();
	}
	public void setCrossSection(double crossSection) {
		this.crossSection = new SimpleDoubleProperty(crossSection);
	}
	public String getFullName() {
		return fullName.get();
	}
	public void setFullName(String fullName) {
		this.fullName = new SimpleStringProperty(fullName);
	}
	public Cable(String name, int noOfWires, double crossSection, int quantity) {
		super(name, quantity);
		this.noOfWires = new SimpleIntegerProperty(noOfWires);
		this.crossSection = new SimpleDoubleProperty(crossSection);
		this.setFullName(this.name.get() + " " + this.noOfWires.get() + "x" + this.crossSection.get() + "mm2");
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
		Cable other = (Cable) obj;
		if (fullName.get() == null) {
			if (other.fullName.get() != null)
				return false;
		} else if (!fullName.get().equals(other.fullName.get()))
			return false;
		return true;
	}

}
