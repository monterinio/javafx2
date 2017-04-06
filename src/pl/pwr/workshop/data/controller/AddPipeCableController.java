package pl.pwr.workshop.data.controller;

import javafx.collections.ObservableList;
import pl.pwr.workshop.data.Data;
import pl.pwr.workshop.data.PipeCable;

public interface AddPipeCableController {

	default public void addItemAndCheckForExistence(PipeCable pipeCable, Data data) {
		boolean itemAdded = true;
		ObservableList<PipeCable> pipeCableList = data.getPipeCableList();
		for(int i=0;i<pipeCableList.size();i++) {
			PipeCable currentPipeCable = pipeCableList.get(i);
			if(currentPipeCable.equals(pipeCable)) {
				currentPipeCable.addQuantity(pipeCable);
				itemAdded = false;
			}
		}
		if(itemAdded) {
			pipeCableList.add(pipeCable);
		}
	}

}
