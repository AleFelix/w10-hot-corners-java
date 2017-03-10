package controller;

import java.util.ArrayList;

public interface IConfigData {

	public boolean isEnabled();
	public boolean isCustom();
	public int getSelectedOption();
	public ArrayList<Integer> getCustomKeyCodes();
	
}
