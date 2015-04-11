package nakir.ppvis.trains.filelisteners;

import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewFileListener implements ActionListener {
    private TrainTableModel model;

    public NewFileListener(TrainTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.replaceList(new ArrayList<TrainModel>());
    }
}