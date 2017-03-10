package model;

import java.awt.Point;
import java.util.ArrayList;

public class CornerHandler {

	public static final int LIMIT = 1;
	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	private boolean inCorner = false;
	private double limWidth;
	private double limHeight;
	private ShortcutExecutor shExecutor;
	private ArrayList<Integer> keyCodesLeftUp;
	private ArrayList<Integer> keyCodesRightUp;
	private ArrayList<Integer> keyCodesLeftDown;
	private ArrayList<Integer> keyCodesRightDown;
	private boolean leftUpEnabled;
	private boolean rightUpEnabled;
	private boolean leftDownEnabled;
	private boolean rightDownEnabled;
	private ShortcutsProvider provider;

	public CornerHandler(double screenWidth, double screenHeight) {
		limWidth = screenWidth - LIMIT;
		limHeight = screenHeight - LIMIT;
		inCorner = false;
		shExecutor = new ShortcutExecutor();
		provider = new ShortcutsProvider();
		loadKeyCodes();
	}

	public void loadKeyCodes() {
		ArrayList<String> xmlValues = XMLParser.readXML(XMLParser.XML_URL);
		int enabled;
		int custom;
		int option;
		int index;
		for (int i = 0; i < xmlValues.size() / XMLParser.AMOUNT_ATTR; i++) {
			index = i + (XMLParser.AMOUNT_ATTR - 1) * i;
			enabled = Integer.valueOf(xmlValues.get(index));
			custom = Integer.valueOf(xmlValues.get(index + 1));
			option = Integer.valueOf(xmlValues.get(index + 2));
			if (i == XMLParser.INDEX_LEFT_UP) {
				leftUpEnabled = XMLParser.getBooleanValue(enabled);
				if (XMLParser.getBooleanValue(custom) == false) {
					keyCodesLeftUp = provider.getCodes(Integer.valueOf(option));
				} else {
					keyCodesLeftUp = XMLParser.getCustomCodes(xmlValues.get(index + 3));
				}
			} else if (i == XMLParser.INDEX_RIGHT_UP) {
				rightUpEnabled = XMLParser.getBooleanValue(enabled);
				if (XMLParser.getBooleanValue(custom) == false) {
					keyCodesRightUp = provider.getCodes(Integer.valueOf(option));
				} else {
					keyCodesRightUp = XMLParser.getCustomCodes(xmlValues.get(index + 3));
				}
			} else if (i == XMLParser.INDEX_LEFT_DOWN) {
				leftDownEnabled = XMLParser.getBooleanValue(enabled);
				if (XMLParser.getBooleanValue(custom) == false) {
					keyCodesLeftDown = provider.getCodes(Integer.valueOf(option));
				} else {
					keyCodesLeftDown = XMLParser.getCustomCodes(xmlValues.get(index + 3));
				}
			} else if (i == XMLParser.INDEX_RIGHT_DOWN) {
				rightDownEnabled = XMLParser.getBooleanValue(enabled);
				if (XMLParser.getBooleanValue(custom) == false) {
					keyCodesRightDown = provider.getCodes(Integer.valueOf(option));
				} else {
					keyCodesRightDown = XMLParser.getCustomCodes(xmlValues.get(index + 3));
				}
			}
		}
	}

	public void handleNewPoint(Point p) {
		if (p.x <= LIMIT && p.y <= LIMIT) {
			cornerAction(LEFT, UP);
		} else if (p.x >= limWidth && p.y <= LIMIT) {
			cornerAction(RIGHT, UP);
		} else if (p.x <= LIMIT && p.y >= limHeight) {
			cornerAction(LEFT, DOWN);
		} else if (p.x >= limWidth && p.y >= limHeight) {
			cornerAction(RIGHT, DOWN);
		} else {
			if (inCorner) {
				inCorner = false;
			}
		}
	}

	private void cornerAction(int horizontal, int vertical) {
		if (!inCorner) {
			if (horizontal == LEFT && vertical == UP && leftUpEnabled) {
				shExecutor.executeShortcut(keyCodesLeftUp);
			} else if (horizontal == RIGHT && vertical == UP && rightUpEnabled) {
				shExecutor.executeShortcut(keyCodesRightUp);
			} else if (horizontal == LEFT && vertical == DOWN && leftDownEnabled) {
				shExecutor.executeShortcut(keyCodesLeftDown);
			} else if (horizontal == RIGHT && vertical == DOWN && rightDownEnabled) {
				shExecutor.executeShortcut(keyCodesRightDown);
			}
			inCorner = true;
		}
	}

}
