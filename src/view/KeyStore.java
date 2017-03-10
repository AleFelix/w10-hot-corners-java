package view;

import java.util.ArrayList;

import pl.mgorski.keygrab.Key;
import pl.mgorski.keygrab.KeyGrabCallback;

public class KeyStore implements KeyGrabCallback {
	
	private Key[] keys;

	@Override
	public void keysSet(Key[] keys) {
		this.keys = keys;
	}
	
	public Key[] getKeys() {
		return keys;
	}

	public ArrayList<Integer> getKeyCodesList() {
		ArrayList<Integer> keyCodes = new ArrayList<Integer>();
		for (int i = 0; i < keys.length; i++) {
			keyCodes.add(keys[i].getCode());
		}
		return keyCodes;
	}

	public void setKeyCodes(ArrayList<Integer> customKeyCodes) {
		keys = new Key[customKeyCodes.size()];
		for (int i = 0; i < customKeyCodes.size(); i++) {
			keys[i] = new Key(customKeyCodes.get(i));
		}
	}

}
