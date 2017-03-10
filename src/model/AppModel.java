package model;

import java.util.ArrayList;

import controller.IConfigData;

public class AppModel {
	
	private MouseListener listener;

	public void startApp() {
		MouseListener.registerNativeHook();
		listener = new MouseListener(ScreenHandler.getWidth(),ScreenHandler.getHeight());
	}

	public void setConfig(ArrayList<IConfigData> config) {
		XMLParser.setConfig(XMLParser.XML_URL, config);
		listener.updateKeys();
	}

	public static ArrayList<IConfigData> getConfig() {
		return XMLParser.getConfig(XMLParser.XML_URL);
	}
	
}
