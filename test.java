import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class test {

	public static void main(String[] args) {
		int num = 38;
		System.out.println(num);
		String s = Integer.toString(num);		
		System.out.println(s);
		
		System.out.println(-4 % 2);
		
		int[] nums = new int[5];
		Arrays.fill(nums, Integer.MIN_VALUE);
		System.out.println(Arrays.toString(nums));
		
		String s1 = "hello world you";
		System.out.println(s1.substring(0,2));
		s1 = s1.replace(" ", "");//character cannot be empty, but string can
		System.out.println(s1);
		
		int[] charMap = new int[256];
		System.out.println(charMap['c']);
		
		System.out.println(-4/3);
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.valueOf("345"));
		
		Stack<String> ss = new Stack<String>();
		ss.push("c");ss.push("d");ss.push("e");
		System.out.println(ss);
		
		Queue<String> sss = new LinkedList<String>();
		sss.offer("a");sss.offer("b");sss.offer("c");
		System.out.println(sss);		
		
		List<String> ls = new ArrayList<String>();
		ls.add("hello");ls.add("world");ls.add("go");
		System.out.println(ls);
	

	}

}
