package first;

import java.util.Arrays;

public class longestValidParentheses {
	/**
	 * Use DP. if it is '(', ignore; if it is ')', count the number of '(' before.
	 * If this number is greater than dp[i], that is there is extra '(', dp[i]++.
	 * This method is wrong. 
	 * "()(()" only has 2 but will return 4.
	 * So if you only count the number, it is wrong.
	 * @param s
	 * @return
	 */
	public int longestValidParenthesesW(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++){
            dp[i] = dp[i-1];
            if (s.charAt(i-1) == ')'){
                int count = 0;
                for (int j = 1; j < i; j++){
                    if (s.charAt(j-1) == '('){
                        count++;
                    }
                }
                if (count > dp[i]){
                    dp[i] += 1;
                }
            }
        }
        return 2*dp[n];
    }
	
	//http://www.cnblogs.com/zuoyuan/p/3780312.html
	//http://bangbingsyb.blogspot.com/2014/11/leetcode-longest-valid-parentheses.html
	//http://www.programcreek.com/2014/06/leetcode-longest-valid-parentheses-java/
	//http://www.jiuzhang.com/solutions/longest-valid-parentheses/
	//http://www.cnblogs.com/yuzhangcmu/p/4113654.html
	
	
	
	//https://www.youtube.com/watch?v=LMic1M7r6e4&index=31&list=PLvHc59peqCbM43SNkoQpk59Ys05kHbHjH
	/**
	 * dp[i] is the length of longest valid parentheses.
	 * stack is NOT a really STACK, but a number to record the number of '('.
	 * When we see a ')', if we still have '(', dp[i] = dp[i-1]+2;
	 * if i - dp[i] >= 0, then we need to add dp[i-dp[i]], meaning we need to 
	 * concatenate these numbers.
	 *  0 1 2 3 4 5
	 *  ( ( ) ) ( )
	 *  0 0 2 4 0 2+4
	 * @param s
	 * @return
	 */
	public int longestValidParenthesesM1(String s) {
        int n = s.length();
        if (s == null || n < 2){
            return 0;
        }
        int[] dp = new int[n];
        int maxLen = 0;
        int stack = 0;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '('){
                stack++;
            }
            else{
                if (stack > 0){
                    stack--;
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i] >= 0){
                        dp[i] += dp[i - dp[i]];
                    }
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return maxLen;
    }
	
	public static void main(String[] args){
		longestValidParentheses lvp = new longestValidParentheses();
		String s1 = "()(()";
		System.out.println(lvp.longestValidParenthesesW(s1));
		System.out.println(lvp.longestValidParenthesesM1(s1));
	}

}
