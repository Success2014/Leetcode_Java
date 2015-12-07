package first;
import java.util.*;

public class addAndSearchWord {
    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isWord = false;
        public TrieNode() {}
        public TrieNode(char c) {
            this.c = c;
        }
    }
    
    TrieNode root;
    public addAndSearchWord() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            if (!node.children.containsKey(w)) {
                node.children.put(w, new TrieNode(w));
            }
            node = node.children.get(w);
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return find(word, 0, root);
    }
    
    public boolean find(String word, int index, TrieNode node) {
        if (index == word.length()) {
            if (node.children.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
        
        char t = word.charAt(index);
        if (node.children.containsKey(t)) {
            if (index == word.length() - 1 && node.children.get(t).isWord) {
                return true;
            }
            node = node.children.get(t);
            return find(word, index + 1, node);
        } else if (t == '.') {
        	for (Map.Entry<Character, TrieNode> children : node.children.entrySet()) {
                if (index == word.length() - 1 && children.getValue().isWord) {
                    return true;
                }
                if (find(word, index + 1, children.getValue())) {
                    return true;
                }
            }
        } 
        return false;
        
    }
    public static void main(String[] args) {
    	addAndSearchWord asw = new addAndSearchWord();
    	asw.addWord("a");
    	System.out.println(asw.search("."));
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
