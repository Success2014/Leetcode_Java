/**
 * 
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
For example, Given S = ��eceba��, T is "ece" which its length is 3.
˼·��
http://blog.csdn.net/whuwangyi/article/details/42451289
�о����˼·�ȹٷ��Ĵ�˼·�á�

Ҫ������ֶΣ�����ֶ�������2���ַ�����һ��HashMap��¼��ÿ���ַ������ֵ�λ�á���maxLenһֱ��¼��ֶεĳ��ȡ�
start����ǵ�ǰ��ַ�������㡣
��HashMap�е�key����2��ʱ����Ҫɾ��һ��key��ɾ���ĸ��أ�ɾ��������Ǹ�����Ϊ��ϣ����ֻ��2��key�������ҳ�������Ǹ�ֻ��ҪO(1).
�ܵĸ��Ӷ���O(n).

��չ�⣺
ͬ����������ֶΣ�����ֶ�������k���ַ���Ҳ����һ��HashMap����¼��ÿ���ַ����ֵĴ�������maxLenһֱ��¼��ֶεĳ��ȡ�
��HashMap�е�key����k��ʱ����Ҫɾ��һ��key.��ôɾ���أ��������ң�����һ����ĸ�ʹӹ�ϣ���У����Ĵ����м�ȥ1��ֱ��ɾ��һ���ַ���
����: aabcccddee,k=3,����dʱ,a�ᱻɾ��������eʱ,b�ᱻɾ����
��Ϊÿ���ַ����һ�ι�ϣ������һ�ι�ϣ�����Ը��ӶȻ���O(n).


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
