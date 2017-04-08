package pl.pwr.workshop.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pipe extends PipeCable {
    private SimpleStringProperty material;
    private SimpleIntegerProperty diameter;

    public String getMaterial() {
        return material.get();
    }

    public void setMaterial(String material) {
        this.material = new SimpleStringProperty(material);
    }

    public int getDiameter() {
        return diameter.get();
    }

    public void setDiameter(int diameter) {
        this.diameter = new SimpleIntegerProperty(diameter);
    }

    public void addQuantity(Pipe pipe) {
        this.quantity.set(this.getQuantity() + pipe.getQuantity());
    }

    public Pipe(String name, String material, int diameter, int length) {
        super(name, length);
        this.material = new SimpleStringProperty(material);
        this.diameter = new SimpleIntegerProperty(diameter);
        this.setFullName(this.name.get() + ", mat." + this.material.get() + ", fi." + this.diameter.get());
    }

}
