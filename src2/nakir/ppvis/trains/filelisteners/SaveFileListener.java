package nakir.ppvis.trains.filelisteners;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import nakir.ppvis.trains.Paginator;
import nakir.ppvis.trains.model.TrainModel;
import nakir.ppvis.trains.model.TrainTableModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SaveFileListener implements ActionListener {
    private Paginator model;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public SaveFileListener(Paginator model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JFileChooser saveFile = new JFileChooser();
            int retrieval = saveFile.showSaveDialog(null);
            if (retrieval == JFileChooser.APPROVE_OPTION) {
                File file = saveFile.getSelectedFile();
                if (!file.exists()) {
                    file.createNewFile();
                }
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document doc = builder.newDocument();
                Element root = doc.createElement("trainList");
                doc.appendChild(root);
                List<TrainModel> trainSchedule = model.getTrainSchedule();
                for (TrainModel train : trainSchedule) {
                    Element trainEl = doc.createElement("train");
                    root.appendChild(trainEl);


                    createElement(doc, trainEl, "trainNumber", String.valueOf(train.trainNumber));
                    createElement(doc, trainEl, "dispatchStation", train.dispatchStation);
                    createElement(doc, trainEl, "arrivalStation", train.arrivalStation);
                    createElement(doc, trainEl, "departureDate", dateFormat.format(train.departureDate));
                    createElement(doc, trainEl, "arrivalDate", dateFormat.format(train.arrivalDate));
                    createElement(doc, trainEl, "travelTime", String.valueOf(train.travelTime));
                }
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                DOMSource domSource = new DOMSource(doc);
                StreamResult result = new StreamResult(file);
                transformer.transform(domSource, result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createElement(Document doc, Element parent, String field, String value) {
        Element element = doc.createElement(field);
        element.setTextContent(value);
        parent.appendChild(element);
    }
}