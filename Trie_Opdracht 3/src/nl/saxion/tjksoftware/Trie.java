package nl.saxion.tjksoftware;

import java.util.HashMap;

public class Trie {

	/**
	 * The root Node for the Trie
	 */

	private HashMap<Character, Node> childs = new HashMap<Character, Node>();

	/**
	 * Empty constructor that will create the Trie
	 */
	public Trie() {

	}

	/**
	 * Insert a string in the Trie
	 * 
	 * @param s
	 *            The string that will be inserted
	 */
	public void insert(String s, Data d) {
		if (s.length() > 0) {
			s = s.toLowerCase();
			if (s.length() > 1) {
				childs.put(s.charAt(0), new Node(s.substring(0), d));
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
	public Data search(String s) {
		if (s.length() > 0) {
			char c = s.charAt(0);
			if (childs.containsKey(c)) {
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
	 */
	public void delete(String s) {
		// TODO: Create a delete function
	}

	public void fancyPrint() {

	}
}
