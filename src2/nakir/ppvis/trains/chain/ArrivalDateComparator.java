package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

public class ArrivalDateComparator extends DefaultComparator implements Comparator {

    public ArrivalDateComparator(TrainModel train, SearchTrainModel searchedTrain) {
        super(train, searchedTrain);
    }

    public Boolean handle() {
        if ((searchedTrain.arrivalDate.before(train.arrivalDate) &&
                train.arrivalDate.before(searchedTrain.arrivalDateEnd)) ||
                searchedTrain.arrivalDateEnd.before(searchedTrain.arrivalDate)) {
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
