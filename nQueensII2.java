package first;
import java.util.*;
public class nQueensII2 {
	int count;
    public int totalNQueens(int n) {
        count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        search(n, list);
        return count;
    }
    public void search(int n, ArrayList<Integer> list) {
        if (list.size() == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(list, i)) {
                continue;
            }
            list.add(i);
            search(n, list);
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
}
