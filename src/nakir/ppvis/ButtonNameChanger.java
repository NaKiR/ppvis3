package nakir.ppvis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 21.02.2015.
 */
public class ButtonNameChanger extends Container {
    private JLabel label = new JLabel("Input:");
    private JButton addButton = new JButton("Add");
    private JButton changeButton = new JButton("Something");
    private JTextField input = new JTextField("", 10);

    public ButtonNameChanger() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        this.add(input);
        addButton.addActionListener(new AddButtonEventListener());
        this.add(addButton);
        changeButton.addActionListener(new ChangeButtonEventListener());
        this.add(changeButton);
    }

    class AddButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            changeButton.setText(input.getText());
        }
    }

    class ChangeButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String addButtonName = addButton.getText();
            addButton.setText(changeButton.getText());
            changeButton.setText(addButtonName);
        }
    }
}