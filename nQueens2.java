package first;
import java.util.*;
public class nQueens2 {
	public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        if (n == 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        search(n, res, list);
        return res;
    }
    public void search(int n, ArrayList<List<String>> res, ArrayList<Integer> list) {
        if (list.size() == n) {
            res.add(drawBoard(new ArrayList<Integer>(list)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(list, i)) {
                continue;
            }
            list.add(i);
            search(n, res, list);
            list.remove(list.size() - 1);
        }
    }
    public boolean isValid(ArrayList<Integer> list, int x) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.contains(x)) {
                return false;
            }
            if ((size - i) == Math.abs(x - list.get(i))) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<String> drawBoard (ArrayList<Integer> list) {
        ArrayList<String> res = new ArrayList<String>();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == list.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

}
