package nl.saxion.tjksoftware;

import java.util.HashMap;

public class Node
{

	private char c;

	private Data d;

	private HashMap<Character, Node> childs = new HashMap<Character, Node>();

	public Node()
	{

	}

	public Node(String s)
	{
		insert(s);
	}

	/**
	 * 
	 * @param s
	 */
	public void insert(String s)
	{

		if (s.length() > 0)
		{
			if (c == 0)
			{
				c = s.charAt(0);
			}
			else
			{
				if (s.length() > 1)
				{
					if (childs.containsKey(s.charAt(1)))
					{
						childs.put(s.charAt(1), new Node(s.substring(1)));
					}
				}
			}
		}
		// Last character in this word
		if (s.length() == 1)
		{
			d = new Data();
		}
	}
}
