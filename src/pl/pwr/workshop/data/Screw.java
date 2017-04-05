package pl.pwr.workshop.data;

public class Screw extends Element {

	private String fullName;
	public Screw(String name, String type, String threadType, int quantity) {
		super(name, type, threadType, quantity);
		this.setFullName(this.name.get() + " " + this.getType() + " " + this.getThreadType());
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
