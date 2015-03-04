package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 21.02.2015.
 */
public class ButtonNameChanger extends Container {
    private RunningLabel label = new RunningLabel("Ввод:");
    private RunningButton addButton = new RunningButton("Добавить");
    private RunningButton changeButton = new RunningButton("Имя кнопки");
    private JTextField input = new JTextField("", 10);
    private final int HEIGHT = 25;

    public ButtonNameChanger() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(label);
        input.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(input);
        addButton.addActionListener(new AddButtonEventListener());
        addButton.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(addButton);
        changeButton.addActionListener(new ChangeButtonEventListener());
        changeButton.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
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