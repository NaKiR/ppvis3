package nakir.ppvis.trains.delete;

import nakir.ppvis.trains.Paginator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTrainListener implements ActionListener {
    private Paginator model;

    public DeleteTrainListener(Paginator model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog newEntryDialog = new DeleteTrainDialog(null, model);
        newEntryDialog.setVisible(true);
    }
}
