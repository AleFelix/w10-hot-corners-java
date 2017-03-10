package model;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import controller.ConfigData;
import controller.IConfigData;

public class XMLParser {

	public static final String XML_URL = "config/config.xml";
	public static final String XML_TAG = "corner";
	public static final String XML_ID = "id";
	public static final String XML_ATTR1 = "enabled";
	public static final String XML_ATTR2 = "custom";
	public static final String XML_ATTR3 = "option";
	public static final String XML_ATTR4 = "custom_s";
	public static final String CODES_SEPARATOR = "-";
	public static final int AMOUNT_ATTR = 4;
	public static final int AMOUNT_TAGS = 4;
	public static final int INDEX_LEFT_UP = 0;
	public static final int INDEX_RIGHT_UP = 1;
	public static final int INDEX_LEFT_DOWN = 2;
	public static final int INDEX_RIGHT_DOWN = 3;

	public static ArrayList<Integer> getCustomCodes(String customCodes) {
		String[] customStringCodes = customCodes.split(XMLParser.CODES_SEPARATOR);
		ArrayList<Integer> customIntCodes = new ArrayList<Integer>();
		for (int i = 0; i < customStringCodes.length; i++) {
			customIntCodes.add(Integer.valueOf(customStringCodes[i]));
		}
		return customIntCodes;
	}

	public static ArrayList<String> readXML(String xml) {
		ArrayList<String> config = new ArrayList<String>();
		try {
			File fXmlFile = new File(xml);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(XML_TAG);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					config.add(eElement.getElementsByTagName(XML_ATTR1).item(0).getTextContent());
					config.add(eElement.getElementsByTagName(XML_ATTR2).item(0).getTextContent());
					config.add(eElement.getElementsByTagName(XML_ATTR3).item(0).getTextContent());
					config.add(eElement.getElementsByTagName(XML_ATTR4).item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return config;
	}

	public static void writeXML(String xml, ArrayList<String> values) {
		try {
			File fXmlFile = new File(xml);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(XML_TAG);
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					eElement.getElementsByTagName(XML_ATTR1).item(0).setTextContent(values.get(0 + AMOUNT_ATTR * i));
					eElement.getElementsByTagName(XML_ATTR2).item(0).setTextContent(values.get(1 + AMOUNT_ATTR * i));
					eElement.getElementsByTagName(XML_ATTR3).item(0).setTextContent(values.get(2 + AMOUNT_ATTR * i));
					eElement.getElementsByTagName(XML_ATTR4).item(0).setTextContent(values.get(3 + AMOUNT_ATTR * i));
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fXmlFile);
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<IConfigData> getConfig(String xml) {
		ArrayList<String> data = readXML(xml);
		ArrayList<IConfigData> configs = new ArrayList<IConfigData>();
		IConfigData configData;
		boolean enabled;
		boolean custom;
		int option;
		ArrayList<Integer> customKeys;
		int index;
		for (int i = 0; i < AMOUNT_TAGS; i++) {
			index = i + (XMLParser.AMOUNT_ATTR - 1) * i;
			enabled = getBooleanValue(Integer.valueOf(data.get(index)));
			custom = getBooleanValue(Integer.valueOf(data.get(index+1)));
			option = Integer.valueOf(data.get(index+2));
			customKeys = getCustomCodes(data.get(index+3));
			configData = new ConfigData(enabled, custom, option, customKeys);
			configs.add(configData);
		}
		return configs;
	}
	
	public static boolean getBooleanValue(int value) {
		if (value == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int getIntValue(boolean value) {
		if (value == true) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static String getCustomStringCodes(ArrayList<Integer> customCodes) {
		String textCodes = "";
		for (int i = 0; i < customCodes.size(); i++) {
			textCodes = textCodes + String.valueOf(customCodes.get(i));
			if (i != customCodes.size()-1) {
				textCodes = textCodes + CODES_SEPARATOR;
			}
		}
		return textCodes;
	}

	public static void setConfig(String xml, ArrayList<IConfigData> config) {
		ArrayList<String> stringConfig = new ArrayList<String>();
		IConfigData data;
		for (int i = 0; i < config.size(); i++) {
			data = config.get(i);
			stringConfig.add(String.valueOf(getIntValue(data.isEnabled())));
			stringConfig.add(String.valueOf(getIntValue(data.isCustom())));
			stringConfig.add(String.valueOf(data.getSelectedOption()));
			stringConfig.add(getCustomStringCodes(data.getCustomKeyCodes()));
		}
		writeXML(xml,stringConfig);
	}
}
