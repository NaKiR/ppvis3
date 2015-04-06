package nakir.ppvis.trains.delete;

import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTrainListener implements ActionListener {
    private TrainTableModel model;

    public DeleteTrainListener(TrainTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog newEntryDialog = new DeleteTrainDialog(null, model);
        newEntryDialog.setVisible(true);
    }
}
