/*
 * Created on Aug 15, 2008
 *  
 */
public class StepTwo {
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
		case '#':

			return true;
		default:
			return false;
		}
	}

	public static char plus(char d) {
		int index = (((d % 97) + 1) % 26);
		return alphabet[index];
	}

	public static char minus(char d) {
		int index = (((d % 97) - 1) % 26);
		return alphabet[index];
	}

	public static char reverse(char d) {
		int index = (((d % 97)) % 26);

		return reverse[index];
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
		String line = "c+++++#w+#++++++f--+--k-+--+-++";
		char cin;
		char code = '?';
		char oldCode;
		int moves = 0;
		String decoded = "";
		char d = '?';
		int i = 0;
		code = line.charAt(i);
		while (i < line.length()) {
			i++;
			cin = line.charAt(i);
			if (cin != ' ') {
				d = code;
				while ((isOp(cin)) && (i < line.length())) {
					if (cin == '+') {
						d = plus(d);
						System.out.println(cin);
					} else if (cin == '-') {
						d = minus(d);
						System.out.println(d);
					} else if (cin == '#') {
						d = reverse(d);
						System.out.println(d);
					}
					i++;
					if (i < line.length()) {
						cin = line.charAt(i);

					}
				}
				if (code == ' ') {
					decoded += " ";
				} else {
					decoded += d;
				}
				moves = 0;
				code = cin;
			}
		}

		//		System.out.println();
		System.out.println(line);
		System.out.println(decoded);
	}//main
}