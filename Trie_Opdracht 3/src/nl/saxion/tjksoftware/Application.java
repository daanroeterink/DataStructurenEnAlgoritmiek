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
		trie.insert("Aap");
		trie.insert("Noot");
		trie.insert("Mies");
		trie.insert("Aardappel");
		trie.insert("Peer");
		trie.insert("Hond");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Application();
	}

}
