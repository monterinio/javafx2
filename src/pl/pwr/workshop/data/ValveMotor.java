package pl.pwr.workshop.data;

import javafx.beans.property.SimpleStringProperty;

public class ValveMotor extends StoredItem {
    protected SimpleStringProperty type;

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }

    public ValveMotor(String name, String type, int quantity) {
        super(name, quantity);
        this.type = new SimpleStringProperty(type);
    }

}
