package nl.saxion.tjksoftware;

public class Trie
{

	/**
	 * The root Node for the Trie
	 */
	private Node root;

	/**
	 * Empty constructor that will create the Trie
	 */
	public Trie()
	{
		root = new Node();
	}

	/**
	 * Insert a string in the Trie
	 * 
	 * @param s
	 *            The string that will be inserted
	 */
	public void insert(String s)
	{
		root.insert(s);
	}

	/**
	 * This will search a word in the trie
	 * 
	 * @param s
	 *            The string that will be searched for
	 * @return Data that has been found
	 * 
	 */
	public Data search(String s)
	{
		// TODO: Create a search function
		return null;
	}

	/**
	 * This will delete the given string from the Trie.
	 * 
	 * @param s
	 *            the string to delete.
	 */
	public void delete(String s)
	{
		// TODO: Create a delete function
	}
}
