package model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class MouseListener implements NativeMouseInputListener {
	
	private CornerHandler cornerHandler;

	public static void registerNativeHook() {
		try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
	}
	
	public MouseListener(double screenWidth, double screenHeight) {
		cornerHandler = new CornerHandler(screenWidth, screenHeight);
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		logger.setLevel(Level.WARNING);
		GlobalScreen.addNativeMouseListener(this);
		GlobalScreen.addNativeMouseMotionListener(this);
	}
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
		
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent e) {
		cornerHandler.handleNewPoint(e.getPoint());
	}

	public void updateKeys() {
		cornerHandler.loadKeyCodes();
	}

}
