package nakir.ppvis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * Created by NotePad on 21.02.2015.
 */
public class CheckBoxChooser extends Container{
    private JButton button = new JButton("Add");
    private JTextField input = new JTextField("", 10);
    private JLabel label = new JLabel("Input:");
    private JCheckBox checkButton1 = new JCheckBox("Button1");
    private JCheckBox checkButton2 = new JCheckBox("Button2");
    private JCheckBox checkButton3 = new JCheckBox("Button3");
    private JCheckBox[] checkboxes = new JCheckBox[] {checkButton1, checkButton2, checkButton3};

    public CheckBoxChooser() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        this.add(input);
        button.addActionListener(new ButtonEventListener());
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