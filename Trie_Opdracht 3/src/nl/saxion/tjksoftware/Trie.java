package nl.saxion.tjksoftware;

import java.util.HashMap;

public class Trie
{

	/**
	 * The root Node for the Trie
	 */

	private HashMap<Character, Node> childs = new HashMap<Character, Node>();

	/**
	 * Empty constructor that will create the Trie
	 */
	public Trie()
	{

	}

	/**
	 * Insert a string in the Trie
	 * 
	 * @param s
	 *            The string that will be inserted
	 */
	public void insert(String s, Data d)
	{
		if (s.length() > 0)
		{
			s = s.toLowerCase();
			if (!childs.containsKey(s.charAt(0)))
			{
				childs.put(s.charAt(0), new Node(s, d));
			}
			else
			{
				childs.get(s.charAt(0)).insert(s.substring(1), d);
			}
		}
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
		if (s.length() > 0)
		{
			char c = s.charAt(0);
			if (childs.containsKey(c))
			{
				if (s.length() > 1)
					return childs.get(c).search(s.substring(1));
			}
		}
		return null;
	}

	/**
	 * This will delete the given string from the Trie.
	 * 
	 * @param s
	 *            the string to delete.
	 * @return amount of deleted words.
	 */
	public int delete(String s)
	{
		int amount = 0;
		Data d = search(s);
		if (d != null)
		{
			amount = d.getLocations().size();
			if (amount > 0)
			{
				childs.get(s.charAt(0)).delete(s.substring(1));
				if (childs.get(s.charAt(0)).getChilds().size() == 0)
				{
					childs.remove(s.charAt(0));
				}
			}
		}
		return amount;
	}
}
