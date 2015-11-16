package first;
import java.util.*;
public class wordLadder2 {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        int level = 1;
        queue.offer(beginWord);
        hs.add(beginWord);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                ArrayList<String> neighbors = findNeighbors(node, wordList);
                for (String nb: neighbors) {
                    if (nb.equals(endWord)) {
                        return level;
                    }
                    if (!hs.contains(nb)) {
                        hs.add(nb);
                        queue.offer(nb);
                    }
                }
            }
        }
        return 0;
    }
    public ArrayList<String> findNeighbors (String node, Set<String> wordList) {
        ArrayList<String> res = new ArrayList<String>();
        int n = node.length();
        for (int i = 0; i < n; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == node.charAt(i)) {
                    continue;
                }
                String newWord = replaceWord(node, i, c);
                if (wordList.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }
    public String replaceWord(String word, int index, char c) {
        char[] temp = word.toCharArray();
        temp[index] = c;
        return new String(temp);
    }
    
    public static void main(String[] args) {
    	wordLadder2 wl = new wordLadder2();
    	Set<String> set = new HashSet<String>();
    	set.add("a");set.add("b");set.add("c");
    	System.out.println(wl.ladderLength("a", "c", set));
    }

}
