package first;
import java.util.*;
public class palindromePartition4 {
	public List<List<String>> partition(String s) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> list = new ArrayList<String>();
        boolean[][] flag = getIsPal(s);
        dfs(s, res, list, 0, flag);
        return res;
    }
    public void dfs(String s, ArrayList<List<String>> res, ArrayList<String> list, int pos, boolean[][] flag) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            if (!flag[pos][i - 1]) {
                continue;
            }
            list.add(s.substring(pos, i));
            dfs(s, res, list, i, flag);
            list.remove(list.size() - 1);
        }
    }
    public boolean[][] getIsPal(String s) {
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                flag[i][j] = isPal(s, i, j);
            }
        }
        return flag;
    }
    public boolean isPal(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
