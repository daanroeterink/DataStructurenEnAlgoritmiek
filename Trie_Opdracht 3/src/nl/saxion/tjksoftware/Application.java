package nl.saxion.tjksoftware;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application
{
	public static final String FILENAME = "input.txt";

	private Scanner scanner;

	public Application()
	{

		try
		{
			scanner = new Scanner(new File(Application.FILENAME));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		Trie trie = new Trie();
		int teller = 1;
		while (scanner.hasNext())
		{
			Data data = new Data();
			data.addLocation(teller);
			trie.insert(scanner.next(), data);
			teller++;
		}
		System.out.println("" + teller);
		System.out.println("Aantal verwijderd: " + trie.delete("de"));
		Data result = trie.search("den");
		if (result != null)
		{
			System.out.println("Gevonden aantal: " + result.getLocations().size());

		}
		else
		{
			System.out.println("Niet gevonden!");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Application();
	}

}
