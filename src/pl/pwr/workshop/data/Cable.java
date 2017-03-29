package pl.pwr.workshop.data;

public class Cable extends PipeCable {
	private String crossSection;
	private String noOfWires;

	public String getNoOfWires() {
		return noOfWires;
	}
	public void setNoOfWires(String noOfWires) {
		this.noOfWires = noOfWires;
	}
	public String getCrossSection() {
		return crossSection;
	}
	public void setCrossSection(String crossSection) {
		this.crossSection = crossSection;
	}
}
