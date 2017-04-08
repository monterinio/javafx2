package pl.pwr.workshop.data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Motor extends ValveMotor {

    private SimpleDoubleProperty power;

    public double getPower() {
        return power.get();
    }

    public void setPower(double power) {
        this.power = new SimpleDoubleProperty(power);
    }

    public Motor(String name, String type, double power, int quantity) {
        super(name, type, quantity);
        this.type = new SimpleStringProperty(type);
        this.power = new SimpleDoubleProperty(power);
        this.setFullName(this.name.get() + "; typ:" + this.type.get() + ", " + this.power.get() + "kW");
    }
}
