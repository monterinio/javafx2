package pl.pwr.workshop.data.controller;
import javafx.collections.ObservableList;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.ValveMotor;

public interface AddValveMotorController {
	default public void addItemAndCheckForExistence(ValveMotor valveMotor, Data data) {
		boolean itemAdded = true;
		ObservableList<ValveMotor> valveMotorList = data.getValveMotorList();
		for(int i=0;i<valveMotorList.size();i++) {
			ValveMotor currentValveMotor = valveMotorList.get(i);
			if(currentValveMotor.equals(valveMotor)) {
				currentValveMotor.addQuantity(valveMotor);
				itemAdded = false;
			}
		}
		if(itemAdded) {
			valveMotorList.add(valveMotor);
		}
	}
}
