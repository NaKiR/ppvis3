package nakir.ppvis.trains;

import nakir.ppvis.trains.add.AddTrainListener;
import nakir.ppvis.trains.delete.DeleteTrainListener;
import nakir.ppvis.trains.filelisteners.NewFileListener;
import nakir.ppvis.trains.filelisteners.OpenFileListener;
import nakir.ppvis.trains.filelisteners.SaveFileListener;
import nakir.ppvis.trains.search.SearchTrainListener;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(Paginator model) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image icon = kit.getImage("icon2.gif");
        setIconImage(icon);
        TrainTable table = new TrainTable(model);
        setTitle("Train Schedule");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createMenuBar(model);
        add(table);

        JToolBar toolBar = new JToolBar();
        JButton newFile = new JButton("New");
        newFile.addActionListener(new NewFileListener(model));
        JButton openFile = new JButton("Open");
        openFile.addActionListener(new OpenFileListener(model));
        JButton saveFile = new JButton("Save");
        saveFile.addActionListener(new SaveFileListener(model));
        JButton insertRow = new JButton("Insert");
        insertRow.addActionListener(new AddTrainListener(model));
        JButton searchRow = new JButton("Search");
        searchRow.addActionListener(new SearchTrainListener(model));
        JButton deleteRow = new JButton("Delete");
        deleteRow.addActionListener(new DeleteTrainListener(model));
        toolBar.add(newFile);
        toolBar.add(openFile);
        toolBar.add(saveFile);
        toolBar.add(insertRow);
        toolBar.add(searchRow);
        toolBar.add(deleteRow);
        add(toolBar, BorderLayout.NORTH);
        setVisible(true);
    }

    private void createMenuBar(final Paginator model) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
            JMenuItem newItem = new JMenuItem("New");
            newItem.addActionListener(new NewFileListener(model));
            fileMenu.add(newItem);
            JMenuItem openItem = new JMenuItem("Open");
            openItem.addActionListener(new OpenFileListener(model));
            fileMenu.add(openItem);
            JMenuItem saveItem = new JMenuItem("Save As");
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
