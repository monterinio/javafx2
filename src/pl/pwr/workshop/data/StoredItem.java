package pl.pwr.workshop.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class StoredItem {
    protected SimpleStringProperty name;
    protected SimpleIntegerProperty quantity;
    protected SimpleStringProperty fullName;

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName = new SimpleStringProperty(fullName);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public StoredItem(String name, int quantity) {
        this.name = new SimpleStringProperty(name);
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public void addQuantity(StoredItem storedItem) {
        this.quantity.set(this.getQuantity() + storedItem.getQuantity());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fullName.get() == null) ? 0 : fullName.get().hashCode());
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
        if (fullName.get() == null) {
            if (other.fullName.get() != null)
                return false;
        } else if (!fullName.get().equals(other.fullName.get()))
            return false;
        return true;
    }

}
