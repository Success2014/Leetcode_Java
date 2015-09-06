package first;

public class hIndexII {
	public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0){
            return 0;
        }
        int start = 0;
        int end = n - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (citations[mid] == n - 1 - mid + 1){
                end = mid;
            }
            else if (citations[mid] < n - 1 - mid + 1){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        // find first position of citations[i] >= n - i
        if (citations[start] >= n - start){
            return n - start;
        }
        else if(citations[end] >= n - end){
            return n - end;
        }
        else{
            return 0;
        }
    }

}
