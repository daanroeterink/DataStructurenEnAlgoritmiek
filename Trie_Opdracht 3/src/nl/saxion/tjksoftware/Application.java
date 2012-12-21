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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Trie trie = new Trie();
		int teller = 1;
		while (scanner.hasNext() && teller < 100)
		{
			Data data = new data();
			data.addLocation(teller);
			trie.insert(scanner.next(), data);
			teller++;
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
