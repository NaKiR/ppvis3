package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 14.03.2015.
 */
public class RunningListener implements ActionListener {
    private JComponent component;
    static Boolean isRunning = false;
    private String sourceText;
    private int shift = 0;

    public RunningListener(JComponent component, String string) {
        this.component = component;
        sourceText = string;
    }

    public void actionPerformed(ActionEvent e) {
        if (!isRunning) return;
        if (component.getClass() == RunningButton.class) {
            RunningButton button = (RunningButton)component;
            button.setText(getShiftedString());
        } else if (component.getClass() == RunningLabel.class) {
            RunningLabel label = (RunningLabel)component;
            label.setText(getShiftedString());
        } else if (component.getClass() == RunningRadioButton.class) {
            RunningRadioButton radioButton = (RunningRadioButton)component;
            radioButton.setText(getShiftedString());
        } else if (component.getClass() == RunningCheckBox.class) {
            RunningCheckBox checkBox = (RunningCheckBox)component;
            checkBox.setText(getShiftedString());
        }


    }

    private String getShiftedString() {
        String shiftedText = sourceText + " " + sourceText;
        if (shift + sourceText.length() < shiftedText.length()) {
            String tmpString = shiftedText.substring(shift, shift + sourceText.length());
            shift++;
            return tmpString;
        } else {
            shift = 0;
            String tmpString = shiftedText.substring(shift, shift + sourceText.length());
            shift++;
            return tmpString;
        }
    }
}
