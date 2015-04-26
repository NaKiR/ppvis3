package nakir.ppvis.trains.filelisteners;

import nakir.ppvis.trains.Paginator;
import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OpenFileListener implements ActionListener {
    private Paginator model;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public OpenFileListener(Paginator model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser openFile = new JFileChooser();
        int retrieval = openFile.showDialog(null, "Open file");
        if (retrieval == JFileChooser.APPROVE_OPTION) {
            try {
                List<TrainModel> newSchedule = new ArrayList<TrainModel>();
                File file = openFile.getSelectedFile();
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);
                NodeList nList = doc.getElementsByTagName("train");
                for (int itemNumber = 0; itemNumber < nList.getLength(); itemNumber++) {

                    Node nNode = nList.item(itemNumber);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        TrainModel train = new TrainModel();
                        train.trainNumber = new Integer(eElement.getElementsByTagName("trainNumber").item(0).getTextContent());
                        train.dispatchStation = eElement.getElementsByTagName("dispatchStation").item(0).getTextContent();
                        train.arrivalStation = eElement.getElementsByTagName("arrivalStation").item(0).getTextContent();
                        train.departureDate = dateFormat.parse(eElement.getElementsByTagName("departureDate").item(0).getTextContent());
                        train.arrivalDate = dateFormat.parse(eElement.getElementsByTagName("arrivalDate").item(0).getTextContent());
                        train.travelTime = new Integer(eElement.getElementsByTagName("travelTime").item(0).getTextContent());
                        newSchedule.add(train);
                    }
                }
                model.replaceList(newSchedule);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}