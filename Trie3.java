package first;
import java.util.*;
/*
class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isWord = false;
    // Initialize your data structure here.
    public TrieNode() {
    }
    public TrieNode(char c) {
        this.c = c;
    }
}
*/
public class Trie3 {
    private TrieNode root;

    public Trie3() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = new TrieNode();
        for (int i = 0; i < word.length(); i++) {
            char s = word.charAt(i);
            if (children.containsKey(s)) {
                t = children.get(s);
            } else {
                t = new TrieNode(s);
                children.put(s, t);
            }
            children = t.children;
        }
        t.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = new TrieNode();
        for (int i = 0; i < word.length(); i++) {
            if (children.containsKey(word.charAt(i))) {
                t = children.get(word.charAt(i));
            } else {
                return false;
            }
            children = t.children;
        }
        return t.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = new TrieNode();
        for (int i = 0; i < prefix.length(); i++) {
            if (children.containsKey(prefix.charAt(i))) {
                t = children.get(prefix.charAt(i));
            } else {
                return false;
            }
            children = t.children;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");