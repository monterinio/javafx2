package pl.pwr.workshop.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderedItemsData {
    private ObservableList<StoredItem> orderedItemsList;

    public OrderedItemsData() {
        orderedItemsList = FXCollections.observableArrayList();
    }

    public ObservableList<StoredItem> getOrderedItemsList() {
        return orderedItemsList;
    }

    public void setOrderedItemsList(ObservableList<StoredItem> orderedItemsList) {
        this.orderedItemsList = orderedItemsList;
    }
}
