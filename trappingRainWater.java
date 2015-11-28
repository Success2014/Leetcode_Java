package first;

public class trappingRainWater {
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

}
