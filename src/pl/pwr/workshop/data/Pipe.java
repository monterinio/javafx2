package pl.pwr.workshop.data;

public class Pipe extends PipeCable {
	private String material;
	private String diameter;

	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
}
