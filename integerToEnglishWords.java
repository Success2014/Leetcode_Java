package first;

public class integerToEnglishWords {
	private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
			"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
            "Seventeen", "Eighteen", "Nineteen"};
	private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
			"Eighty", "Ninety"};
	private final String[] thousands = {"", "Thousand", "Million", "Billion"};
	
	
	public String numberToWords(int num) {
		if (num == 0){
			return "Zero";
		}
		String res = "";
		int t = 0;
		while (num != 0){
			int cur = num % 1000;
			if (cur != 0){
				String word = helper(cur);
				res = word + thousands[t] + " " + res;
			}
			num /= 1000;
			t++;
		}
	
		return res.trim();
	}
	
	public String helper(int num){
		String res = "";
		while (num != 0){
			if (num < 20){
				res += lessThan20[num] + " ";
				num = 0;
			}
			else if (num < 100){
				res += tens[num / 10] + " ";
				num %= 10;
			}
			else{
				res += lessThan20[num / 100] + " " + "Hundred" + " ";
				num %= 100;
			}
		}
		return res;
	}
	
	

}
