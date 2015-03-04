package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by NotePad on 21.02.2015.
 */
public class TableEditor extends Container {
    private int numRows = 5;
    private int numColumns = 2;
    private RunningButton addButton = new RunningButton("Добавить");
    private RunningButton toFirstColumnButton = new RunningButton("В первую колонку");
    private RunningButton toSecondColumnButton = new RunningButton("Во вторую колонку");
    private JTextField input = new JTextField("", 10);
    private RunningLabel label = new RunningLabel("Ввод:");
    private JTable table = new JTable(numRows, numColumns);
    private final int HEIGHT = 25;

    public TableEditor() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(table);
        this.add(label);
        input.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(input);
        addButton.addActionListener(new AddButtonEventListener());
        addButton.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        toFirstColumnButton.addActionListener(new ChangeToFirstButtonEventListener());
        toFirstColumnButton.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        toSecondColumnButton.addActionListener(new ChangeToSecondButtonEventListener());
        toSecondColumnButton.setMaximumSize(new Dimension(Short.MAX_VALUE, HEIGHT));
        this.add(addButton);
        this.add(toFirstColumnButton);
        this.add(toSecondColumnButton);
    }

    class AddButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            table.setValueAt(input.getText(), table.getSelectedRow(), 0);
        }
    }

    class ChangeToFirstButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object value = table.getValueAt(table.getSelectedRow(), 1);
            table.setValueAt(value, table.getSelectedRow(), 0);
            table.setValueAt("", table.getSelectedRow(), 1);
        }
    }

    class ChangeToSecondButtonEventListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Object value = table.getValueAt(table.getSelectedRow(), 0);
            if (!value.equals("")) {
                table.setValueAt(value, table.getSelectedRow(), 1);
                table.setValueAt("", table.getSelectedRow(), 0);
            }
        }
    }
}
