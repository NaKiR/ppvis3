package nakir.ppvis.trains;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel {
    private JButton firstPageButton = new JButton("<<");
    private JButton prevPageButton = new JButton("<");
    private JButton nextPageButton = new JButton(">");
    private JButton lastPageButton = new JButton(">>");

    public BottomPanel(final Paginator model) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        final JLabel pageNumber = new JLabel("Стр. " + (model.getPageNumber() + 1) + " из " + (model.getMaxPage() + 1));
        final JLabel informFirst = new JLabel("Количество записей: " + model.getTrainSchedule().size());
        final JLabel informSecond = new JLabel("На текущей странице: " + model.getPageSchedule().size());
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        box.add(informFirst);
        box.add(informSecond);
        String[] items = {"3", "5", "10"};
        JComboBox editComboBox = new JComboBox(items);
        editComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                int trainsByPage = new Integer((String)box.getSelectedItem());
                model.setTrainsByPage(trainsByPage);
            }
        });

        add(box);
        add(firstPageButton);
        firstPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPageNumber(0);
            }
        });
        add(prevPageButton);
        prevPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(model.getPageNumber() > 0) {
                    model.setPageNumber(model.getPageNumber() - 1);
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
            }
        });
        add(lastPageButton);
        lastPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setPageNumber(model.getMaxPage());
            }
        });
        add(new JLabel("Записей на страницу: "));
        add(editComboBox);
        model.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                pageNumber.setText("Стр. " + (model.getPageNumber() + 1 + " из " + (model.getMaxPage() + 1)));
                informFirst.setText("Количество записей: " + model.getTrainSchedule().size());
                informSecond.setText("На текущей странице: " + model.getPageSchedule().size());
            }
        });
    }
}
