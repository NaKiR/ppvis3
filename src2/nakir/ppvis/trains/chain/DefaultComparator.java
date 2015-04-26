package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

public class DefaultComparator implements Comparator {
    protected DefaultComparator comparator;
    protected TrainModel train;
    protected SearchTrainModel searchedTrain;

    public DefaultComparator(TrainModel train, SearchTrainModel searchedTrain) {
        this.train = train;
        this.searchedTrain = searchedTrain;
    }

    public Boolean handle() {
        if (comparator != null) {
            return comparator.handle();
        } else {
            return true;
        }
    }

    public DefaultComparator add(DefaultComparator comparator) {
        this.comparator = comparator;
        return this;
    }
}
