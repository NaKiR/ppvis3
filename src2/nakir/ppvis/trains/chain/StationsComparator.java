package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

public class StationsComparator extends DefaultComparator implements Comparator {

    public StationsComparator(TrainModel train, SearchTrainModel searchedTrain) {
        super(train, searchedTrain);
    }

    public Boolean handle() {
        if ((searchedTrain.arrivalStation.equals(train.arrivalStation) ||
                    searchedTrain.arrivalStation.isEmpty()) &&
                (searchedTrain.dispatchStation.equals(train.dispatchStation) ||
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
