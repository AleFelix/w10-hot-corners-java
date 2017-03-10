package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ShortcutsProvider {

	public static final int INDEX_TASK_VIEW = 0;
	public static final int INDEX_SEARCH = 1;
	public static final int INDEX_ACTION_CENTER = 2;
	public static final int INDEX_NEW_VIRTUAL_DESKTOP = 3;
	public static final int INDEX_CLOSE_VIRTUAL_DESKTOP = 4;
	public static final int INDEX_RIGHT_VIRTUAL_DESKTOP = 5;
	public static final int INDEX_LEFT_VIRTUAL_DESKTOP = 6;
	public static final int INDEX_START_MENU = 7;
	public static final int INDEX_SWITCH_TASK = 8;
	public static final int INDEX_SETTINGS = 9;

	private ArrayList<Integer> keyCodes;

	public ArrayList<Integer> getCodes(int index) {
		switch (index) {
		case INDEX_TASK_VIEW:
			return getTaskViewCodes();
		case INDEX_SEARCH:
			return getSearchCodes();
		case INDEX_ACTION_CENTER:
			return getActionCenterCodes();
		case INDEX_NEW_VIRTUAL_DESKTOP:
			return getNewVirtualDesktopCodes();
		case INDEX_CLOSE_VIRTUAL_DESKTOP:
			return getCloseVirtualDesktopCodes();
		case INDEX_RIGHT_VIRTUAL_DESKTOP:
			return getRightVirtualDesktopCodes();
		case INDEX_LEFT_VIRTUAL_DESKTOP:
			return getLeftVirtualDesktopCodes();
		case INDEX_START_MENU:
			return getStartMenuCodes();
		case INDEX_SWITCH_TASK:
			return getSwitchTaskCodes();
		case INDEX_SETTINGS:
			return getSettingsCodes();
		}
		return getTaskViewCodes();
	}

	public ArrayList<Integer> getTaskViewCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_TAB);
		return keyCodes;
	}

	public ArrayList<Integer> getSearchCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_S);
		return keyCodes;
	}

	public ArrayList<Integer> getActionCenterCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_A);
		return keyCodes;
	}

	public ArrayList<Integer> getNewVirtualDesktopCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_CONTROL);
		keyCodes.add(KeyEvent.VK_D);
		return keyCodes;
	}

	public ArrayList<Integer> getCloseVirtualDesktopCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_CONTROL);
		keyCodes.add(KeyEvent.VK_F4);
		return keyCodes;
	}

	public ArrayList<Integer> getRightVirtualDesktopCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_CONTROL);
		keyCodes.add(KeyEvent.VK_RIGHT);
		return keyCodes;
	}

	public ArrayList<Integer> getLeftVirtualDesktopCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_CONTROL);
		keyCodes.add(KeyEvent.VK_LEFT);
		return keyCodes;
	}

	public ArrayList<Integer> getStartMenuCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		return keyCodes;
	}

	public ArrayList<Integer> getSwitchTaskCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_ALT);
		keyCodes.add(KeyEvent.VK_TAB);
		return keyCodes;
	}

	public ArrayList<Integer> getSettingsCodes() {
		keyCodes = new ArrayList<Integer>();
		keyCodes.add(KeyEvent.VK_WINDOWS);
		keyCodes.add(KeyEvent.VK_I);
		return keyCodes;
	}

}
