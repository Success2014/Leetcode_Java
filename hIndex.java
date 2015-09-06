package first;

import java.util.Arrays;

public class hIndex {
	/**
	 * idea:
	 * O(n^2)
	 * Count from the total number of papers down to 0.
	 * For each candidate, check if there are enough papers. 
	 * @param citations
	 * @return
	 */
	public int hIndexM(int[] citations) {
        int n = citations.length;
        if (citations == null || n == 0){
            return 0;
        }
        int i;
        for (i = n; i >= 0; i--){
            int count = 0;
            for (int j = 0; j < n; j++){
                if (count >= i){
                    break;
                }
                if (citations[j] >= i){
                    count++;
                }
            }
            
            if (count >= i){
                break;
            }
        }
        return i;
    }
	
	/**
	 * Method 2, O(n) time, O(n) space.
	 * Two-pass.
	 * First use an array to record the number of each number of citations.
	 * Then keep a running sum from the largest back to the smallest. 
	 * @param citations
	 * @return
	 */
	public int hIndexM2(int[] citations) {
        int n = citations.length;
        if (citations == null || n == 0){
            return 0;
        }
        
        int[] count = new int[n+1]; // number of 0,1,2,...n citations
        for (int c: citations){
            if (c > n){
                count[n] += 1;
            }
            else{
                count[c] += 1;
            }
        }
        
        int total = 0;
        for (int i = n; i >= 0; i--){
            total += count[i];
            if (total >= i){
                return i;
            }
        }
        return 0;
    }
	
	/**
	 * O(nlogn) time, O(1) space.
	 * Sort it first. Then from last going back to first.
	 * If current citation is larger than the distance, update h-index as the distance.
	 * @param citations
	 * @return
	 */
	public int hIndex3(int[] citations) {
        int n = citations.length;
        if (n == 0){
            return 0;
        }
        Arrays.sort(citations);
        
        int res = 0;
        for (int i = n - 1; i >= 0; i--){
            if (citations[i] >= n - 1 - i + 1){// (n - 1) - i + 1 is the distance
                res = n - i;
            }
        }
        
        return res;
    }

}
