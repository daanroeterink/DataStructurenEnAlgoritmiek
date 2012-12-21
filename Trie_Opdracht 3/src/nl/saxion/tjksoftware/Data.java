package nl.saxion.tjksoftware;

import java.util.ArrayList;

public class Data
{

	private char c;

	private ArrayList<Integer> locations = new ArrayList<Integer>();

	/**
	 * This will add a location to the Locations list
	 * 
	 * @param location
	 *            The location to be set
	 */
	public void addLocation(int location)
	{
		locations.add(location);
	}

	/**
	 * This will set the character for this Data
	 * 
	 * @param newChar
	 *            Character that will be set
	 */
	public void setChar(char newChar)
	{
		c = newChar;
	}

	/**
	 * This will set the boolean EndOfWord.
	 * 
	 * @param value
	 *            boolean that will be set
	 */
	public void setEndOfWord(boolean value)
	{
		endOfWord = value;
	}

}
