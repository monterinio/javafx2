package pl.pwr.workshop.data;

public class Valve extends ValveMotor {
    private static final long serialVersionUID = -3914772461685191925L;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Valve(String name, String type, int size, int quantity) {
        super(name, type, quantity);
        this.size = size;
        this.setFullName(this.name + "; typ:" + this.type + "; rozm:" + this.size);
    }

}
