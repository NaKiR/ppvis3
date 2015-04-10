package nakir.ppvis.trains;

import nakir.ppvis.trains.add.AddTrainListener;
import nakir.ppvis.trains.delete.DeleteTrainListener;
import nakir.ppvis.trains.filelisteners.NewFileListener;
import nakir.ppvis.trains.filelisteners.OpenFileListener;
import nakir.ppvis.trains.filelisteners.SaveFileListener;
import nakir.ppvis.trains.model.TrainTableModel;
import nakir.ppvis.trains.search.SearchTrainListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public MainWindow(TrainTableModel model) {
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
//        ImageIcon newFileIcon = new ImageIcon("icon2.gif");
//        ImageIcon openFileIcon = new ImageIcon("icon2.gif");
//        ImageIcon saveFileIcon = new ImageIcon("icon2.gif");
//        ImageIcon insertRowIcon = new ImageIcon("icon2.gif");
//        ImageIcon searchRowIcon = new ImageIcon("icon2.gif");
//        ImageIcon deleteRowIcon = new ImageIcon("icon2.gif");
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

    private void createMenuBar(final TrainTableModel model) {
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

        JMenu optionsMenu = new JMenu("Options");
            JMenu pageSizeMenu = new JMenu("Page size");
            JMenuItem five = new JMenuItem("5 rows");
            five.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setTrainsByPage(5);
                }
            });
            JMenuItem ten = new JMenuItem("10 rows");
            ten.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setTrainsByPage(10);
                }
            });
            JMenuItem fifteen = new JMenuItem("15 rows");
            fifteen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setTrainsByPage(15);
                }
            });
            pageSizeMenu.add(five);
            pageSizeMenu.add(ten);
            pageSizeMenu.add(fifteen);
            optionsMenu.add(pageSizeMenu);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);
    }
}
