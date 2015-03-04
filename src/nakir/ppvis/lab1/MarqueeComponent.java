package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 03.03.2015.
 */
public class MarqueeComponent extends Container {
    private RunningButton marqueeButton = new RunningButton("Больше бегущих строк!");
    private RunningButton stopButton = new RunningButton("Хватит!");


    public MarqueeComponent() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        marqueeButton.addActionListener(new MarqueeButtonEventListener());
        marqueeButton.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        this.add(marqueeButton);
        stopButton.addActionListener(new StopButtonEventListener());
        stopButton.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        this.add(stopButton);
    }

    class MarqueeButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            RunningButton.isRunning = true;
            RunningLabel.isRunning = true;
            RunningRadioButton.isRunning = true;
            RunningCheckBox.isRunning = true;
        }
    }

    class StopButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            RunningButton.isRunning = false;
            RunningLabel.isRunning = false;
            RunningRadioButton.isRunning = false;
            RunningCheckBox.isRunning = false;
        }
    }
}

