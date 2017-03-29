package pl.pwr.workshop.data;

public class Valve extends ValveMotor {
	private String type;
	private String dimension;

	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
