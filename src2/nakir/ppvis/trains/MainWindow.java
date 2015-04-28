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
        ImageIcon buttonIcon = new ImageIcon("icons/file.gif");
        JButton newFile = new JButton(buttonIcon);
        newFile.addActionListener(new NewFileListener(model));
        buttonIcon = new ImageIcon("icons/26.gif");
        JButton openFile = new JButton(buttonIcon);
        openFile.addActionListener(new OpenFileListener(model));
        buttonIcon = new ImageIcon("icons/22.gif");
        JButton saveFile = new JButton(buttonIcon);
        saveFile.addActionListener(new SaveFileListener(model));
        buttonIcon = new ImageIcon("icons/60.gif");
        JButton insertRow = new JButton(buttonIcon);
        insertRow.addActionListener(new AddTrainListener(model));
        buttonIcon = new ImageIcon("icons/search.gif");
        JButton searchRow = new JButton(buttonIcon);
        searchRow.addActionListener(new SearchTrainListener(model));
        buttonIcon = new ImageIcon("icons/delete.gif");
        JButton deleteRow = new JButton(buttonIcon);
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
