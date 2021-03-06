package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * Created by NotePad on 21.02.2015.
 */
public class RadioButtonChooser extends Container{
    private RunningButton button = new RunningButton("Добавить");
    private JTextField input = new JTextField("", 10);
    private RunningLabel label = new RunningLabel("Ввод:");
    private ButtonGroup group = new ButtonGroup();
    private RunningRadioButton checkButton1 = new RunningRadioButton("Button1");
    private RunningRadioButton checkButton2 = new RunningRadioButton("Button2");
    private RunningRadioButton checkButton3 = new RunningRadioButton("Button3");
    private final int HEIGHT = 25;

    public RadioButtonChooser() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        input.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(input);
        button.addActionListener(new ButtonEventListener());
        button.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(button);
        group.add(checkButton1);
        group.add(checkButton2);
        group.add(checkButton3);
        this.add(checkButton1);
        this.add(checkButton2);
        this.add(checkButton3);
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            boolean ifExist = false;
            for (Enumeration<AbstractButton> buttons = group.getElements(); buttons
                    .hasMoreElements();) {
                AbstractButton tmpButton = buttons.nextElement();
                if (tmpButton.getText().equals(input.getText())) {
                    ifExist = true;
                    tmpButton.setSelected(true);
                }
            }
            if (!ifExist) {
                JOptionPane.showMessageDialog(null, "Кнопка с таким именем не найдена!",
                        "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}
