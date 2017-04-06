package pl.pwr.workshop.data;

import javafx.beans.property.SimpleStringProperty;

public class Element extends StoredItem {
	private SimpleStringProperty type;
	private SimpleStringProperty threadType;

	public String getThreadType() {
		return threadType.get();
	}
	public void setThreadType(String threadType) {
		this.threadType = new SimpleStringProperty(threadType);
	}
	public String getType() {
		return type.get();
	}
	public void setType(String type) {
		this.type = new SimpleStringProperty(type);
	}

	public Element(String name, String type, String threadType, int quantity) {
		super(name, quantity);
		this.type = new SimpleStringProperty(type);
		this.threadType = new SimpleStringProperty(threadType);
	}
}
