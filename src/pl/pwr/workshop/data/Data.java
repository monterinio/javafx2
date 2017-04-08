package pl.pwr.workshop.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data extends ApplicationData  {

    private ObservableList<PipeCable> pipeCableList;
    private ObservableList<Element> elementList;
    private ObservableList<ValveMotor> valveMotorList;

    public Data() {
        this.setPipeCableList(FXCollections.observableArrayList());
        this.setElementList(FXCollections.observableArrayList());
        this.setValveMotorList(FXCollections.observableArrayList());
    }

    public ObservableList<PipeCable> getPipeCableList() {
        return pipeCableList;
    }

    public ObservableList<Element> getElementList() {
        return elementList;
    }

    public ObservableList<ValveMotor> getValveMotorList() {
        return valveMotorList;
    }

    public void setPipeCableList(ObservableList<PipeCable> pipeCableList) {
        this.pipeCableList = pipeCableList;
    }

    public void setElementList(ObservableList<Element> elementList) {
        this.elementList = elementList;
    }

    public void setValveMotorList(ObservableList<ValveMotor> valveMotorList) {
        this.valveMotorList = valveMotorList;
    }

}