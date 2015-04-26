package nakir.ppvis.trains.delete;

import nakir.ppvis.trains.Paginator;
import nakir.ppvis.trains.TrainDialog;
import nakir.ppvis.trains.model.TrainModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeleteTrainDialog extends TrainDialog {

    public DeleteTrainDialog(final JFrame owner, final Paginator model) {
        super(owner, model);
        setSize(new Dimension(700, 200));

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TrainModel> modelList = model.getTrainSchedule();
                int numberOfDeleted = 0;

                for (int rowNumber = 0; rowNumber < modelList.size(); rowNumber++) {
                    TrainModel train = modelList.get(rowNumber);
                    int numberOfActivated = 0;
                    int numberOfMatching = 0;

                    if (!trainNumber.getText().isEmpty()) {
                        numberOfActivated++;
                        if (train.trainNumber == new Integer(trainNumber.getText())) {
                            numberOfMatching++;
                        }
                    }
                    if (!dispatchStation.getText().isEmpty()) {
                        numberOfActivated++;
                        if (dispatchStation.getText().equals(train.dispatchStation)) {
                            numberOfMatching++;
                        }
                    }
                    if (!arrivalStation.getText().isEmpty()) {
                        numberOfActivated++;
                        if (arrivalStation.getText().equals(train.arrivalStation)) {
                            numberOfMatching++;
                        }
                    }
                    if (departureDateStart.getDate().before(departureDateEnd.getDate())) {
                        numberOfActivated++;
                        if (departureDateStart.getDate().before(train.departureDate) &&
                                train.departureDate.before(departureDateEnd.getDate())) {
                            numberOfMatching++;
                        }
                    }
                    if (arrivalDateStart.getDate().before(arrivalDateEnd.getDate())) {
                        numberOfActivated++;
                        if (arrivalDateStart.getDate().before(train.arrivalDate) &&
                                train.arrivalDate.before(arrivalDateEnd.getDate())) {
                            numberOfMatching++;
                        }
                    }
                    System.out.println(numberOfActivated + " " + numberOfMatching);
                    if (numberOfActivated == numberOfMatching) {
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