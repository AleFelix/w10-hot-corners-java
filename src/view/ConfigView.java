package view;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.AppController;
import controller.ConfigData;
import controller.IConfigData;
import pl.mgorski.keygrab.KeyGrab;

@SuppressWarnings("rawtypes")
public class ConfigView extends JFrame {

	private static final long serialVersionUID = 1L;

	private AppController controller;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private KeyGrab textFieldCornerUpRight;
	private KeyGrab textFieldCornerDownRight;
	private KeyGrab textFieldCornerUpLeft;
	private KeyGrab textFieldCornerDownLeft;
	private KeyStore keyStoreCornerUpRight;
	private KeyStore keyStoreCornerDownRight;
	private KeyStore keyStoreCornerUpLeft;
	private KeyStore keyStoreCornerDownLeft;
	private JRadioButton radioButtonActionUpLeft;
	private JRadioButton radioButtonCustomUpLeft;
	private JComboBox comboBoxCornerUpLeft;
	private JRadioButton radioButtonActionDownLeft;
	private JRadioButton radioButtonCustomDownLeft;
	private JComboBox comboBoxCornerDownLeft;
	private JRadioButton radioButtonActionDownRight;
	private JRadioButton radioButtonCustomDownRight;
	private JComboBox comboBoxCornerDownRight;
	private JRadioButton radioButtonActionUpRight;
	private JRadioButton radioButtonCustomUpRight;
	private JComboBox comboBoxCornerUpRight;
	private JCheckBox checkBoxCornerUpLeft;
	private JCheckBox checkBoxCornerDownRight;
	private JCheckBox checkBoxCornerUpRight;
	private JCheckBox checkBoxCornerDownLeft;
	private JFrame frame;

