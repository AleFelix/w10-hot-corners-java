package view;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.AppController;

public class SystemTrayView {
	
	private AppController controller;

	public SystemTrayView(AppController controller) {
		this.controller = controller;
	}

	public void startSystemtray() {
		if (!SystemTray.isSupported()) {
			System.out.println("System tray is not supported !!! ");
			return;
		}
		SystemTray systemTray = SystemTray.getSystemTray();
		//Image image = Toolkit.getDefaultToolkit().getImage("images/tray-icon.png");
		Image image = null;
		try {
			image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tray-icon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		PopupMenu trayPopupMenu = new PopupMenu();
		MenuItem action = new MenuItem("Hot Corners 10");
		action.setEnabled(false);
		trayPopupMenu.add(action);
		trayPopupMenu.addSeparator();
		action = new MenuItem("Options");
		action.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.openConfig();
			}
		});
		trayPopupMenu.add(action);
		MenuItem close = new MenuItem("Exit");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		trayPopupMenu.add(close);
		TrayIcon trayIcon = new TrayIcon(image, "Hot Corners 10", trayPopupMenu);
		trayIcon.setImageAutoSize(true);
		try {
			systemTray.add(trayIcon);
		} catch (AWTException awtException) {
			awtException.printStackTrace();
		}
	}
}
