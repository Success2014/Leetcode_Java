package first;
import java.util.*;
public class wordBreakII2 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        ArrayList<String>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<String>();
        for (int i = 0; i <= n; i++) {
        	if (dp[i] == null) {
                continue;
            }
            for (String word: wordDict) {
                int len = word.length();
                int end = i + len;
                if (end > n) {
                    continue;
                }
                if (s.substring(i, end).equals(word)) {
                    if (dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        if (dp[n] == null) {
            return res;
        }
        dfs(dp, n, res, list);
        return res;
        
    }
    public void dfs(ArrayList<String>[] dp, int end, ArrayList<String> res, ArrayList<String> list) {
        if (end <= 0) {
            String path = list.get(list.size() - 1); //firstly take out the last one
            for (int i = list.size() - 2; i >= 0; i--) {
                path += " " + list.get(i);
            }
            res.add(path);
            return;
        }
        for (String word: dp[end]) {
            list.add(word);
            dfs(dp, end - word.length(), res, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args){
    	wordBreakII2 wb = new wordBreakII2();
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("cat");wordDict.add("cats");wordDict.add("sand");wordDict.add("and");wordDict.add("dog");
    	String s1 = "catsanddog";
    	System.out.println(wb.wordBreak(s1, wordDict));
    }

}
