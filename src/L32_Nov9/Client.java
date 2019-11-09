package L32_Nov9;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 09-Nov-2019
 *
 */

public class Client {

	public static void main(String[] args) {

		// System.out.println(patternMatching("abcefghi", "ghe"));

		Trie trie = new Trie();
		trie.addWord("be");
		trie.addWord("bee");
		trie.addWord("bet");
		trie.addWord("been");
		trie.addWord("see");
		trie.addWord("sea");
		trie.addWord("seen");

		trie.display();

		trie.removeWord("be");
		trie.removeWord("bet");
		trie.removeWord("bee");
		trie.removeWord("been");

		trie.display();

	}

	private static int patternMatching(String src, String pat) {

		for (int slide = 0; slide <= src.length() - pat.length(); slide++) {

			int i = 0;
			while (i < pat.length() && pat.charAt(i) == src.charAt(slide + i)) {
				i++;
			}

			if (i == pat.length()) {
				return slide;
			}

		}

		return -1;

	}
}
