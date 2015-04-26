package nakir.ppvis.trains.chain;

import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

public interface Comparator {
    public Boolean handle(TrainModel train, SearchTrainModel searchedTrain);
}
