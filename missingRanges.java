/**
 * Question:
Given a sorted integer array where the range of elements are [0, 99] inclusive, return its
missing ranges.
For example, given [0, 1, 3, 50, 75], return [¡°2¡±, ¡°4->49¡±, ¡°51->74¡±, ¡°76->99¡±]
Example Questions Candidate Might Ask:
Q: What if the given array is empty?
A: Then you should return [¡°0->99¡±] as those ranges are missing.
Q: What if the given array contains all elements from the ranges?
A: Return an empty list, which means no range is missing.

Solution: clean hand book
 * Compare the gap between two neighbor elements and output its range, simple as that
right? This seems deceptively easy, except there are multiple edge cases to consider, such
as the first and last element, which does not have previous and next element respectively.
Also, what happens when the given array is empty? We should output the range ¡°0->99¡±.
As it turns out, if we could add two ¡°artificial¡± elements, ¨C1 before the first element and
100 after the last element, we could avoid all the above pesky cases.
 * @author Neo
 *
 */

import java.util.List;
import java.util.ArrayList;
public class missingRanges {
	public List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> ranges = new ArrayList<String>();
		int prev = start - 1;
		for (int i = 0; i <= vals.length; i++){
			int cur = (i == vals.length) ? end + 1 : vals[i];
			if (cur - prev > 1) {
				ranges.add(getRange(prev + 1, cur - 1));
			}
			prev = cur;
		}
		return ranges;
	}
	
	public String getRange(int from, int to){
		return from == to ? String.valueOf(from) : from + "->" + to;
	}
	
	public static void main (String[] args){
		int[] vals = {0, 1, 3, 4, 10, 15, 20, 21, 22, 80};
		int start = -5, end = 99;
		missingRanges mr = new missingRanges();
		System.out.println(mr.findMissingRanges(vals, start, end));
		
	}

}
