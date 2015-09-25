package first;

import java.util.Map;
import java.util.HashMap;

class TrieNode {
    // Initialize your data structure here.
    char c;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isWord;
    public TrieNode() {
    }
    public TrieNode(char c){
        this.c = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = new TrieNode();
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (children.containsKey(c)){
                t = children.get(c);
            }
            else{
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
        }
        t.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (t.children.containsKey(c)){
                t = t.children.get(c);
            }
            else{
                return false;
            }
        }
        return t.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (t.children.containsKey(c)){
                t = t.children.get(c);
            }
            else{
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");