package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

/**
 * Created by NotePad on 12.04.2015.
 */
public class TrainNumberComparator extends DefaultComparator implements Comparator {

    public TrainNumberComparator(TrainModel train, SearchTrainModel searchedTrain) {
        super(train, searchedTrain);
    }

    public Boolean handle() {
        if (searchedTrain.trainNumber == train.trainNumber || searchedTrain.trainNumber == 0) {
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
