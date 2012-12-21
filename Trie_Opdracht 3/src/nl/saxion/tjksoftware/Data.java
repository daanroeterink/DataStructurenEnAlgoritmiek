package nl.saxion.tjksoftware;

import java.util.ArrayList;

public class Data {

	private char c;
	private ArrayList<Integer> locations = new ArrayList<Integer>();
	private boolean endOfWord;

	public void addLocation(int location) {
		locations.add(location);
	}

	public void setChar(char newChar) {
		c = newChar;
	}
	
	public void setEndOfWord(boolean value) {
		endOfWord = value;
	}

}
