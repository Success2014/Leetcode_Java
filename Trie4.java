package first;

import java.util.*;

public class Trie4 {
	/*
	class TrieNode {
	    // Initialize your data structure here.
	    char c;
	    boolean isWord;
	    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();;
	    public TrieNode(char c) {
	        this.c = c;
	        this.isWord = false;
	    }
	    public TrieNode() {}
	}
	*/
    private TrieNode root;

    public Trie4() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = new TrieNode();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            t = new TrieNode(c);
            if (!children.containsKey(c)) {
                children.put(c, t);
            }
            t = children.get(c);
            children = t.children;
        }
        t.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = new TrieNode();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) {
                return false;
            }
            t = children.get(c);
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
            char c = prefix.charAt(i);
            if (!children.containsKey(c)) {
                return false;
            }
            t = children.get(c);
            children = t.children;
        }
        return true;
    }
}

