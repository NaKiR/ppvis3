package nakir.ppvis;

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
    private JButton addButton = new JButton("Add");
    private JButton toFirstColumnButton = new JButton("To First Column");
    private JButton toSecondColumnButton = new JButton("To Second Column");
    private JTextField input = new JTextField("", 10);
    private JLabel label = new JLabel("Input:");
    private JTable table = new JTable(numRows, numColumns);

    public TableEditor() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(table);
        this.add(label);
        this.add(input);
        addButton.addActionListener(new AddButtonEventListener());
        toFirstColumnButton.addActionListener(new ChangeToFirstButtonEventListener());
        toSecondColumnButton.addActionListener(new ChangeToSecondButtonEventListener());
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
            table.setValueAt(value, table.getSelectedRow(), 1);
            table.setValueAt("", table.getSelectedRow(), 0);
        }
    }
}
