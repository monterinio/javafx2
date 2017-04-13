package pl.pwr.workshop.data;

public class Element extends StoredItem {
    /**
     *
     */
    private static final long serialVersionUID = 2304545516574685651L;
    private String type;
    private String threadType;

    public String getThreadType() {
        return threadType;
    }

    public void setThreadType(String threadType) {
        this.threadType = threadType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Element(String name, String type, String threadType, int quantity) {
        super(name, quantity);
        this.type = type;
        this.threadType = threadType;
        this.setFullName(this.name + "; " + this.type + "; " + this.threadType);
    }

    public Element() {
    }

}