	@SuppressWarnings("unchecked")
	public ConfigView(AppController controller) {
		setTitle("Hot Corners Configuration");
		try {
			setIconImage(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tray-icon.png")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		frame = this;
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 830, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);

		checkBoxCornerUpRight = new JCheckBox("Enabled");
		checkBoxCornerUpRight.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				JCheckBox checkBox = (JCheckBox) arg0.getSource();
				boolean selected = checkBox.getModel().isSelected();
				if (selected) {
					radioButtonCustomUpRight.setEnabled(true);
					radioButtonActionUpRight.setEnabled(true);
					comboBoxCornerUpRight.setEnabled(true);
					textFieldCornerUpRight.setEnabled(true);
				} else {
					radioButtonCustomUpRight.setEnabled(false);
					radioButtonActionUpRight.setEnabled(false);
					comboBoxCornerUpRight.setEnabled(false);
					textFieldCornerUpRight.setEnabled(false);
				}
			}
		});

		comboBoxCornerUpRight = new JComboBox();
		comboBoxCornerUpRight.setEnabled(false);
		comboBoxCornerUpRight.setModel(new DefaultComboBoxModel(Shortcuts.getShcts()));

		keyStoreCornerUpRight = new KeyStore();
		
		textFieldCornerUpRight = new KeyGrab(keyStoreCornerUpRight);
		textFieldCornerUpRight.setEnabled(false);
		textFieldCornerUpRight.setColumns(10);

		radioButtonCustomUpRight = new JRadioButton("Custom");
		radioButtonCustomUpRight.setEnabled(false);
		buttonGroup_2.add(radioButtonCustomUpRight);

		radioButtonActionUpRight = new JRadioButton("Action");
		radioButtonActionUpRight.setEnabled(false);
		buttonGroup_2.add(radioButtonActionUpRight);
		radioButtonActionUpRight.setSelected(true);

		comboBoxCornerDownRight = new JComboBox();
		comboBoxCornerDownRight.setEnabled(false);
		comboBoxCornerDownRight.setModel(new DefaultComboBoxModel(Shortcuts.getShcts()));

		keyStoreCornerDownRight = new KeyStore();
		
		textFieldCornerDownRight = new KeyGrab(keyStoreCornerDownRight);
		textFieldCornerDownRight.setEnabled(false);
		textFieldCornerDownRight.setColumns(10);

		radioButtonActionDownRight = new JRadioButton("Custom");
		radioButtonActionDownRight.setEnabled(false);
		buttonGroup_3.add(radioButtonActionDownRight);

		radioButtonCustomDownRight = new JRadioButton("Action");
		radioButtonCustomDownRight.setEnabled(false);
		buttonGroup_3.add(radioButtonCustomDownRight);
		radioButtonCustomDownRight.setSelected(true);

		checkBoxCornerDownRight = new JCheckBox("Enabled");
		checkBoxCornerDownRight.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				JCheckBox checkBox = (JCheckBox) arg0.getSource();
				boolean selected = checkBox.getModel().isSelected();
				if (selected) {
					radioButtonActionDownRight.setEnabled(true);
					radioButtonCustomDownRight.setEnabled(true);
					comboBoxCornerDownRight.setEnabled(true);
					textFieldCornerDownRight.setEnabled(true);
				} else {
					radioButtonActionDownRight.setEnabled(false);
					radioButtonCustomDownRight.setEnabled(false);
					comboBoxCornerDownRight.setEnabled(false);
					textFieldCornerDownRight.setEnabled(false);
				}
			}
		});

		JLabel label = new JLabel("");
		try {
			label.setIcon(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/Desktop.png"))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		label.setHorizontalAlignment(SwingConstants.CENTER);

		comboBoxCornerUpLeft = new JComboBox();
		comboBoxCornerUpLeft.setEnabled(false);
		comboBoxCornerUpLeft.setModel(new DefaultComboBoxModel(Shortcuts.getShcts()));

		keyStoreCornerUpLeft = new KeyStore();
		
		textFieldCornerUpLeft = new KeyGrab(keyStoreCornerUpLeft);
		textFieldCornerUpLeft.setEnabled(false);
		textFieldCornerUpLeft.setColumns(10);

		radioButtonCustomUpLeft = new JRadioButton("Custom");
		radioButtonCustomUpLeft.setEnabled(false);
		buttonGroup.add(radioButtonCustomUpLeft);

		radioButtonActionUpLeft = new JRadioButton("Action");
		radioButtonActionUpLeft.setEnabled(false);
		buttonGroup.add(radioButtonActionUpLeft);
		radioButtonActionUpLeft.setSelected(true);

		checkBoxCornerUpLeft = new JCheckBox("Enabled");
		checkBoxCornerUpLeft.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				JCheckBox checkBox = (JCheckBox) arg0.getSource();
				boolean selected = checkBox.getModel().isSelected();
				if (selected) {
					radioButtonCustomUpLeft.setEnabled(true);
					radioButtonActionUpLeft.setEnabled(true);
					comboBoxCornerUpLeft.setEnabled(true);
					textFieldCornerUpLeft.setEnabled(true);
				} else {
					radioButtonCustomUpLeft.setEnabled(false);
					radioButtonActionUpLeft.setEnabled(false);
					comboBoxCornerUpLeft.setEnabled(false);
					textFieldCornerUpLeft.setEnabled(false);
				}
			}
		});

		checkBoxCornerDownLeft = new JCheckBox("Enabled");
		checkBoxCornerDownLeft.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				JCheckBox checkBox = (JCheckBox) arg0.getSource();
				boolean selected = checkBox.getModel().isSelected();
				if (selected) {
					radioButtonActionDownLeft.setEnabled(true);
					radioButtonCustomDownLeft.setEnabled(true);
					comboBoxCornerDownLeft.setEnabled(true);
					textFieldCornerDownLeft.setEnabled(true);
				} else {
					radioButtonActionDownLeft.setEnabled(false);
					radioButtonCustomDownLeft.setEnabled(false);
					comboBoxCornerDownLeft.setEnabled(false);
					textFieldCornerDownLeft.setEnabled(false);
				}
			}
		});

		radioButtonActionDownLeft = new JRadioButton("Action");
		radioButtonActionDownLeft.setEnabled(false);
		buttonGroup_1.add(radioButtonActionDownLeft);
		radioButtonActionDownLeft.setSelected(true);

		radioButtonCustomDownLeft = new JRadioButton("Custom");
		radioButtonCustomDownLeft.setEnabled(false);
		buttonGroup_1.add(radioButtonCustomDownLeft);

		comboBoxCornerDownLeft = new JComboBox();
		comboBoxCornerDownLeft.setEnabled(false);
		comboBoxCornerDownLeft.setModel(new DefaultComboBoxModel(Shortcuts.getShcts()));

		keyStoreCornerDownLeft = new KeyStore();
		
		textFieldCornerDownLeft = new KeyGrab(keyStoreCornerDownLeft);
		textFieldCornerDownLeft.setEnabled(false);
		textFieldCornerDownLeft.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				saveConfig();
				frame.dispose();
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(6)
								.addGroup(
										gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(checkBoxCornerUpLeft, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonActionUpLeft, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonCustomUpLeft, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(checkBoxCornerDownLeft, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonActionDownLeft, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonCustomDownLeft, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(
										gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBoxCornerUpLeft, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCornerUpLeft, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBoxCornerDownLeft, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCornerDownLeft, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addGap(10)
								.addComponent(label)
								.addGap(10)
								.addGroup(
										gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(checkBoxCornerUpRight, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonActionUpRight, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonCustomUpRight, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(checkBoxCornerDownRight, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonCustomDownRight, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
												.addComponent(radioButtonActionDownRight, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(
										gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(comboBoxCornerUpRight, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCornerUpRight, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBoxCornerDownRight, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldCornerDownRight, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
				.addGroup(
						gl_panel.createSequentialGroup().addGap(654).addComponent(btnCancel).addGap(10)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addGap(30)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_panel.createSequentialGroup().addComponent(checkBoxCornerUpLeft).addGap(3).addComponent(radioButtonActionUpLeft).addGap(3)
														.addComponent(radioButtonCustomUpLeft).addGap(150).addComponent(checkBoxCornerDownLeft).addGap(3).addComponent(radioButtonActionDownLeft)
														.addGap(3).addComponent(radioButtonCustomDownLeft))
										.addGroup(
												gl_panel.createSequentialGroup()
														.addGap(27)
														.addComponent(comboBoxCornerUpLeft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(6)
														.addComponent(textFieldCornerUpLeft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(179)
														.addComponent(comboBoxCornerDownLeft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(6)
														.addComponent(textFieldCornerDownLeft, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addComponent(label)
										.addGroup(
												gl_panel.createSequentialGroup().addComponent(checkBoxCornerUpRight).addGap(3).addComponent(radioButtonActionUpRight).addGap(3)
														.addComponent(radioButtonCustomUpRight).addGap(150).addComponent(checkBoxCornerDownRight).addGap(3).addComponent(radioButtonCustomDownRight)
														.addGap(3).addComponent(radioButtonActionDownRight))
										.addGroup(
												gl_panel.createSequentialGroup()
														.addGap(27)
														.addComponent(comboBoxCornerUpRight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(6)
														.addComponent(textFieldCornerUpRight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(179)
														.addComponent(comboBoxCornerDownRight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGap(6)
														.addComponent(textFieldCornerDownRight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))).addGap(25)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnCancel).addComponent(btnSave))));
		panel.setLayout(gl_panel);
	}

	protected void saveConfig() {
		ArrayList<IConfigData> config = new ArrayList<IConfigData>();
		boolean enabled = false;
		boolean custom = false;
		int option = 0;
		ArrayList<Integer> keyCodes = null;
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				enabled = checkBoxCornerUpLeft.isSelected();
				custom = radioButtonCustomUpLeft.isSelected();
				option = comboBoxCornerUpLeft.getSelectedIndex();
				keyCodes = keyStoreCornerUpLeft.getKeyCodesList();
			} else if (i == 1) {
				enabled = checkBoxCornerUpRight.isSelected();
				custom = radioButtonCustomUpRight.isSelected();
				option = comboBoxCornerUpRight.getSelectedIndex();
				keyCodes = keyStoreCornerUpRight.getKeyCodesList();
			} else if (i == 2) {
				enabled = checkBoxCornerDownLeft.isSelected();
				custom = radioButtonCustomDownLeft.isSelected();
				option = comboBoxCornerDownLeft.getSelectedIndex();
				keyCodes = keyStoreCornerDownLeft.getKeyCodesList();
			} else if (i == 3) {
				enabled = checkBoxCornerDownRight.isSelected();
				custom = radioButtonActionDownRight.isSelected();
				option = comboBoxCornerDownRight.getSelectedIndex();
				keyCodes = keyStoreCornerDownRight.getKeyCodesList();
			}
			config.add(new ConfigData(enabled, custom, option, keyCodes));
		}
		controller.setConfig(config);
	}

	public void setConfig(ArrayList<IConfigData> config) {
		String text;
		for (int i = 0; i < config.size(); i++) {
			IConfigData data = config.get(i);
			if (i == 0) {
				checkBoxCornerUpLeft.setSelected(data.isEnabled());
				radioButtonCustomUpLeft.setSelected(data.isCustom());
				radioButtonActionUpLeft.setSelected(!data.isCustom());
				comboBoxCornerUpLeft.setSelectedIndex(data.getSelectedOption());
				keyStoreCornerUpLeft.setKeyCodes(data.getCustomKeyCodes());
				text = "";
				for (int j = 0; j < data.getCustomKeyCodes().size(); j++) {
					if (j == 0) {
						text = KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					} else {
						text = text + "+" + KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					}
				}
				textFieldCornerUpLeft.setText(text);
			} else if (i == 1) {
				checkBoxCornerUpRight.setSelected(data.isEnabled());
				radioButtonCustomUpRight.setSelected(data.isCustom());
				radioButtonActionUpRight.setSelected(!data.isCustom());
				comboBoxCornerUpRight.setSelectedIndex(data.getSelectedOption());
				keyStoreCornerUpRight.setKeyCodes(data.getCustomKeyCodes());
				text = "";
				for (int j = 0; j < data.getCustomKeyCodes().size(); j++) {
					if (j == 0) {
						text = KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					} else {
						text = text + "+" + KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					}
				}
				textFieldCornerUpRight.setText(text);
			} else if (i == 2) {
				checkBoxCornerDownLeft.setSelected(data.isEnabled());
				radioButtonCustomDownLeft.setSelected(data.isCustom());
				radioButtonActionDownLeft.setSelected(!data.isCustom());
				comboBoxCornerDownLeft.setSelectedIndex(data.getSelectedOption());
				keyStoreCornerDownLeft.setKeyCodes(data.getCustomKeyCodes());
				text = "";
				for (int j = 0; j < data.getCustomKeyCodes().size(); j++) {
					if (j == 0) {
						text = KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					} else {
						text = text + "+" + KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					}
				}
				textFieldCornerDownLeft.setText(text);
			} else if (i == 3) {
				checkBoxCornerDownRight.setSelected(data.isEnabled());
				radioButtonActionDownRight.setSelected(data.isCustom());
				radioButtonCustomDownRight.setSelected(!data.isCustom());
				comboBoxCornerDownRight.setSelectedIndex(data.getSelectedOption());
				keyStoreCornerDownRight.setKeyCodes(data.getCustomKeyCodes());
				text = "";
				for (int j = 0; j < data.getCustomKeyCodes().size(); j++) {
					if (j == 0) {
						text = KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					} else {
						text = text + "+" + KeyEvent.getKeyText(data.getCustomKeyCodes().get(j));
					}
				}
				textFieldCornerDownRight.setText(text);
			}
		}
	}
}
