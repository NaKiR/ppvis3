package nakir.ppvis.trains.search;

import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;
import org.freixas.jcalendar.JCalendarCombo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class SearchTrainDialog extends JDialog {
    private JPanel choosePanel = new JPanel();
    private JTextField trainNumber = new JTextField();
    private JTextField dispatchStation = new JTextField();
    private JTextField arrivalStation = new JTextField();
    private JCalendarCombo departureDateEnd =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    private JCalendarCombo arrivalDateEnd =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    private JCalendarCombo departureDateStart =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    private JCalendarCombo arrivalDateStart =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    private JButton ok = new JButton("Ok");
    private JButton cancel = new JButton("Cancel");
    private TrainTableModel searchModel = new TrainTableModel();


    public SearchTrainDialog(final JFrame owner, final TrainTableModel model) {
        super(owner, "New entry", true);
        setSize(new Dimension(700, 400));
        setResizable(false);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout());


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        departureDateStart.setDateFormat(dateFormat);
        departureDateEnd.setDateFormat(dateFormat);
        arrivalDateStart.setDateFormat(dateFormat);
        arrivalDateEnd.setDateFormat(dateFormat);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<TrainModel> modelList = model.getTrainSchedule();
                for (TrainModel train : modelList) {
                    int numberOfActivated = 0;
                    int numberOfMatching = 0;

                    if (!trainNumber.getText().isEmpty()) {
                        numberOfActivated++;
                        if (train.trainNumber == new Integer(trainNumber.getText())) {
                            numberOfMatching++;
                        }
                    }
                    if (!dispatchStation.getText().isEmpty()) {
                        numberOfActivated++;
                        if (dispatchStation.getText().equals(train.dispatchStation)) {
                            numberOfMatching++;
                        }
                    }
                    if (!arrivalStation.getText().isEmpty()) {
                        numberOfActivated++;
                        if (arrivalStation.getText().equals(train.arrivalStation)) {
                            numberOfMatching++;
                        }
                    }
                    if (departureDateStart.getDate().before(departureDateEnd.getDate())) {
                        numberOfActivated++;
                        if (departureDateStart.getDate().before(train.departureDate) &&
                                train.departureDate.before(departureDateEnd.getDate())) {
                            numberOfMatching++;
                        }
                    }
                    if (arrivalDateStart.getDate().before(arrivalDateEnd.getDate())) {
                        numberOfActivated++;
                        if (arrivalDateStart.getDate().before(train.arrivalDate) &&
                                train.arrivalDate.before(arrivalDateEnd.getDate())) {
                            numberOfMatching++;
                        }
                    }
                    if (numberOfActivated == numberOfMatching) {
                        searchModel.add(train);
                    }
                    System.out.println(departureDateStart.getDate().before(departureDateEnd.getDate()));
                    System.out.println(arrivalDateStart.getDate().before(arrivalDateEnd.getDate()));
                    System.out.println(numberOfActivated + "" + numberOfMatching);
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        Container contentPane = getContentPane();
        createChoosePanel();
        contentPane.add(choosePanel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(new JTable(searchModel)), BorderLayout.CENTER);
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