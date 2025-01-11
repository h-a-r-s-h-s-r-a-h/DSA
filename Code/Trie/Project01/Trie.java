package Code.Trie.Project01;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    private class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26]; // storing english words - a -> z
            this.isWord = false;
        }
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input !!!");
        }

        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            } else {
                current = current.children[index];
            }
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid Input !!!");
        }

        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (current.children[index] == null) {
                return false; // Word does not exist
            }
            current = current.children[index];
        }
        return current.isWord; // Return true if it's a valid word
    }

    public void display() {
        displayHelper(root, "");
    }

    private void displayHelper(TrieNode node, String prefix) {
        if (node == null) {
            return;
        }

        if (node.isWord) {
            System.out.println(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char c = (char) (i + 'a');
                displayHelper(node.children[i], prefix + c);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("cat");
        trie.insert("kaliBilli");
        trie.insert("cab");
        trie.insert("son");
        trie.insert("so");

        // Test search functionality
        System.out.println("Searching for 'cat': " + trie.search("cat")); // true
        System.out.println("Searching for 'dog': " + trie.search("dog")); // false
        System.out.println("Searching for 'kaliBilli': " + trie.search("kaliBilli")); // true

        // Display all words in the Trie
        System.out.println("Words in the Trie:");
        trie.display();
    }
}
