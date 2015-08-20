import java.util.Map;
import java.util.HashMap;

public class twoSumIII {
	private Map<Integer, Integer> table = new HashMap<>();
	
	public void add(int input){
		int count = table.containsKey(input)? table.get(input) : 0;
		table.put(input, count + 1);
	}
	
	public boolean find(int val){
		for (Map.Entry<Integer, Integer> entry: table.entrySet()){
			int num = entry.getKey();
			int y = val - num;
			if (y == num){
				if (entry.getValue() >= 2) return true;
			}
			else if (table.containsKey(y)) return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		twoSumIII ts = new twoSumIII();
		ts.add(1);
		ts.add(3);
		ts.add(4);
		ts.add(6);	
		
		System.out.println(ts.find(12));
		ts.add(6);
		System.out.println(ts.find(12));
	}

}
