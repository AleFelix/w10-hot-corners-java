package model;

import java.awt.Toolkit;

public class ScreenHandler {

	public static double getWidth() {
		return Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	}
	
	public static double getHeight() {
		return Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}
	
}
