package pl.pwr.workshop.data;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Data implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ObservableList<PipeCable> pipeCableList;
	private ObservableList<Element> elementList;
	private ObservableList<ValveMotor> valveMotorList;

	public Data() {
		this.pipeCableList = FXCollections.observableArrayList();
		this.elementList = FXCollections.observableArrayList();
		this.valveMotorList = FXCollections.observableArrayList();
	}

	public ObservableList<PipeCable> getPipeCableList() {
		return pipeCableList;
	}

	public void setPipeCableList(ObservableList<PipeCable> pipeCableList) {
		this.pipeCableList = pipeCableList;
	}

	public ObservableList<Element> getElementList() {
		return elementList;
	}

	public void setElementList(ObservableList<Element> elementList) {
		this.elementList = elementList;
	}

	public ObservableList<ValveMotor> getValveMotorList() {
		return valveMotorList;
	}

	public void setValveMotorList(ObservableList<ValveMotor> valveMotorList) {
		this.valveMotorList = valveMotorList;
	}

}