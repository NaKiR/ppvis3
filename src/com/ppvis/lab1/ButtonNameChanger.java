package com.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 17.02.2015.
 */

public class ButtonNameChanger extends JFrame {
    private JButton addButton = new JButton("Add");
    private JButton changeButton = new JButton("Something");
    private JTextField input = new JTextField("", 10);

    public ButtonNameChanger() {
        super("PPVIS lab 1");
        this.setBounds(100, 100, 200, 60);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(input);
        addButton.addActionListener(new AddButtonEventListener());
        container.add(addButton);
        changeButton.addActionListener(new ChangeButtonEventListener());
        container.add(changeButton);
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




