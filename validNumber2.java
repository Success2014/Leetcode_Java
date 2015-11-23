package first;

public class validNumber2 {
	public boolean isNumber(String s) {
        boolean isNum = false;
        int n = s.length();
        if (n == 0) {
            return isNum;
        }
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNum = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNum = true;
            }
        }
        if (i < n && (s.charAt(i) == 'E' || s.charAt(i) == 'e') && isNum) {
            i++;
            isNum = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNum = true;
            }
        }
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        return isNum && i == n;
    }
	
	public static void main(String[] args) {
		validNumber2 vn = new validNumber2();
		String s1 = "+30.75E+2";
		System.out.println(vn.isNumber(s1));
	}

}
