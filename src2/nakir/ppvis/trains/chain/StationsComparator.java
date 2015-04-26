package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

/**
 * Created by NotePad on 12.04.2015.
 */
public class StationsComparator extends DefaultComparator implements Comparator {

    public StationsComparator(TrainModel train, SearchTrainModel searchedTrain) {
        super(train, searchedTrain);
    }

    public Boolean handle() {
        if ((searchedTrain.arrivalStation == train.arrivalStation ||
                    searchedTrain.arrivalStation.isEmpty()) &&
                (searchedTrain.dispatchStation == train.dispatchStation ||
                    searchedTrain.dispatchStation.isEmpty())) {
            if (comparator != null) {
                return comparator.handle();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}