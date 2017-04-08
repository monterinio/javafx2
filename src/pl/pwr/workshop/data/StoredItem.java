package pl.pwr.workshop.data;

import java.io.Serializable;

public abstract class StoredItem implements Serializable {
    private static final long serialVersionUID = 2828267035950011607L;
    protected String name;
    protected int quantity;
    protected String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StoredItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void addQuantity(StoredItem storedItem) {
        this.quantity = (this.getQuantity() + storedItem.getQuantity());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StoredItem other = (StoredItem) obj;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        return true;
    }



}
