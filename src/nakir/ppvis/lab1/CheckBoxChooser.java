package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 21.02.2015.
 */
public class CheckBoxChooser extends Container{
    private RunningButton button = new RunningButton("Добавить");
    private JTextField input = new JTextField("", 10);
    private RunningLabel label = new RunningLabel("Ввод:");
    private RunningCheckBox checkButton1 = new RunningCheckBox("Button1");
    private RunningCheckBox checkButton2 = new RunningCheckBox("Button2");
    private RunningCheckBox checkButton3 = new RunningCheckBox("Button3");
    private RunningCheckBox[] checkboxes = new RunningCheckBox[] {checkButton1, checkButton2, checkButton3};
    private final int HEIGHT = 25;

    public CheckBoxChooser() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        input.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(input);
        button.addActionListener(new ButtonEventListener());
        button.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(button);
        this.add(checkButton1);
        this.add(checkButton2);
        this.add(checkButton3);
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            boolean ifExist = false;
            for (JCheckBox checkBox : checkboxes) {
                if (checkBox.getText().equals(input.getText())) {
                    ifExist = true;
                    checkBox.setSelected(!checkBox.isSelected());
                }
            }
            if (!ifExist) {
                JOptionPane.showMessageDialog(null, "Кнопка с таким именем не найдена!",
                        "Error!", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}