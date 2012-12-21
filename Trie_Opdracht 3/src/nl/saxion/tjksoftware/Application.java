package nl.saxion.tjksoftware;

public class Application
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Trie trie = new Trie();
		trie.insert("Aap");
		trie.insert("Noot");
		trie.insert("Mies");
		trie.insert("Aardappel");
		trie.insert("Peer");
		trie.insert("Hond");
	}

}
