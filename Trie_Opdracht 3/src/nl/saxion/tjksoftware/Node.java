package nl.saxion.tjksoftware;

import java.util.HashMap;

public class Node
{

	private char c;

	private Data d;

	private HashMap<Character, Node> childs = new HashMap<Character, Node>();

	public HashMap<Character, Node> getChilds()
	{
		return childs;
	}

	public Node()
	{

	}

	public Node(String s, Data d)
	{
		insert(s, d);
	}

	/**
	 * 
	 * @param s
	 */
	public void insert(String s, Data d)
	{
		if (s.length() > 0)
		{
			if (!childs.containsKey(s.charAt(0)))
			{
				if (c == 0)
				{
					c = s.charAt(0);
				}
				if (s.length() > 1)
				{
					if (!childs.containsKey(s.charAt(0)))
					{
						childs.put(s.charAt(0), new Node(s.substring(1), d));
					}
					childs.get(s.charAt(0)).insert(s.substring(1), d);
				}
			}
			else
			{
				childs.get(s.charAt(0)).insert(s.substring(1), d);
			}
		}
		// Last character in this word
		if (s.length() == 0)
		{
			if (this.d == null)
			{
				this.d = d;
			}
			else
			{
				this.d.addLocation(d.getLocations().get(0));
			}
		}
	}

	public Data search(String s)
	{
		if (s.length() == 1)
		{
			if (d != null)
			{
				return d;
			}
		}
		if (s.length() > 0)
		{
			char cTemp = s.charAt(0);
			if (childs.containsKey(cTemp))
			{
				if (s.length() > 1)
					return childs.get(cTemp).search(s.substring(1));
				else if (s.length() == 1)
				{
					cTemp = s.charAt(0);
					if (childs.containsKey(cTemp))
					{
						return childs.get(cTemp).d;
					}
				}
			}
		}
		return null;
	}

	public void delete(String s)
	{
		if (s.length() > 0)
		{
			childs.get(s.charAt(0)).delete(s.substring(1));
			if (childs.get(s.charAt(0)).getChilds().size() == 0)
			{
				childs.remove(s.charAt(0));
			}
		}
		if (s.length() == 0)
		{
			this.d = null;
		}
	}
}
