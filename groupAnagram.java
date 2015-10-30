package first;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
public class groupAnagram {
	public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        if (strs.length == 0){
            return res;
        }
        Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++){
            String word = strs[i];
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String newWord = String.valueOf(wordArr);
            //String newWord = wordArr.toString(); // this will be wrong
            if (!map.containsKey(newWord)){
                map.put(newWord, new ArrayList<String>());
            }
            map.get(newWord).add(word);
        }
        return new ArrayList<List<String>>(map.values());
    }
	public static void main(String[] args){
		groupAnagram ga = new groupAnagram();
		String[] strs = {"", ""};
		System.out.println(ga.groupAnagrams(strs));
	}

}
