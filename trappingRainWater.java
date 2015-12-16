package first;

public class trappingRainWater {
	/**
	 * O(n) time, O(n) space
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMostHigh = new int[n];
        int[] rightMostHigh = new int[n];
        int leftMax = height[0];
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMostHigh[i] = leftMax;
        }
        int rightMax = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightMostHigh[i] = rightMax;
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMostHigh[i], rightMostHigh[i]) - height[i];
        }
        return res;
    }
	
	/**
	 * O(n) time, O(1) space
	 * @param height
	 * @return
	 */
	public int trap2(int[] height) {
		int n = height.length;
        if (n <= 1) {
            return 0;
        }
        int i = 0;
        int j = n - 1;
        int res = 0;
        int toFill = 0;
        while (i < j) {
            toFill = Math.max(toFill, Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                res += toFill - height[i];
                i++;
            } else {
                res += toFill - height[j];
                j--;
            }
        }
        return res;
    }

}
