package first;
import java.util.*;
public class wordSearchII {
	class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isWord = false;
        public TrieNode() {}
        public TrieNode(char c) {
            this.c = c;
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }
        public void insert(String word) {
            HashMap<Character, TrieNode> children = root.children;
            TrieNode t = new TrieNode();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!children.containsKey(c)) {
                    t = new TrieNode(c);
                    children.put(c, t);
                }
                t = children.get(c);
                children = t.children;
            }
            t.isWord = true;
        }
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
        public boolean prefix(String word) {
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
            return true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> res = new ArrayList<String>();
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            	visited[i][j] = true;
                dfs(board, res, trie, i, j, "", visited);
                visited[i][j] = false;
            }
        }
        return res;
    }
    public void dfs(char[][] board, List<String> res, Trie trie, int x, int y, String s, boolean[][] visited) {
        //visited[x][y] = true;
        int m = board.length;
        int n = board[0].length;
        char c = board[x][y];
        String pre = s + c;
        if (!trie.prefix(pre)) {
            return;
        } 
        if (trie.search(pre) && !res.contains(pre)) {
            res.add(new String(pre));
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < m && nextY >=0 && nextY < n && !visited[nextX][nextY]) {
            	visited[nextX][nextY] = true;
                dfs(board, res, trie, nextX, nextY, pre, visited);
                visited[nextX][nextY] = false;
            }
        }
        //visited[x][y] = false;
    }
    
    public static void main(String[] args) {
    	wordSearchII ws = new wordSearchII();
    	char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
    	String[] words = {"oath","pea","eat","rain"};
    	System.out.println(ws.findWords(board, words));
    }

}
