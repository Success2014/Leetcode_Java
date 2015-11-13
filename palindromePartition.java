package first;

import java.util.List;
import java.util.ArrayList;

public class palindromePartition {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0){
            return res;
        }
        List<String> list = new ArrayList<String>();
        helper(s, res, list, 0);
        return res;
        
    }
    
    public boolean isPal(String s, int start, int end){//including end
        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    public void helper(String s, List<List<String>> res, List<String> list, int pos){
        if (pos == s.length()){ // note the criteria here
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++){
            if (isPal(s,pos,i - 1)){
                list.add(new String(s.substring(pos,i))); //no need to create new string
                helper(s, res, list, i);// I wrote pos + 1 at the beginning, took me 1 hour to find this error
                list.remove(list.size() - 1);
            }            
        }
    }
    
    public static void main(String[] args){
    	palindromePartition pp = new palindromePartition();
    	//String s1 = "ab";
    	//System.out.println(pp.partition(s1));
    	//String s2 = "seeslaveidemonstrateyetartsnomedievalsees";
    	//System.out.println(pp.partition(s2));
    	String s3 = "aab";
    	System.out.println(pp.partition(s3));
    }
    

}
