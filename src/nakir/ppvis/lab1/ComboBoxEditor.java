package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 21.02.2015.
 */
public class ComboBoxEditor extends Container {
    private String[] comboBoxItems = new String[] {""};
    private JButton button = new JButton("Add");
    private JTextField input = new JTextField("", 10);
    private JLabel label = new JLabel("Input:");
    private JComboBox comboBox = new JComboBox(comboBoxItems);
    private final int HEIGHT = 25;

    public ComboBoxEditor() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        input.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(input);
        button.addActionListener(new ButtonEventListener());
        button.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(button);
        comboBox.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(comboBox);
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            boolean ifExist = false;
            String newItem = input.getText();
            for (int itemIndex = 0; itemIndex < comboBox.getItemCount(); itemIndex++) {
                if (comboBox.getItemAt(itemIndex).equals(newItem)) {
                    ifExist = true;
                }
            }
            if (ifExist) {
                JOptionPane.showMessageDialog(null, "Данная строка уже включена!",
                        "Error!", JOptionPane.PLAIN_MESSAGE);
            } else {
                comboBox.addItem(newItem);
            }
        }
    }
}
