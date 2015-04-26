package nakir.ppvis.trains.search;

import nakir.ppvis.trains.BottomPanel;
import nakir.ppvis.trains.Paginator;
import nakir.ppvis.trains.TrainDialog;
import nakir.ppvis.trains.model.SearchTrainModel;
import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchTrainDialog extends TrainDialog {
    private TrainTableModel searchModel = new TrainTableModel();
    private Paginator searchPaginator = new Paginator(searchModel);


    public SearchTrainDialog(final JFrame owner, final Paginator model) {
        super(owner, model);
        setSize(new Dimension(700, 400));

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TrainModel> modelList = model.getTrainSchedule();
                for (TrainModel train : modelList) {
//                    SearchTrainModel searchedTrain = new SearchTrainModel();
//                    try {
//                        searchedTrain.trainNumber = new Integer(trainNumber.getText());
//                    } catch (NumberFormatException ex) {
//                        JOptionPane.showMessageDialog(null, "Incorrect train number!");
//                        return;
//                    }
//                    searchedTrain.dispatchStation = dispatchStation.getText();
//                    searchedTrain.arrivalStation = arrivalStation.getText();
//                    searchedTrain.departureDate = departureDateStart.getDate();
//                    searchedTrain.arrivalDate = arrivalDateStart.getDate();
//                    searchedTrain.departureDateEnd = departureDateEnd.getDate();
//                    searchedTrain.arrivalDateEnd = arrivalDateEnd.getDate();

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
                    if (numberOfActivated == numberOfMatching) {
                        searchPaginator.add(train);
                    }
                }
            }
        });

        Container contentPane = getContentPane();
        contentPane.add(new JScrollPane(new JTable(searchPaginator)), BorderLayout.CENTER);
        contentPane.add(new BottomPanel(searchPaginator), BorderLayout.SOUTH);
    }
}