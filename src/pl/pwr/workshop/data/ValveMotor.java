package pl.pwr.workshop.data;

public class ValveMotor extends StoredItem {
    /**
     *
     */
    private static final long serialVersionUID = -5134199479882998510L;
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ValveMotor(String name, String type, int quantity) {
        super(name, quantity);
        this.type = type;
    }

    public ValveMotor() {
        super();
    }

}
