package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 04.03.2015.
 */
public class RunningCheckBox extends JCheckBox {

    public RunningCheckBox(String checkBoxName) {

        setText(checkBoxName);
        setFont(new Font("Lucida Console", Font.PLAIN, 14));
        Timer timer = new Timer(100, new RunningListener(this, this.getText()));
        timer.start();

    }
}

