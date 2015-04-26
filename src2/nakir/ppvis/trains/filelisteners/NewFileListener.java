package nakir.ppvis.trains.filelisteners;

import nakir.ppvis.trains.Paginator;
import nakir.ppvis.trains.model.TrainModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewFileListener implements ActionListener {
    private Paginator model;

    public NewFileListener(Paginator model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.replaceList(new ArrayList<TrainModel>());
    }
}