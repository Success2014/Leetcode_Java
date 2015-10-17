package first;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class wordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (wordList == null || wordList.size() == 0){
            return result;
        }
        
        wordList.add(beginWord);
        wordList.add(endWord);
        
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (String s: wordList){
            map.put(s, new ArrayList<String>());
        }
        
        
        bfs(endWord, wordList, distance, map);
        ArrayList<String> path = new ArrayList<String>();
        dfs(beginWord, endWord, distance, map, path, result);
        return result;
    }
    
    public void bfs(String beginWord, Set<String> wordList, HashMap<String, Integer> distance, HashMap<String, ArrayList<String>> map){
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        
        while(!queue.isEmpty()){
            String node = queue.poll();
            for (String nb: getNextWord(node, wordList)){
                map.get(node).add(nb);
                if (!distance.containsKey(nb)){
                    distance.put(nb, distance.get(node) + 1);
                    queue.offer(nb);
                }
                
            }
        }
        
    }
    
    public ArrayList<String> getNextWord(String node, Set<String> wordList){
        ArrayList<String> res = new ArrayList<String>();
        int size = node.length();
        for (int i = 0; i < size; i++){
            for (char c = 'a'; c <= 'z'; c++){
                if (c == node.charAt(i)){
                    continue;
                }
                String newWord = node.substring(0, i) + c + node.substring(i + 1);
                if (wordList.contains(newWord)){
                    res.add(newWord);
                }
            }
        }
        return res;
    }
    
    public void dfs(String beginWord, String endWord, HashMap<String, Integer> distance, HashMap<String, ArrayList<String>> map, ArrayList<String> path, ArrayList<List<String>> result){
        path.add(beginWord);
        if (beginWord.equals(endWord)){
            result.add(new ArrayList<String>(path));
        }
        else{
            ArrayList<String> nextWord = map.get(beginWord);
            for (String nb: nextWord){
                if (distance.get(nb) == distance.get(beginWord) - 1){
                    dfs(nb, endWord, distance, map, path, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }

}
