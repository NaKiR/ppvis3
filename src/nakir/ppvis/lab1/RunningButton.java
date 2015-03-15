package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 04.03.2015.
 */
class RunningButton extends JButton {

    public RunningButton(String buttonName) {

        setText(buttonName);
        setFont(new Font("Lucida Console", Font.PLAIN, 14));
        Timer timer = new Timer(100, new RunningListener(this,this.getText()));
        timer.start();

    }
}
