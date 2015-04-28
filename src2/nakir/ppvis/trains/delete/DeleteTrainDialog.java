package nakir.ppvis.trains.delete;

import nakir.ppvis.trains.Paginator;
import nakir.ppvis.trains.TrainDialog;
import nakir.ppvis.trains.chain.*;
import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteTrainDialog extends TrainDialog {

    public DeleteTrainDialog(final JFrame owner, final Paginator model) {
        super(owner, "Delete");
        setSize(new Dimension(700, 200));

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TrainModel> modelList = model.getTrainSchedule();
                int numberOfDeleted = 0;

                for (int rowNumber = 0; rowNumber < modelList.size(); rowNumber++) {
                    TrainModel train = modelList.get(rowNumber);
                    SearchTrainModel searchedTrain = new SearchTrainModel();
                    try {
                        searchedTrain.trainNumber = new Integer(trainNumber.getText());
                    } catch (NumberFormatException ex) {
                        searchedTrain.trainNumber = 0;
                    }
                    searchedTrain.dispatchStation = dispatchStation.getText();
                    searchedTrain.arrivalStation = arrivalStation.getText();
                    searchedTrain.departureDate = departureDateStart.getDate();
                    searchedTrain.arrivalDate = arrivalDateStart.getDate();
                    searchedTrain.departureDateEnd = departureDateEnd.getDate();
                    searchedTrain.arrivalDateEnd = arrivalDateEnd.getDate();

                    DefaultComparator comparator = new DefaultComparator(train, searchedTrain).add(
                            new TrainNumberComparator(train, searchedTrain).add(
                                    new StationsComparator(train, searchedTrain).add(
                                            new DepartureDateComparator(train, searchedTrain).add(
                                                    new ArrivalDateComparator(train, searchedTrain)
                                            )
                                    )
                            )
                    );
                    if (comparator.handle()) {
                        model.delete(train);
                        numberOfDeleted++;
                        rowNumber--;
                    }
                }
                JOptionPane.showMessageDialog(null, "Number of deleted trains: " + numberOfDeleted);
                setVisible(false);
            }
        });
    }
}