
//Given an array of integers, find two numbers such that they add up to a specific target number.
//Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumJ {
	public int[] twoSum(int[] number, int target){
		HashMap<Integer,Integer> match=new HashMap<Integer,Integer>();
		int[] result=new int[2];
		for(int i=0;i<number.length;i++){
			if(match.containsKey(number[i])){
				result[0]=match.get(number[i])+1;
				result[1]=i+1;
				break;
			}else
				match.put(target-number[i],i);
		}
		return result;
	}
	public static void main(String[] args){
		int[] number={2,7,11,15};
		TwoSumJ twosum=new TwoSumJ();
		int[] result=twosum.twoSum(number,9);
		System.out.println(Arrays.toString(result));
	}

}
