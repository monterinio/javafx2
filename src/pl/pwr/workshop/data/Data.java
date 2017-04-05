package pl.pwr.workshop.data;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

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

	public ObservableList<Element> getElementList() {
		return elementList;
	}

	public ObservableList<ValveMotor> getValveMotorList() {
		return valveMotorList;
	}

}