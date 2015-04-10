package nakir.ppvis.trains.filelisteners;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NotePad on 06.04.2015.
 */
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