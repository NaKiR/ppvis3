package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 04.03.2015.
 */
public class RunningLabel extends JLabel{

    public RunningLabel(String labelName) {

        setText(labelName);
        setFont(new Font("Lucida Console", Font.PLAIN, 14));
        Timer timer = new Timer(100, new RunningListener(this, this.getText()));
        timer.start();

    }
}
