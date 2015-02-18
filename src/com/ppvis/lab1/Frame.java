package com.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by NotePad on 17.02.2015.
 */

public class Frame extends JFrame {
    private String[] comboBoxItems = new String[] {"string1"};
    private JButton button = new JButton("Add");
    private JTextField input = new JTextField("", 10);
    private JLabel label = new JLabel("Input:");
    private JComboBox comboBox = new JComboBox(comboBoxItems);

    public Frame() {
        super("PPVIS lab 1");
        this.setBounds(100, 100, 200, 60);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(label);
        container.add(input);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
        container.add(comboBox);
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
                JOptionPane.showMessageDialog(null, "Данная строка уже включена.",
                        "Error!", JOptionPane.PLAIN_MESSAGE);
            } else {
                comboBox.addItem(newItem);
            }
        }
    }

    public static void main(String[] args) {
        Frame app = new Frame();
        app.setVisible(true);
    }
}




