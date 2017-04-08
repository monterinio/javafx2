package pl.pwr.workshop.data;

public class Cable extends PipeCable {
    private static final long serialVersionUID = 3219765238868102029L;
    private int noOfWires;
    private double crossSection;

    public int getNoOfWires() {
        return noOfWires;
    }

    public void setNoOfWires(int noOfWires) {
        this.noOfWires = noOfWires;
    }

    public double getCrossSection() {
        return crossSection;
    }

    public void setCrossSection(double crossSection) {
        this.crossSection = crossSection;
    }

    public Cable(String name, int noOfWires, double crossSection, int quantity) {
        super(name, quantity);
        this.noOfWires = noOfWires;
        this.crossSection = crossSection;
        this.setFullName(this.name + " " + this.noOfWires + "x" + this.crossSection + "mm2");
    }

}
