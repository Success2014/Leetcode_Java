package first;

import java.util.Set;
import java.util.HashSet;

public class wordBreak {
	public boolean wordBreakM(String s, Set<String> wordDict) {
        int n = s.length();
        if (s == null || n == 0){
            return true;
        }
        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;        
        for (int i = 1; i < n + 1; i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && wordDict.contains(s.substring(j,i))){                	
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
	
	/**
	 * Optimized version. We only need to look back at most maxLen positions.
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreakM2(String s, Set<String> wordDict) {
        int n = s.length();
        if (s == null || n == 0){
            return true;
        }
        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;    
        int maxLen = getMaxLength(wordDict);
        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j <= i && j <= maxLen; j++){//look back from i-1. Note two equal signs.
                if (!dp[i - j]){
                    continue;
                }
                String tmp = s.substring(i-j,i);
                if (wordDict.contains(tmp)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
	
	
    
    public int getMaxLength(Set<String> wordDict){
        int maxLen = 0;
        for (String word: wordDict){
            maxLen = Math.max(maxLen, word.length());
        }
        return maxLen;
    }
    
    public static void main(String[] args){
    	wordBreak wb = new wordBreak();
    	Set<String> wordDict = new HashSet<String>();
    	wordDict.add("leet");wordDict.add("code");wordDict.add("see");wordDict.add("you");
    	String s1 = "leetcodeseeyousee";
    	System.out.println(wb.wordBreakM(s1, wordDict));
    }

}
