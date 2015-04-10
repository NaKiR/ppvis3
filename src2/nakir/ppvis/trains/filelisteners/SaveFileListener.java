package nakir.ppvis.trains.filelisteners;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;

public class SaveFileListener implements ActionListener {
    private TrainTableModel model;

    public SaveFileListener(TrainTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JFileChooser saveFile = new JFileChooser();
            int retrieval = saveFile.showSaveDialog(null);
            if (retrieval == JFileChooser.APPROVE_OPTION) {
                File file = saveFile.getSelectedFile();
                if (!file.exists()) {
                    file.createNewFile();
                }

                XStream xstream = new XStream(new StaxDriver());
                xstream.alias("train", TrainModel.class);
                xstream.toXML(model.getTrainSchedule(), new FileOutputStream(file));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}