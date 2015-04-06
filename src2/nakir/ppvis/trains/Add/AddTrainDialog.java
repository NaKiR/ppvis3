package nakir.ppvis.trains.add;

import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;
import org.freixas.jcalendar.JCalendarCombo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddTrainDialog extends JDialog {
    private JTextField trainNumber = new JTextField();
    private JTextField dispatchStation = new JTextField();
    private JTextField arrivalStation = new JTextField();
    private JCalendarCombo departureDate =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);
    private JCalendarCombo arrivalDate =
            new JCalendarCombo(
                    Calendar.getInstance(),
                    Locale.getDefault(),
                    JCalendarCombo.DISPLAY_DATE | JCalendarCombo.DISPLAY_TIME,
                    true);


    public AddTrainDialog(final JFrame owner, final TrainTableModel model) {
        super(owner, "New entry", true);
        setSize(new Dimension(300, 160));
        setResizable(false);
        setLocationRelativeTo(owner);
        setLayout(new GridBagLayout());

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


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        departureDate.setDateFormat(dateFormat);
        arrivalDate.setDateFormat(dateFormat);

        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrainModel newTrain = new TrainModel();
                try {
                    newTrain.trainNumber = new Integer(trainNumber.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Incorrect train number!");
                    return;
                }
                if (dispatchStation.getText().isEmpty() || arrivalStation.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Incorrect station!");
                    return;
                }
                newTrain.dispatchStation = dispatchStation.getText();
                newTrain.arrivalStation = arrivalStation.getText();
                newTrain.departureDate = departureDate.getDate();
                newTrain.arrivalDate = arrivalDate.getDate();
                if (departureDate.getDate().before(arrivalDate.getDate())) {
                    newTrain.travelTime = (int) (newTrain.arrivalDate.getTime()
                            - newTrain.departureDate.getTime()) / 1000;
                    setVisible(false);
                    model.add(newTrain);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect arrival date!");
                }
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        Container contentPane = getContentPane();
        contentPane.add(new JLabel("Номер поезда"), labelConstraint);
        contentPane.add(trainNumber, fieldConstraint);
        contentPane.add(new JLabel("Станция отправления"), labelConstraint);
        contentPane.add(dispatchStation, fieldConstraint);
        contentPane.add(new JLabel("Станция прибытия"), labelConstraint);
        contentPane.add(arrivalStation, fieldConstraint);
        contentPane.add(new JLabel("Дата отправления"), labelConstraint);
        contentPane.add(departureDate, fieldConstraint);
        contentPane.add(new JLabel("Дата прибытия"), labelConstraint);
        contentPane.add(arrivalDate, fieldConstraint);
        contentPane.add(ok, labelConstraint);
        contentPane.add(cancel, fieldConstraint);
    }
}