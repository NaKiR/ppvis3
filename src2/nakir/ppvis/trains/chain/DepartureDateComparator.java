package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

public class DepartureDateComparator extends DefaultComparator implements Comparator {

    public DepartureDateComparator(TrainModel train, SearchTrainModel searchedTrain) {
        super(train, searchedTrain);
    }

    public Boolean handle() {
        if ((searchedTrain.departureDate.before(train.departureDate) &&
                train.departureDate.before(searchedTrain.departureDateEnd)) ||
                searchedTrain.departureDateEnd.before(searchedTrain.departureDate)) {
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
