package first;
import java.util.*;
public class wordLadderII2 {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        wordList.add(beginWord);
        wordList.add(endWord);
        HashMap<String, ArrayList<String>> nbMap = new HashMap<String, ArrayList<String>>();
        for (String cand: wordList) {
            nbMap.put(cand, new ArrayList<String>());
        }
        HashMap<String, Integer> disMap = new HashMap<String, Integer>();
        ArrayList<String> path = new ArrayList<String>();
        
        bfs(endWord, wordList, nbMap, disMap);
        dfs(beginWord, endWord, wordList, nbMap, disMap, path, res);
        
        return res;
    }
    public void bfs(String beginWord, Set<String> wordList, HashMap<String, ArrayList<String>> nbMap, HashMap<String, Integer> disMap) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        //int level = 0;
        disMap.put(beginWord, 0);
        while (!queue.isEmpty()) {
            //level++;
            String node = queue.poll();
            ArrayList<String> neighbors = getNextWords(node, wordList);
            for (String nb: neighbors) {
                nbMap.get(node).add(nb);
                if (!disMap.containsKey(nb)) {
                    disMap.put(nb, disMap.get(node) + 1);
                    queue.offer(nb);
                }
            }
        }
    }
    public void dfs(String beginWord, String endWord, Set<String> wordList, HashMap<String, ArrayList<String>> nbMap, HashMap<String, Integer> disMap, ArrayList<String> path, ArrayList<List<String>> res) {
        path.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<String>(path));
            //return; //no return here, otherwise will remove less elements
        } else {
	        for (String word: nbMap.get(beginWord)) {
	            if (disMap.get(beginWord) != disMap.get(word) + 1) {
	                continue;
	            }
	            //path.add(word);
	            dfs(word, endWord, wordList, nbMap, disMap, path, res);
	            //path.remove(path.size() - 1);
	        }
        }
        path.remove(path.size() - 1);
    }
    public ArrayList<String> getNextWords (String s, Set<String> wordList) {
        int size = s.length();
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (s.charAt(i) == c) {
                    continue;
                }
                String newWord = s.substring(0, i) + c + s.substring(i + 1);
                if (wordList.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
    	wordLadderII2 wl = new wordLadderII2();
    	Set<String> wordList = new HashSet<String>();
    	//wordList.add("a");wordList.add("b");wordList.add("c");
    	//System.out.println(wl.findLadders("a", "c", wordList));
    	wordList.add("hot");wordList.add("cog");wordList.add("dog");wordList.add("tot");
    	wordList.add("hog");wordList.add("hop");wordList.add("pot");wordList.add("dot");
    	System.out.println(wl.findLadders("hot", "dog", wordList));
    }

}
