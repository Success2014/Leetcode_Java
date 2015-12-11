package first;
import java.util.*;
public class theSkylineProblem {
	public List<int[]> getSkyline(int[][] buildings) {        
        List<int[]> res = new ArrayList<int[]>();
        List<int[]> heights = new ArrayList<int[]>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], -b[2]}); // start of a building
            heights.add(new int[]{b[1], b[2]}); // end of a building
        }
        Collections.sort(heights, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
            });
        Queue<Integer> heap = new PriorityQueue<Integer>(11, new Comparator<Integer>(){        	
            public int compare(Integer a, Integer b) {
                return b - a;
            }});
        heap.offer(0);
        int prev =  0;
        for (int[] h: heights) {
            if (h[1] < 0) {
                heap.offer(-h[1]);
            } else {
                heap.remove(h[1]);
            }
            int curt = heap.peek();
            if (curt != prev) {
                res.add(new int[]{h[0], curt});
                prev = curt;
            }
        }
        return res;
    }

}
