package nakir.ppvis.trains;

import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;

public class TrainTable extends JPanel {

    public TrainTable(TrainTableModel model) {
        JTable table = new JTable(model);
        table.setShowGrid(false);
        int[] columnWidths = new int[] {40, 120, 120, 100, 100, 100};
        for (int colInd = 0; colInd < table.getColumnCount(); colInd++)
            table.getColumnModel().getColumn(colInd).setMinWidth(columnWidths[colInd]);
        model.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
            }
        });
        JScrollPane tablePane = new JScrollPane(table);
        tablePane.setBorder(BorderFactory.createCompoundBorder());
        setLayout(new BorderLayout());
        add(tablePane, BorderLayout.CENTER);
        add(new BottomPanel(model), BorderLayout.SOUTH);
    }
}
