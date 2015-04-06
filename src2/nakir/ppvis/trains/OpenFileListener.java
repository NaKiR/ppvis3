package nakir.ppvis.trains;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by NotePad on 06.04.2015.
 */
public class OpenFileListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openFile = new JFileChooser();
        int retrieval = openFile.showDialog(null, "Open file");
        if (retrieval == JFileChooser.APPROVE_OPTION) {
            File file = openFile.getSelectedFile();
        }
    }
}