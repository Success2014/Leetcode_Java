package first;

import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.ArrayList;

public class wordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (wordList == null || wordList.size() == 0){
            return 0;
        }
        HashSet<String> words = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        int length = 1;
        queue.offer(beginWord);
        words.add(beginWord);
        
        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String node = queue.poll();
                for (String nb: getNextWord(node, wordList)){
                    if (words.contains(nb)){
                        continue;
                    }
                    if (nb.equals(endWord)){
                        return length;
                    }
                    words.add(nb);
                    queue.offer(nb);
                }
            }
        }
        return 0;
    }
    public ArrayList<String> getNextWord(String node, Set<String> wordList){
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < node.length(); i++){
            for (char c = 'a'; c <= 'z'; c++){
                if (c == node.charAt(i)){
                    continue;
                }
                String newNode = replace(node, c, i);
                if (wordList.contains(newNode)){
                    res.add(newNode);
                }
            }
        }
        return res;
    }
    public String replace(String node, Character c, int index){
        char[] nc = node.toCharArray();
        nc[index] = c;
        return new String(nc);
    }
}
