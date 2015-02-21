package nakir.ppvis;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 21.02.2015.
 */
public class MainFrame {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("PPVIS lab1");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(100, 100, 500, 200);
        Container componentBox = mainFrame.getContentPane();
        componentBox.setLayout(new BoxLayout(componentBox,BoxLayout.X_AXIS));
        componentBox.add(new ComboBoxEditor());
        componentBox.add(new ButtonNameChanger());
        componentBox.add(new RadioButtonChooser());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
