package pl.pwr.workshop.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Valve extends ValveMotor {

    private SimpleIntegerProperty size;

    public int getSize() {
        return size.get();
    }

    public void setSize(int size) {
        this.size = new SimpleIntegerProperty(size);
    }

    public Valve(String name, String type, int size, int quantity) {
        super(name, type, quantity);
        this.type = new SimpleStringProperty(type);
        this.size = new SimpleIntegerProperty(size);
        this.setFullName(this.name.get() + "; typ:" + this.type.get() + "; rozm:" + this.size.get());
    }

}
