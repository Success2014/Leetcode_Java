package first;

/**
 * https://leetcode.com/discuss/60830/python-solution-explanation-without-changing-input-array
 * http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
 * @author Neo
 *
 */
public class findTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int num : nums){
                if (num <= mid){
                    count++;
                }
            }
            if (count <= mid){
                low = mid + 1; // must + 1, otherwise [1,2,2] will TLE
            }
            else{
                high = mid;
            }
        }
        return low;
    }
	
	public int findDuplicate2(int[] nums) {
        int slow = nums.length - 1;
        int fast = nums.length - 1;
        while (true){
            slow = nums[slow] - 1;
            fast = nums[nums[fast] - 1] - 1;
            if (slow == fast){
                break;
            }
        }
        
        int find = nums.length - 1;
        while (true){
            slow = nums[slow] - 1;
            find = nums[find] - 1;
            if (slow == find){
                break;
            }
        }
        return slow + 1;
    }

}
