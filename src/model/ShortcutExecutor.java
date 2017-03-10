package model;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

public class ShortcutExecutor {

	private Robot robot;

	public ShortcutExecutor() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void executeShortcut(ArrayList<Integer> keyCodes) {
		for (int i = 0; i < keyCodes.size(); i++) {
			robot.keyPress(keyCodes.get(i));
			robot.delay(100);
		}
		for (int i = keyCodes.size() - 1; i >= 0; i--) {
			robot.keyRelease(keyCodes.get(i));
			robot.delay(100);
		}
	}

}
