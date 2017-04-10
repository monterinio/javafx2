package pl.pwr.workshop.data;

public class OrderedStoredItemsParameters {
    private int orderedItemQuantity;
    private int storedItemQuantity;
    private String orderedItemFullName;
    private String storedItemFullName;

    public int getOrderedItemQuantity() {
        return orderedItemQuantity;
    }

    public void setOrderedItemQuantity(int orderedItemQuantity) {
        this.orderedItemQuantity = orderedItemQuantity;
    }

    public int getStoredItemQuantity() {
        return storedItemQuantity;
    }

    public void setStoredItemQuantity(int storedItemQuantity) {
        this.storedItemQuantity = storedItemQuantity;
    }

    public String getOrderedItemFullName() {
        return orderedItemFullName;
    }

    public void setOrderedItemFullName(String orderedItemFullName) {
        this.orderedItemFullName = orderedItemFullName;
    }

    public String getStoredItemFullName() {
        return storedItemFullName;
    }

    public void setStoredItemFullName(String storedItemFullName) {
        this.storedItemFullName = storedItemFullName;
    }

    public OrderedStoredItemsParameters(StoredItem rowData) {
        storedItemQuantity = 0;
        orderedItemQuantity = rowData.getQuantity();
        orderedItemFullName = rowData.getFullName();
        storedItemFullName = null;
    }

    public boolean isEqual() {
        return storedItemFullName.equals(orderedItemFullName);
    }

    public int calculateSum() {
        return storedItemQuantity + orderedItemQuantity;
    }
}
