package nakir.ppvis.trains;


import nakir.ppvis.trains.model.TrainTableModel;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveFileListener implements ActionListener {
    private TrainTableModel model;

    public SaveFileListener(TrainTableModel model) {
        this.model = model;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            JFileChooser saveFile = new JFileChooser();
            int retrieval = saveFile.showSaveDialog(null);
            if (retrieval == JFileChooser.APPROVE_OPTION) {
                File file = saveFile.getSelectedFile();
                if (!file.exists()) {
                    file.createNewFile();
                }

                Element tableEl = doc.createElement("table");
                doc.appendChild(tableEl);
                for (int i = 0; i < model.getRowCount(); i++) {
                    Element rowEl = doc.createElement("row");
                    tableEl.appendChild(rowEl);

                    for (int j = 0; j < model.getColumnCount(); j++) {
                        String header = model.getColumnName(j);
                        String value = model.getValueAt(i, j).toString();
                        Element cellEl = doc.createElement("cell");
                        Attr colAttr = doc.createAttribute("colName");
                        cellEl.setAttributeNode(colAttr);
                        rowEl.appendChild(cellEl);
                        colAttr.appendChild(doc.createTextNode(header));
                        cellEl.appendChild(doc.createTextNode(value));
                    }
                }

                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}