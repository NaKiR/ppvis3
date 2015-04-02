package nakir.ppvis.trains;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel {
    private JButton firstPageButton = new JButton("<<");
    private JButton prevPageButton = new JButton("<");
    private JButton nextPageButton = new JButton(">");
    private JButton lastPageButton = new JButton(">>");

    public BottomPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(firstPageButton);
        add(prevPageButton);
        add(nextPageButton);
        add(lastPageButton);
    }
}
