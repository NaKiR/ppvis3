package nakir.ppvis.trains;

import nakir.ppvis.trains.model.TrainTableModel;
import org.freixas.jcalendar.JCalendarCombo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by NotePad on 11.04.2015.
 */
public class TrainDialog  extends JDialog {
    protected JPanel choosePanel = new JPanel();
    protected JTextField trainNumber = new JTextField();
    protected JTextField dispatchStation = new JTextField();
    protected JTextField arrivalStation = new JTextField();
    protected JCalendarCombo departureDateEnd =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    protected JCalendarCombo arrivalDateEnd =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    protected JCalendarCombo departureDateStart =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    protected JCalendarCombo arrivalDateStart =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    protected JButton ok = new JButton("Ok");
    protected JButton cancel = new JButton("Cancel");

    public TrainDialog(final JFrame owner, final Paginator model) {
        super(owner, "New entry", true);
        setResizable(false);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        departureDateStart.setDateFormat(dateFormat);
        departureDateEnd.setDateFormat(dateFormat);
        arrivalDateStart.setDateFormat(dateFormat);
        arrivalDateEnd.setDateFormat(dateFormat);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        Container contentPane = getContentPane();
        createChoosePanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
    }

    public void createChoosePanel() {
        choosePanel.setLayout(new GridBagLayout());
        GridBagConstraints labelConstraint = new GridBagConstraints();
        labelConstraint.anchor = GridBagConstraints.NORTH;
        labelConstraint.fill = GridBagConstraints.HORIZONTAL;
        labelConstraint.weightx = 1;
        labelConstraint.gridx = 0;
        labelConstraint.gridy = GridBagConstraints.RELATIVE;

        GridBagConstraints fieldConstraint = new GridBagConstraints();
        fieldConstraint.anchor = GridBagConstraints.NORTH;
        fieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        fieldConstraint.weightx = 1;
        fieldConstraint.gridx = 1;
        fieldConstraint.gridy = GridBagConstraints.RELATIVE;

        choosePanel.add(new JLabel("Номер поезда"), labelConstraint);
        choosePanel.add(trainNumber, fieldConstraint);
        choosePanel.add(new JLabel("Станция отправления"), labelConstraint);
        choosePanel.add(dispatchStation, fieldConstraint);
        choosePanel.add(new JLabel("Станция прибытия"), labelConstraint);
        choosePanel.add(arrivalStation, fieldConstraint);
        choosePanel.add(new JLabel("Дата отправления: от "), labelConstraint);
        choosePanel.add(departureDateStart, fieldConstraint);
        choosePanel.add(new JLabel("до "), labelConstraint);
        choosePanel.add(departureDateEnd, fieldConstraint);
        choosePanel.add(new JLabel("Дата прибытия: от "), labelConstraint);
        choosePanel.add(arrivalDateStart, fieldConstraint);
        choosePanel.add(new JLabel("до "), labelConstraint);
        choosePanel.add(arrivalDateEnd, fieldConstraint);
        choosePanel.add(ok, labelConstraint);
        choosePanel.add(cancel, fieldConstraint);
    }
}