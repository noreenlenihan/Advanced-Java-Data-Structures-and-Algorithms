/**
 * Question 6
 * 
 * @author noreen
 * 
 * */

package Stacks;

public class W4Q6 {

	public static void main(String[] args) {

		String s = "SEQ(PAR(boil, kettle, wash, cup), add teabag, WAIT({kettle, boiled}, add water, add milk)";
		//String s = "(({(({([({{([[[[{}]]]])}})])}))}))"; // test various inputs
		//String s = ""; // test
		char[] c = s.toCharArray();

		System.out.println(ParenMatch(c, s.length()));
	}

	public static boolean ParenMatch(char[] array, int n) {
		ArrayStack S = new ArrayStack();
		boolean isMatch = false;
		boolean hasNoParens = true;

		/** First, check to see if input even has parentheses, i.e. it is worthwhile! */
		for (int j = 0; j < array.length; j++) {
			if (array[j] == '(' || array[j] == '[' || array[j] == '{'
					|| array[j] == ')' || array[j] == '}' || array[j] == ']') {
				hasNoParens = false;
				break;
			}

		}

		if (hasNoParens) {
			System.out.println("Error: Input contains no parentheses");
			return false;
		}

		/** Now, check for matches among parentheses */
		for (int i = 0; i <= n - 1; i++) {
			if (array[i] == '(' || array[i] == '{' || array[i] == '[') {
				S.push(array[i]);
				// System.out.println(S.top());
			} else if ((array[i] == ')' || array[i] == '}' || array[i] == ']')) {
				if (S.isEmpty()) {
					return false;
				}

				else {
					/** Switches are a more comprehensive way to test
					 * parentheses matching rather than a single 'if' statement */
					char temp = (char) S.pop();

					if (temp == '(') {
						switch (array[i]) {
						case (')'):
							isMatch = true;
							break;

						case (']'):
							return false;

						case ('}'):
							return false;
						default:
						}
					}

					if (temp == '{') {
						switch (array[i]) {
						case (')'):
							return false;

						case (']'):
							return false;

						case ('}'):
							isMatch = true;
							break;
						default:
						}
					}

					if (temp == '[') {
						switch (array[i]) {
						case (')'):
							return false;

						case (']'):
							isMatch = true;
							break;

						case ('}'):
							return false;
						default:
						}

					}

				}
			}
		}

		/** If stack had parentheses and is now empty (and has 
		 * passed through all switch statements) then all parentheses 
		 * have successfully been matched*/
		if (S.isEmpty()) {
			return true;
		}

		else {
			return false;
		}

	}

}
