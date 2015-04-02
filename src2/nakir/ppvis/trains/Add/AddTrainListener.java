package nakir.ppvis.trains.Add;

import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 26.03.2015.
 */
public class AddTrainListener implements ActionListener {
    private TrainTableModel model;

    public AddTrainListener(TrainTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog newEntryDialog = new AddTrainDialog(null, model);
        newEntryDialog.setVisible(true);
    }
}
