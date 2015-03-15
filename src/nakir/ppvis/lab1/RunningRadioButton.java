package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 04.03.2015.
 */
public class RunningRadioButton extends JRadioButton {

    public RunningRadioButton(String radioButtonName) {

        setText(radioButtonName);
        setFont(new Font("Lucida Console", Font.PLAIN, 14));
        Timer timer = new Timer(100, new RunningListener(this, this.getText()));
        timer.start();

    }
}
