package pl.pwr.workshop.data;

public class Pipe extends PipeCable {
    private static final long serialVersionUID = -3471007474157705975L;
    private String material;
    private Integer diameter;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void addQuantity(Pipe pipe) {
        this.quantity = (this.getQuantity() + pipe.getQuantity());
    }

    public Pipe(String name, String material, int diameter, int length) {
        super(name, length);
        this.material = material;
        this.diameter = diameter;
        this.setFullName(this.name + ", mat." + this.material + ", fi." + this.diameter);
    }

}
