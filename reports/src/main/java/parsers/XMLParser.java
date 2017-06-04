package parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import reports.ReportData;

public class XMLParser implements ParserInterface {

	PrintWriter writer;
	final String FILE_SUFFIX = ".xml";

	public void parseToFile(ArrayList<ReportData> data, String path) throws FileNotFoundException {

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("students");
			doc.appendChild(rootElement);

			Element staff = doc.createElement("student");

			for (int i = 0; i < data.get(0).getValue().size(); i++) {
				staff = doc.createElement("student");
				for (ReportData singleData : data) {
					Attr attr = doc.createAttribute(singleData.getParameterName());
					attr.setValue(singleData.getValue().get(i));
					staff.setAttributeNode(attr);
				}

				rootElement.appendChild(staff);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path + FILE_SUFFIX));

			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}

	public ArrayList<ReportData> parseFileToReportData(String path) {
		ArrayList<ReportData> data = new ArrayList<ReportData>();
		try {
			File fXmlFile = new File(path + FILE_SUFFIX);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(doc.getDocumentElement().getFirstChild().getNodeName());
			if (nList.getLength() > 0) {
				Element eTemp = (Element) nList.item(0);
				NamedNodeMap attributes = eTemp.getAttributes();

				for (int i = 0; i < attributes.getLength(); i++) {
					ReportData singleData = new ReportData();
					ArrayList<String> values = new ArrayList<String>();
					singleData.setParameterName(attributes.item(i).getNodeName());
					for (int temp = 0; temp < nList.getLength(); temp++) {
						Node nNode = nList.item(temp);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nNode;
							values.add(eElement.getAttribute(attributes.item(i).getNodeName()));
						}
					}
					singleData.setValue(values);
					data.add(singleData);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
