package com.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by NotePad on 17.02.2015.
 */

public class Frame extends JFrame {
    private ArrayList<String> comboBoxItems = new ArrayList<String>();
    private JButton button = new JButton("Add");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");
    private JComboBox comboBox = new JComboBox(comboBoxItems.toArray());

    public Frame() {
        super("PPVIS lab 1");
        this.setBounds(100, 100, 200, 60);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBoxItems.add("LALKA");
        Container container = this.getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(label);
        container.add(input);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
        container.add(comboBox);
    }

    class ButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String newItem = input.getText();
            System.out.println(newItem);
            if (comboBoxItems.size() != 0) {
                for (int itemIndex = 0; itemIndex < comboBoxItems.size(); itemIndex++) {
                    if (comboBoxItems.get(itemIndex) == newItem) {
                        JOptionPane.showMessageDialog(null, "Данная строка уже включена.",
                                "Output", JOptionPane.PLAIN_MESSAGE);
                    } else {
                        comboBoxItems.add(newItem);
                    }
                }
            } else {
                comboBoxItems.add(newItem);
            }
        }
    }

    public static void main(String[] args) {
        Frame app = new Frame();
        app.setVisible(true);
    }
}




