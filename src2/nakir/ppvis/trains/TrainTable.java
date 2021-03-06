package nakir.ppvis.trains;

import javax.swing.*;
import java.awt.*;

public class TrainTable extends JPanel {

    public TrainTable(Paginator model) {
        JTable table = new JTable(model);
        table.setShowGrid(false);
        int[] columnWidths = new int[] {40, 120, 120, 100, 100, 100};
        for (int colInd = 0; colInd < table.getColumnCount(); colInd++)
            table.getColumnModel().getColumn(colInd).setMinWidth(columnWidths[colInd]);
        JScrollPane tablePane = new JScrollPane(table);
        tablePane.setBorder(BorderFactory.createCompoundBorder());
        setLayout(new BorderLayout());
        add(tablePane, BorderLayout.CENTER);
        add(new BottomPanel(model), BorderLayout.SOUTH);
    }
}
