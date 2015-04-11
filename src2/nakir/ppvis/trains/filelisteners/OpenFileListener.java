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
import java.util.List;

public class OpenFileListener implements ActionListener {
    private TrainTableModel model;

    public OpenFileListener(TrainTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openFile = new JFileChooser();
        int retrieval = openFile.showDialog(null, "Open file");
        if (retrieval == JFileChooser.APPROVE_OPTION) {
            try {
                File file = openFile.getSelectedFile();
                XStream xstream = new XStream(new StaxDriver());
                xstream.alias("train", TrainModel.class);
                model.replaceList((List<TrainModel>) xstream.fromXML(new FileInputStream(file)));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}