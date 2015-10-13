package first;


/*
class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children; 
    boolean isWord;
    public TrieNode() {
        this.isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
}
*/
public class Trie2 {
    private TrieNode root;

    public Trie2() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++){
            char curt = word.charAt(i);
            if (!temp.children.containsKey(curt)){
                TrieNode child = new TrieNode();
                temp.children.put(curt, child);
            }
            temp = temp.children.get(curt);
        }
        temp.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++){
            char curt = word.charAt(i);
            if (temp.children.containsKey(curt)){
                temp = temp.children.get(curt);
            }
            else{
                return false;
            }
        }
        return temp.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); i++){
            char curt = prefix.charAt(i);
            if (temp.children.containsKey(curt)){
                temp = temp.children.get(curt);
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