package first;

public class containerWithMostWater {
	public int maxArea(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int i = 0;
        int j = n - 1;
        int max = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, height[i] * (j - i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }
        return max;
    }
}
