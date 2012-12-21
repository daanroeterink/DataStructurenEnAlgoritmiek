package nl.saxion.tjksoftware;

import java.util.HashMap;

public class Trie {

	private Node root;

	public Trie() {
		root = new Node();
	}

	public void insert(String s, Data d) {
		root.insert(s);
	}

	public Data search(String s) {

	}

	public void delete(String s) {

	}
}
