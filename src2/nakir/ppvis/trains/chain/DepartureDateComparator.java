package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

/**
 * Created by NotePad on 12.04.2015.
 */
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
