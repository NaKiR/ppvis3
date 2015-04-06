package nakir.ppvis.trains.search;

import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchTrainListener implements ActionListener {
    private TrainTableModel model;

    public SearchTrainListener(TrainTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog newEntryDialog = new SearchTrainDialog(null, model);
        newEntryDialog.setVisible(true);
    }
}
