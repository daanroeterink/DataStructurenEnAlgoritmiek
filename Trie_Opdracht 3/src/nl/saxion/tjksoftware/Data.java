package nl.saxion.tjksoftware;

import java.util.ArrayList;

public class Data
{

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
}
