package nakir.ppvis.trains;

import nakir.ppvis.trains.add.AddTrainListener;
import nakir.ppvis.trains.delete.DeleteTrainListener;
import nakir.ppvis.trains.model.TrainTableModel;
import nakir.ppvis.trains.search.SearchTrainListener;

import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow(TrainTableModel model) {
        TrainTable table = new TrainTable(model);
        setTitle("Train Schedule");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createMenuBar(model);
        add(table);

        setVisible(true);
    }

    private void createMenuBar(TrainTableModel model) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
            JMenuItem openItem = new JMenuItem("Open");
            openItem.addActionListener(new OpenFileListener());
            fileMenu.add(openItem);
            JMenuItem saveItem = new JMenuItem("Save");
            saveItem.addActionListener(new SaveFileListener(model));
            fileMenu.add(saveItem);

        JMenu editMenu = new JMenu("Edit");
            JMenuItem insertItem = new JMenuItem("Insert");
            insertItem.addActionListener(new AddTrainListener(model));
            editMenu.add(insertItem);
            JMenuItem searchItem = new JMenuItem("Search");
            searchItem.addActionListener(new SearchTrainListener(model));
            editMenu.add(searchItem);
            JMenuItem deleteItem = new JMenuItem("Delete");
            deleteItem.addActionListener(new DeleteTrainListener(model));
            editMenu.add(deleteItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);
    }
}
