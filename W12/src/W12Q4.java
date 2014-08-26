/* Worksheet 12
 * 
 * Student name: Noreen Lenihan
 * Student ID: 13204807
 * 
 * Question 4
 */



import java.util.HashMap;
import java.util.Map;


public class W12Q4 {
	public static int bruteForceSearch(String T, String P, int offset) {
		int i = offset;
		while (i <= T.length() - P.length()) {
			int j = 0;
			while (j < P.length() && T.charAt(i + j) == P.charAt(j)) {
				j++;
			}
			if (j == P.length())
				return i;
			i++;
		}
		return -1;
	}

	public static int kmpSearch(String text, String pattern, int offset) {
		int[] F = failureFunction(pattern);
		int i = offset;
		int j = 0;
		int comp = 0;
		while (i < text.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				comp++;
				if (j == pattern.length() - 1) {
					//System.out.println("Number of comparsions for KMP: " + comp);
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
		//System.out.println("Number of comparsions for KMP: " + comp);
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
		//System.out.println("Number of comparisons in failure function is: " + comp);
		return F;
	}
	
public static int boyerMooreSearch(String text, String pattern, int offset){
		
		Map<Character, Integer> L = new HashMap();
		for(int i = 0; i < pattern.length(); i++){
			L.put(pattern.charAt(i), i);
		}
		
		//System.out.println(L.entrySet());
		int comp = 0;
		int m = pattern.length();
		int n = text.length();
		int i = (pattern.length() - 1) + offset;
		int j = pattern.length() - 1;
		int l = 0;
		
		do{
			
			if(text.charAt(i) == pattern.charAt(j)){
				comp++;
				if(j == 0){
					//System.out.println("Number of comparisons for BMS: " + comp);
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
		
		//System.out.println("Number of comparisons for BMS: " + comp);
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
		int offsetBrute = 0;
		int offsetKmp = 0;
		int offsetBms = 0;
		int tempBrute = -1;
		int tempBms = -1;
		int tempKmp = -1;
		
		System.out.print("The result of Brute Search: ");
		while(bruteForceSearch("the cat sat on the mat", "the", offsetBrute) != -1){		
			if(bruteForceSearch("the cat sat on the mat", "the", offsetBrute) != tempBrute){
				System.out.print(bruteForceSearch("the cat sat on the mat", "the", offsetBrute) + " ");
			}
			tempBrute = bruteForceSearch("the cat sat on the mat", "the", offsetBrute);
			offsetBrute++;
		}

		System.out.println("\n");
		System.out.print("The result of KMP Search: ");
		while(kmpSearch("the cat sat on the mat", "the", offsetKmp) != -1){
			if(kmpSearch("the cat sat on the mat", "the", offsetKmp) != tempKmp){
				System.out.print(kmpSearch("the cat sat on the mat", "the", offsetKmp) + " ");
			}
			tempKmp = kmpSearch("the cat sat on the mat", "the", offsetKmp);
			offsetKmp++;
		}
		
		System.out.println("\n");
		System.out.print("The result of Boyer Moore Search: ");
		
		while(boyerMooreSearch("the cat sat on the mat", "the", offsetBms) != -1){
			if(boyerMooreSearch("the cat sat on the mat", "the", offsetBms) != tempBms){
				System.out.print(boyerMooreSearch("the cat sat on the mat", "the", offsetBms) + " ");
			}
			tempBms = boyerMooreSearch("the cat sat on the mat", "the", offsetBms);
			offsetBms++;
		}
		
		
		
		
	}

}
