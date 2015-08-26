package first;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/**
 * http://www.cnblogs.com/zuoyuan/p/3779978.html
 * Idea: Like implement strstr. 
 * Use a hashmap to store each word and the number of appearance. 
 * Then use two pointers to scan the string. Since all the words have the same length, so we
 * can scan them word by word. If the word is not in the hashmap, break and move the first pointer by 1.
 * We could use another hashmap to see if the number of appearance is the same. If not the same, break.
 * 
 * @author Neo
 *
 */
public class substringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        //generate the hashmap for all the words
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        for (String word: words){
            if (wordsMap.containsKey(word)){
                wordsMap.put(word, wordsMap.get(word) + 1);
            }
            else{
                wordsMap.put(word, 1);
            }
        }
        int wordLen = words[0].length();
        int wordNum = words.length;
        
        for (int i = 0; i < s.length() - wordLen*wordNum + 1;i++){//first pointer
            //use a hashmap to keep track of the result
            Map<String, Integer> cur = new HashMap<String, Integer>();
            int j = 0;//second pointer
            while (j < wordNum){
                String tmp = s.substring(i+j*wordLen, i+j*wordLen+wordLen);//get the substring
                if (!wordsMap.containsKey(tmp)) break;
                if (cur.containsKey(tmp)){
                    cur.put(tmp, cur.get(tmp) + 1);
                }
                else{
                    cur.put(tmp, 1);
                }
                if (cur.get(tmp) > wordsMap.get(tmp)) break;//if appear too many times, break
                j++;
            }
            if (j == wordNum) res.add(i);
        }
        return res;
    }
	
	public static void main (String[] args){
		substringWithConcatenationOfAllWords sca = new substringWithConcatenationOfAllWords();
		String s = "barfoothefoobarman";
		String[] words = {"foo", "bar"};
		System.out.println(sca.findSubstring(s, words));
	}

}
