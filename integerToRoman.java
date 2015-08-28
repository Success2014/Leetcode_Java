package first;

public class integerToRoman {
	public String intToRoman(int num) {
        int[] cand = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        String[] rom = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        String res = new String();
        
        while (num > 0){
            for (int i = cand.length - 1; i >= 0; i--){
                while (num / cand[i] > 0){
                    res += rom[i];
                    num -= cand[i];
                }
            }
        }
        return res;
    }

}
