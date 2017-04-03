package pl.pwr.workshop.data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Cable extends PipeCable {
	private SimpleIntegerProperty noOfWires;
	private SimpleDoubleProperty crossSection;
	private String fullName;

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
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Cable(String name, int noOfWires, double crossSection, int quantity) {
		super(name, quantity);
		this.noOfWires = new SimpleIntegerProperty(noOfWires);
		this.crossSection = new SimpleDoubleProperty(crossSection);
		this.setFullName(this.name.get() + " " + this.noOfWires.get() + "x" + this.crossSection.get() + "mm2");
	}
}
