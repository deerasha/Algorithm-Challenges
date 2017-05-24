/*
 * Created on Aug 15, 2008
 *  
 */

public class StepOne {
	public static char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };

	public static char[] reverse = { 'z', 'y', 'x', 'w', 'v', 'u', 't', 's',
			'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f',
			'e', 'd', 'c', 'b', 'a' };

	public static boolean isOp(char c) {
		switch (c) {
		case '+':
		case '-':
			return true;
		default:
			return false;
		}
	}

	public static char decode(char code, int moves) {
		int index;
		if (moves >= 0) {
			index = (((code % 97) + moves) % 26);
			
//			System.out.println(code + " with " + moves + " becomes "
//					+ alphabet[index]);
			return alphabet[index];
		} else {
			//			moves = moves * -1;
			index = (((code % 97) + moves) % 26);
//			System.out.println(code + " the negative " + moves + " becomes "
//					+ alphabet[index]);
			return alphabet[index];
		}
	}

	public static void main(String[] args) {
		String line = "c+++++w++++f--+--k-+--+-++ j-m+ s++--+f-b-l+q++";
		char cin;
		char code = '?';
		char oldCode;
		int moves = 0;
		String decoded = "";

		int i = 0;
		code = line.charAt(i);
		while (i < line.length()) {
			i++;
			cin = line.charAt(i);
			if (cin == ' ') {
				decoded += " ";
			} else {
				while ((isOp(cin)) && (i < line.length())) {
					if (cin == '+') {
						moves++;
					} else if (cin == '-') {
						moves--;
					}
					i++;
					if (i < line.length()) {
						cin = line.charAt(i);
					}
				}
				if (code == ' ') {
					decoded += " ";
				} else {
					decoded += decode(code, moves);
				}
				moves = 0;
				code = cin;
			}
		}
		System.out.println(decoded);

		System.out.println();
		System.out.println(line);
		System.out.println(decoded);
	}//main
}//class
