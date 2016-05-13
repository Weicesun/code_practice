// worddictionary

public class WordDictionary {

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode root1 = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root1.children[index] == null) {
                root1.children[index] = new TrieNode();
                root1 = root1.children[index];
            } else {
                root1 = root1.children[index];
            }
        }
        root1.isleaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word.toCharArray(), 0, root);
    }
    public boolean search(char[] array, int index, TrieNode root1) {
        if(index == array.length) {
            if (root1.isleaf) {
                return true;
            }
            return false;
        }
        if (array[index] == '.') {
            for (int i = 0; i < 26; i++) {
                if (root1.children[i] == null) {
                    continue;
                }
                if (search(array, index + 1, root1.children[i])) {
                    return true;
                }
            }
            return false;
        }
        int in = array[index] - 'a';
        if (root1.children[in] == null) {
            return false;
        }
        return search(array, ++index, root1.children[in]);
    }
}


// trie
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children = new TrieNode[26];
    boolean isleaf;
    public TrieNode() {
        isleaf = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode root1 = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root1.children[index] == null) {
                root1.children[index] = new TrieNode();
                root1 = root1.children[index];
            } else {
                root1 = root1.children[index];
            }
        }
        root1.isleaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
         TrieNode root1 = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (root1.children[index] == null) {
                return false;
            } else {
                root1 = root1.children[index];
            }
        }
        if (root1.isleaf) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
         TrieNode root1 = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (root1.children[index] == null) {
                return false;
            } else {
                root1 = root1.children[index];
            }
        }
        return true;
    }
}

