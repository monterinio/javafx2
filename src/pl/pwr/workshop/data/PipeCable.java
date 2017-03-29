package pl.pwr.workshop.data;

public abstract class PipeCable extends StoredItem {
	private int length;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
