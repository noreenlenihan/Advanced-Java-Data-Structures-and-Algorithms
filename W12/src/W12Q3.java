/* Worksheet 12
 * 
 * Student name: Noreen Lenihan
 * Student ID: 13204807
 * 
 * Question 3
 * 
 * ANSWERS:
 * 
 * For the first test, finding the pattern "the" in the
 * text string "the theme was their idea" took an equal number of
 * comparisons (3) in each pattern-matching algorithm. No difference
 * in number of comparisons between algorithms.
 * 
 * For the second test, finding the pattern "there" in the
 * text string "the theme was their idea" was achieved with the
 * least amount of comparisons in the Boyer-Moore Search algorithm (7).
 * 
 * For the final test, finding the pattern "idea" in the string
 * "the theme was their idea", had the least amount of comparisons with
 * the Boyer-Moore Search algorithm (no. of comparisons: 11).
 * 
 * */


import java.util.HashMap;
import java.util.Map;


public class W12Q3 {
	public static int bruteForceSearch(String T, String P) {
		int i = 0;
		int comp = 0;
		while (i <= T.length() - P.length()) {
			int j = 0;
			while (j < P.length() && T.charAt(i + j) == P.charAt(j)) {
				comp++;
				j++;
			}
			if (j == P.length()){
				System.out.println("Number of comparisons for Brute force: " + comp);
				return i;
			}
			comp++;
			i++;
			
		}
		System.out.println("Number of comparisons for Brute force: " + comp);
		return -1;
	}

	public static int kmpSearch(String text, String pattern) {
		int[] F = failureFunction(pattern);
		int i = 0;
		int j = 0;
		int comp = 0;
		while (i < text.length()) {
			comp++;
			if (text.charAt(i) == pattern.charAt(j)) {
				
				if (j == pattern.length() - 1) {
					System.out.println("Number of comparsions for KMP: " + comp);
					return i - j;
				} else {
					i++;
					j++;
				}
			} else {
				
				if (j > 0) {
					j = F[j - 1];
				} else {
					i++;
				}
			}
		}
		System.out.println("Number of comparsions for KMP: " + comp);
		return -1;
	}

	private static int[] failureFunction(String P) {
		int[] F = new int[P.length()];
		int i = 1;
		int j = 0;
		
		while (i < P.length()) {
			
			if (P.charAt(i) == P.charAt(j)) {
				
				F[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				
				j = F[j - 1];
			} else {
				F[i] = 0;
				i++;
			}
		}
		
		return F;
	}
	
public static int boyerMooreSearch(String text, String pattern){
		
		Map<Character, Integer> L = new HashMap();
		for(int i = 0; i < pattern.length(); i++){
			L.put(pattern.charAt(i), i);
		}
		
		System.out.println(L.entrySet());
		int comp = 0;
		int m = pattern.length();
		int n = text.length();
		int i = pattern.length() - 1;
		int j = pattern.length() - 1;
		int l = 0;
		
		do{
			comp++;
			if(text.charAt(i) == pattern.charAt(j)){
				
				if(j == 0){
					System.out.println("Number of comparisons for BMS: " + comp);
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
		
		System.out.println("Number of comparisons for BMS: " + comp);
		return -1;
		
	}
	
	private static int lastOccurrence(Map<Character, Integer> L, char t){
		if(L.containsKey(t)){
			//System.out.println(L.get(t));
			return (int)L.get(t);
		}
		else{
			return -1;
		}
		
	}


	public static void main(String args[]) {
		System.out.println("Found substring at: " + bruteForceSearch("the theme was their idea", "the"));
		System.out.println("Found substring at: " + kmpSearch("the theme was their idea", "the"));
		System.out.println("Found substring at: " + boyerMooreSearch("the theme was their idea", "the"));
		System.out.println("****************************************");
		System.out.println("Found substring at: " + bruteForceSearch("the theme was their idea", "there"));
		System.out.println("Found substring at: " + kmpSearch("the theme was their idea", "there"));
		System.out.println("Found substring at: " + boyerMooreSearch("the theme was their idea", "there"));
		System.out.println("****************************************");
		System.out.println("Found substring at: " + bruteForceSearch("the theme was their idea", "idea"));
		System.out.println("Found substring at: " + kmpSearch("the theme was their idea", "idea"));
		System.out.println("Found substring at: " + boyerMooreSearch("the theme was their idea", "idea"));
		System.out.println("****************************************");
		//System.out.println(bruteForceSearch("the cat sat on the mat", "the"));
		
	}
}