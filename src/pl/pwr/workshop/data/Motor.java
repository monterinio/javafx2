package pl.pwr.workshop.data;

public class Motor extends ValveMotor {

    private static final long serialVersionUID = 3668823865949875952L;
    private double power;

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Motor(String name, String type, double power, int quantity) {
        super(name, type, quantity);
        this.power = power;
        this.setFullName(this.name + "; typ:" + this.type + ", " + this.power + "kW");
    }
}
