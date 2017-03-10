package controller;

import java.util.ArrayList;

public class ConfigData implements IConfigData {

	private boolean enabled;
	private boolean custom;
	private int option;
	private ArrayList<Integer> customKeys;

	public ConfigData(boolean enabled, boolean custom, int option, ArrayList<Integer> customKeys) {
		this.enabled = enabled;
		this.custom = custom;
		this.option = option;
		this.customKeys = customKeys;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public boolean isCustom() {
		return custom;
	}

	@Override
	public int getSelectedOption() {
		return option;
	}

	@Override
	public ArrayList<Integer> getCustomKeyCodes() {
		return customKeys;
	}

}
