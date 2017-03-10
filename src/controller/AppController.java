package controller;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.UIManager;

import model.AppModel;
import view.ConfigView;
import view.SystemTrayView;

public class AppController {

	private SystemTrayView trayView;
	private ConfigView configView;
	private AppModel appModel;
	private AppController controller;
	
	public AppController() {
		controller = this;
	}

	public void startApplication() {
		trayView = new SystemTrayView(this);
		appModel = new AppModel();
		trayView.startSystemtray();
		appModel.startApp();
	}
	
	public void openConfig() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					configView = new ConfigView(controller);
					configView.setConfig(AppModel.getConfig());
					configView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setConfig(ArrayList<IConfigData> config) {
		appModel.setConfig(config);
	}
	
}
