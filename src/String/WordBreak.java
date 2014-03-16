package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (s == null || "".equals(s)) return result;
        char[] sentence = s.toCharArray();
        
        Boolean[] noResultPositions = new Boolean[s.length()];
        Arrays.fill(noResultPositions, Boolean.FALSE);
        
        wordBreak(sentence, 0, "", dict, result, noResultPositions);
        System.out.println("Result " + result);
        return result;
    }
    
    private boolean wordBreak(char[] chars, int charStart, String newString, Set<String> dict, ArrayList<String> result, Boolean[] noResultPositions) {
        if (noResultPositions[charStart]) {
        	return false;
        }
        boolean hasNoResult = true;
        for (String word: dict) {
        	if (charStart == 0) {
        		System.out.println("charStart " + charStart + " word " + word);
        	}
            if (isStringStartsWithWord(chars, charStart, word)) {
            	int newCharStart = charStart + word.length();
            	if (newCharStart == (chars.length)) {
            		result.add(getNewString(newString, word));
            		hasNoResult = false;
            	} else {
            		boolean hasResult = wordBreak(chars, charStart+word.length(), getNewString(newString, word), dict, result, noResultPositions);
            		if (hasResult) hasNoResult = false;
            	}
            }
        }
        if (hasNoResult) {
        	noResultPositions[charStart] = true;
        }
        return !hasNoResult;
    }
    
    private String getNewString(String s, String word) {
        if ("".equals(s)) {
            return word;
        } else {
            return s + " " + word;
        }
    }
    
    private boolean isStringStartsWithWord(char[] s, int start, String word) {
        int length = s.length - start;
        if (length < word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (s[i+start] != word.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String s = "aaaaaaa";
    	Set<String> dict = new HashSet<String>((Arrays.asList(new String[]{"aaaa","aa","a"})));
    	
//    	String s = "catsanddog";
//    	Set<String> dict = new HashSet<String>((Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
    	
    	WordBreak wb = new WordBreak();
    	ArrayList<String> result = wb.wordBreak(s, dict);
	}
}
