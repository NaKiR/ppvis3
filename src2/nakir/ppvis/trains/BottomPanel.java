package nakir.ppvis.trains;

import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel {
    private JButton firstPageButton = new JButton("<<");
    private JButton prevPageButton = new JButton("<");
    private JButton nextPageButton = new JButton(">");
    private JButton lastPageButton = new JButton(">>");

    public BottomPanel(final TrainTableModel model) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        final JLabel pageNumber = new JLabel("Стр. " + (model.getPageNumber() + 1 + " из " + (model.getMaxPage() + 1)));

        add(firstPageButton);
        firstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPageNumber(0);
                pageNumber.setText("Стр. " + (model.getPageNumber() + 1 + " из " + (model.getMaxPage() + 1)));
            }
        });
        add(prevPageButton);
        prevPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(model.getPageNumber() > 0) {
                    model.setPageNumber(model.getPageNumber() - 1);
                    pageNumber.setText("Стр. " + (model.getPageNumber() + 1 + " из " + (model.getMaxPage() + 1)));
                }
            }
        });
        add(pageNumber);
        add(nextPageButton);
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.getPageNumber() == model.getMaxPage()) {
                    return;
                }
                model.setPageNumber(model.getPageNumber() + 1);
                pageNumber.setText("Стр. " + (model.getPageNumber() + 1 + " из " + (model.getMaxPage() + 1)));
            }
        });
        add(lastPageButton);
        lastPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPageNumber(model.getMaxPage());
                pageNumber.setText("Стр. " + (model.getPageNumber() + 1 + " из " + (model.getMaxPage() + 1)));
            }
        });
    }
}
