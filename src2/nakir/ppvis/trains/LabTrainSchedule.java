package nakir.ppvis.trains;

import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 31.03.2015.
 */
public class LabTrainSchedule {
    private TrainTableModel trainList = new TrainTableModel();
    private MainWindow mainWindow = new MainWindow(trainList);

    public LabTrainSchedule() {}

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LabTrainSchedule lab = new LabTrainSchedule();
            }
        });
    }
}
