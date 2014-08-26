/* Worksheet 12
 * 
 * Student name: Noreen Lenihan
 * Student ID: 13204807
 * 
 * Question 2
 * */

import java.util.HashMap;
import java.util.Map;


public class W12Q2 {
	public static int bruteForceSearch(String T, String P) {
		int i = 0;
		while (i <= T.length() - P.length()) {
			int j =0;
			while (j < P.length() && T.charAt(i+j) == P.charAt(j)) {
				j++;
			}
			if (j == P.length()) return i;
			i++;
		}
		return -1;
	}
	
	public static int boyerMooreSearch(String text, String pattern){
		
		Map<Character, Integer> L = new HashMap();
		for(int i = 0; i < pattern.length(); i++){
			L.put(pattern.charAt(i), i);
		}
		
		System.out.println(L.entrySet());
		
		int m = pattern.length();
		int n = text.length();
		int i = pattern.length() - 1;
		int j = pattern.length() - 1;
		int l = 0;
		
		do{
			if(text.charAt(i) == pattern.charAt(j)){
				if(j == 0){
					return i;
				}
				else{
					i--;
					j--;
				}
			}
			else{
				l = lastOccurrence(L, text.charAt(i));
				i = i + m - Math.min(j, l+1);
				j = m - 1;
			}
			
		}while(i <= (n-1));
		
		
		return -1;
		
	}
	
	private static int lastOccurrence(Map<Character, Integer> L, char t){
		if(L.containsKey(t)){
			//System.out.println(L.get(t));
			return L.get(t);
		}
		else{
			return -1;
		}
		
	}
	
	public static void main(String args[]) {
		System.out.println(boyerMooreSearch("the theme was their idea", "the"));
		System.out.println(boyerMooreSearch("the theme was their idea", "there"));
		System.out.println(boyerMooreSearch("the theme was their idea", "idea"));
		
		//System.out.println(boyerMooreSearch("aabababacba", "abbab"));
		
	}
	
	
}