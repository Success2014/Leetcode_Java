package first;

import java.util.List;
import java.util.ArrayList;



public class nQueens {
	public List<List<String>> solveNQueens(int n) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        if (n == 0){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        search(n, list, res);
        return res;
    }
    public void search(int n, ArrayList<Integer> list, ArrayList<List<String>> res){
        if (list.size() == n){
            res.add(drawBoard(list));
            return;
        }
        for (int i = 0; i < n; i++){
            if (!isValid(list, i)){
                continue;
            }
            list.add(i);
            search(n, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isValid(ArrayList<Integer> list, int numToAdd){
        int size = list.size();
        for (int j = 0; j < size; j++){
            if (list.get(j) == numToAdd){//check row
                return false;
            }
            if ((size - j) == Math.abs(numToAdd - list.get(j))){//check diagonal
                return false;
            }
        }
        return true;
    }
    public ArrayList<String> drawBoard(ArrayList<Integer> list){
        int size = list.size();
        ArrayList<String> rst = new ArrayList<String>(); 
        for (int i = 0; i < size; i++){//row and column are exchangable
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < size; j++){
                if (j == list.get(i)){
                    temp.append("Q");
                }
                else{
                    temp.append(".");
                }
            }
            rst.add(temp.toString());
        }
        return rst;
    }

}
