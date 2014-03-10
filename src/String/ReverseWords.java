package String;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] chars = s.toCharArray();
        
        //Step1: Reverse the whole string
        int length = chars.length;
        reverse(chars, 0, length);
        
        //Step2: remove unnecessary spaces
        int lastIndex = removeExtraSpaces(chars);
        
        //Step3: reverse word by word
        reverseWordByWord(chars, lastIndex); 
        
        return new String(chars, 0, lastIndex + 1);
    }
    
    public void reverseWordByWord(char[] chars, int lastIndex) {
    	int wordStart = 0;
        for (int i = 0; i <= lastIndex; i++) {
            if (chars[i] == ' ') {
            	reverse(chars, wordStart, i);
            	wordStart = i + 1;
            } else if (i == lastIndex){
            	reverse(chars, wordStart, lastIndex + 1);
            }
        }
    }
    
    public int removeExtraSpaces(char[] chars) {
    	int a = -1;
        boolean spaceAllowed = false;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] == ' ') {
                if (spaceAllowed && (i + 1 < length) && chars[i+1] != ' ') {
                    chars[++a] = chars[i];
                    spaceAllowed = false;
                }
                continue;
            }
            chars[++a] = chars[i];
            spaceAllowed = true;
        }
        return a;
    }
    
    public void reverse(char[] chars, int a, int b) {
    	if (a >= b) return;
    	for (int j = a; j <= a + (b - 1 - a) / 2; j++) {
        	swap(chars, j, a + b - 1 - j);
        }
    }
    
    public void swap(char[] chars, int x, int y) {
    	char c = chars[x];
    	chars[x] = chars[y];
    	chars[y] = c;
    }
    
    public static void main(String[] args) {
    	ReverseWords rw = new ReverseWords();
		String s = rw.reverseWords("   a   b ");
		System.out.println("Result:" + s + ";");
	}
}
