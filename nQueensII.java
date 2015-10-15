package first;

import java.util.ArrayList;


public class nQueensII {
	private int c = 0;
    public int totalNQueens(int n) {
        if (n == 0){
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        search(n, list);
        return c;
    }
    
    public void search(int n, ArrayList<Integer> list){
        if (list.size() == n){
            c++;
        }
        for (int i = 0; i < n; i++){
            if (!isValid(list, i)){
                continue;
            }
            list.add(i);
            search(n, list);
            list.remove(list.size() -1);
        }
    }
    public boolean isValid(ArrayList<Integer> list, int numToAdd){
        int size = list.size();
        for (int j = 0; j < size; j++){
            if (numToAdd == list.get(j)){
                return false;
            }
            if ((size - j) == Math.abs(numToAdd - list.get(j))){
                return false;
            }
        }
        return true;
    }

}
