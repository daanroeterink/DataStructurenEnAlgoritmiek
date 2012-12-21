package nl.saxion.tjksoftware;

import java.util.HashMap;

public class Node {

	private char c;

	private Data d;

	private HashMap<Character, Node> childs = new HashMap<Character, Node>();

	public Node() {

	}

	public Node(String s, Data d) {
		insert(s, d);
	}

	/**
	 * 
	 * @param s
	 */
	public void insert(String s, Data d) {

		if (s.length() > 0) {
			if (c == 0) {
				c = s.charAt(0);
			} else {
				if (s.length() > 1) {
					if (!childs.containsKey(s.charAt(1))) {
						childs.put(s.charAt(1), new Node(s.substring(1), d));
					}
				}
			}
		}
		// Last character in this word
		if (s.length() == 1) {
			if (d == null) {
				this.d = d;
			} else {
				d.addLocation(d.getLocations().get(0));
			}
		}
	}

	public Data search(String s) {
		if (s.length() == 1) {
			if (d != null) {
				return d;
			}
		}
		if (s.length() > 0) {
			char c = s.charAt(0);
			if (childs.containsKey(c)) {
				if (s.length() > 1)
					return childs.get(c).search(s.substring(1));
				else
					return null;
			}
		}
		return null;
	}
}
