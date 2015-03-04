package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 04.03.2015.
 */
class RunningButton extends JButton {
    static Boolean isRunning = false;
    private String string;
    private int i = 0;

    public RunningButton(String buttonName) {

        setText(buttonName);
        setFont(new Font("Lucida Console", Font.PLAIN, 14));
        string =  getText() + " " + getText();
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRunning) return;
                    if (i + getText().length() < string.length()) {
                        String tmpString = string.substring(i, i + getText().length());
                        setText(tmpString);
                        i++;
                    } else {
                        i = 0;
                        String tmpString = string.substring(i, i + getText().length());
                        setText(tmpString);
                        i++;
                    }
            }
        });
        timer.start();

    }
}
