package nl.saxion.tjksoftware;

import java.util.HashMap;
import java.util.List;

public class Node
{

	private char c;

	private List<Data> d;

	private HashMap<Character, Node> childs = new HashMap<Character, Node>();

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
						childs.put(s.charAt(1), new Node());
					}
				}
			}
		}
	}
}
