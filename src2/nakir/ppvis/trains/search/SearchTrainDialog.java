package nakir.ppvis.trains.search;

import nakir.ppvis.trains.BottomPanel;
import nakir.ppvis.trains.Paginator;
import nakir.ppvis.trains.TrainDialog;
import nakir.ppvis.trains.chain.*;
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