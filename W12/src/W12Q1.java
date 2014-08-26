/* Worksheet 12
 * 
 * Student name: Noreen Lenihan
 * Student ID: 13204807
 * 
 * Question 1
 * */


import java.util.Arrays;


public class W12Q1 {
	public static int bruteForceSearch(String T, String P) {
		int i = 0;
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

	public static int kmpSearch(String text, String pattern) {
		int[] F = failureFunction(pattern);
		int i = 0;
		int j = 0;

		while (i < text.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
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
		//System.out.println(Arrays.toString(F));
		return F;
	}


	public static void main(String args[]) {
		System.out.println(kmpSearch("the theme was their idea", "the"));
		System.out.println(kmpSearch("the theme was their idea", "there"));
		System.out.println(kmpSearch("the theme was their idea", "idea"));
		
	}

}
