package nakir.ppvis.trains;

import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Paginator extends AbstractTableModel {

    private List<TrainModel> trainSchedule = new ArrayList<TrainModel>();
    private String[] columnNames;
    private  final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private int pageNumber = 0;
    private int trainsByPage = 3;
    private TrainTableModel model;

    public Paginator(TrainTableModel model) {
        this.model = model;
        columnNames = model.getColumnNames();
        trainSchedule = model.getTrainSchedule(trainsByPage, pageNumber);
    }

    @Override
    public int getRowCount() {
        return trainSchedule.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return model.getColumnClass(columnIndex);
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

    public void setTrainsByPage(int number) {
        trainsByPage = number;
        trainSchedule = model.getTrainSchedule(trainsByPage, pageNumber);
        fireTableDataChanged();
    }

    public void setPageNumber(int page){
        pageNumber = page;
        trainSchedule = model.getTrainSchedule(trainsByPage, pageNumber);
        fireTableDataChanged();
    }

    public int getTrainsByPage() {
        return trainsByPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getMaxPage() {
        return (model.getTrainSchedule().size() - 1) / trainsByPage;
    }

    public void replaceList(List<TrainModel> list) {
        model.replaceList(list);
        trainSchedule = model.getTrainSchedule(trainsByPage, pageNumber);
        fireTableDataChanged();
    }

    public void add(TrainModel newTrain) {
        model.add(newTrain);
        trainSchedule = model.getTrainSchedule(trainsByPage, pageNumber);
        fireTableDataChanged();
    }

    public void delete(TrainModel deletedTrain) {
        model.delete(deletedTrain);
        trainSchedule = model.getTrainSchedule(trainsByPage, pageNumber);
        fireTableDataChanged();
    }

    public List<TrainModel> getTrainSchedule() {
        return model.getTrainSchedule();
    }

    public List<TrainModel> getPageSchedule() {
        return trainSchedule;
    }
}
