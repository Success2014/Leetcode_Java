/**
 * 
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
For example, Given S = “eceba”, T is "ece" which its length is 3.
思路：
http://blog.csdn.net/whuwangyi/article/details/42451289
感觉这个思路比官方的答案思路好。

要找最长的字段，这个字段最多包含2个字符。用一个HashMap记录下每个字符最后出现的位置。用maxLen一直记录最长字段的长度。
start来标记当前最长字符串的起点。
当HashMap中的key超过2个时，需要删除一个key。删除哪个呢？删除最左边那个。因为哈希表中只有2个key，所以找出最左边那个只需要O(1).
总的复杂度是O(n).

扩展题：
同样是找最长的字段，这个字段最多包含k个字符。也是用一个HashMap来记录下每个字符出现的次数。用maxLen一直记录最长字段的长度。
当HashMap中的key超过k个时，需要删除一个key.怎么删除呢？从左往右，遇到一个字母就从哈希表中，他的次数中减去1，直到删除一个字符。
比如: aabcccddee,k=3,遇到d时,a会被删除，遇到e时,b会被删除。
因为每个字符会进一次哈希表，最多出一次哈希表，所以复杂度还是O(n).


 */

/**
 * @author Neo
 *
 */
import java.util.Map;
import java.util.HashMap;

public class longestSubstringAtMost2DistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int len = s.length(), maxLen = 0, start = 0;
		for (int i = 0; i < len; i++){
			if (map.size() == 2 && !map.containsKey(s.charAt(i))){
				// find the left most char and its position
				char leftMostChar = ' ';
				int leftMostCharPos = len;
				for (char key: map.keySet()){
					if (map.get(key) < leftMostCharPos){
						leftMostCharPos = map.get(key);
						leftMostChar = key;
					}
				}
				map.remove(leftMostChar);
				start = leftMostCharPos + 1;
			}
			map.put(s.charAt(i), i);			
			maxLen = Math.max(maxLen, i - start + 1);
			
		}
		return maxLen;
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int len = s.length(), maxLen = 0, start = 0;
		for (int i = 0; i < len; i++){
			char c = s.charAt(i);
			if (map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}
			else{
				map.put(c, 1);
				while (map.size() > k){
					char startChar = s.charAt(start);
					int count = map.get(startChar);
					if (count == 1){
						map.remove(startChar);
					}
					else{
						map.put(startChar, count - 1);
					}
					start++;
				}
			}
			maxLen = Math.max(maxLen, i - start + 1);
		}
		return maxLen;
	}


	public static void main(String[] args) {
		longestSubstringAtMost2DistinctCharacters lsa = new longestSubstringAtMost2DistinctCharacters();
		String s1 = "aabaaccc";
		String s2 = "ababcccddee";
		String s3 = "abcdedeffffff";
		System.out.println(lsa.lengthOfLongestSubstringTwoDistinct(s1));		
		System.out.println(lsa.lengthOfLongestSubstringKDistinct(s2, 3));
		System.out.println(lsa.lengthOfLongestSubstringKDistinct(s3, 3));

	}

}
