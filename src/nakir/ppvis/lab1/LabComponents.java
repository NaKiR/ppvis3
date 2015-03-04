package nakir.ppvis.lab1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by NotePad on 21.02.2015.
 */
public class LabComponents {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("PPVIS lab1");
        mainFrame.setResizable(false);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image icon = kit.getImage("icon.gif");
        mainFrame.setIconImage(icon);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container componentBox = mainFrame.getContentPane();
        componentBox.setLayout(new BoxLayout(componentBox,BoxLayout.X_AXIS));
        componentBox.add(new ComboBoxEditor());
        componentBox.add(new ButtonNameChanger());
        componentBox.add(new RadioButtonChooser());
        componentBox.add(new CheckBoxChooser());
        componentBox.add(new TableEditor());
        componentBox.add(new MarqueeComponent());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
