package nakir.ppvis.trains.model;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TrainTableModel extends AbstractTableModel {

    private final String[] columnNames = new String[]{"Номер поезда", "Станция отправления", "Станция прибытия",
            "Дата отправления", "Дата прибытия", "Время в пути"};
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private List<TrainModel> trainSchedule = new ArrayList<TrainModel>();

    public TrainTableModel() {
    }

    @Override
    public int getRowCount() {
        return trainSchedule.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return SimpleDateFormat.class;
            case 4:
                return SimpleDateFormat.class;
            case 5:
                return String.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return trainSchedule.get(rowIndex).trainNumber;
            case 1:
                return trainSchedule.get(rowIndex).dispatchStation;
            case 2:
                return trainSchedule.get(rowIndex).arrivalStation;
            case 3:
                return dateFormat.format(trainSchedule.get(rowIndex).departureDate);
            case 4:
                return dateFormat.format(trainSchedule.get(rowIndex).arrivalDate);
            case 5:
                return (trainSchedule.get(rowIndex).travelTime / 3600) + " ч. " +
                        ((trainSchedule.get(rowIndex).travelTime % 3600) / 60) + " мин.";
        }
        return "";
    }

    public void add(TrainModel newTrain) {
        trainSchedule.add(newTrain);
    }

    public void delete(TrainModel deletedTrain) {
        trainSchedule.remove(deletedTrain);
    }

    public List<TrainModel> getTrainSchedule() {
        return trainSchedule;
    }

    public List<TrainModel> getTrainSchedule(int numberOfTrains, int pageNumber) {
        List<TrainModel> newSchedule = new ArrayList<TrainModel>();
        for (int train = (pageNumber) * numberOfTrains; train < (pageNumber + 1) * numberOfTrains; train++) {
            if (train < trainSchedule.size()) {
                newSchedule.add(trainSchedule.get(train));
            }
        }
        return newSchedule;
    }


    public void replaceList(List<TrainModel> list) {
        trainSchedule = list;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

}
