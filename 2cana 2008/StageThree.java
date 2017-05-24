

/*
 * Created on Aug 15, 2008
 *  
 */
public class StageThree {
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
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
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
		int index = ((d % 97) - 1);
		if(index<0){
			return alphabet[index+26];
		}
		else
		return alphabet[index];
	}

	public static char reverse(char d) {
		int index = (((d % 97)) % 26);

		return reverse[index];
	}

public static char multi(int m, char prev, char d){
	if (prev == '+') {
		for (int i=0; i<m;i++){
		d = plus(d);
		}
		
//		System.out.println(cin);
	} else if (prev == '-') {
		for (int i=0; i<m;i++){
		d = minus(d);
		}
//		System.out.println(d);
	} else if (prev == '#') {
		for (int i=0; i<m;i++){
		d = reverse(d);
		}
//		System.out.println(d);
	}
	return d;
}

	public static void main(String[] args){
		
		
		String line = "v-9+5";
		

		
		char cin;
		char code = '?';
		char oldCode;
		int moves = 0;
		char prev;
		int mult;
		String decoded = "";
		char d = '?';
		int i = 0;
		code = line.charAt(i);
		while (i < line.length()) {
			i++;
			cin = line.charAt(i);
			if (cin != ' ') {
				d = code;
				prev=cin;
				while ((isOp(cin)) && (i < line.length())) {
					if (cin == '+') {
						d = plus(d);
//						System.out.println(d);
					} else if (cin == '-') {
						d = minus(d);
//						System.out.println(d);
					} else if (cin == '#') {
						d = reverse(d);
//						System.out.println(d);
					}
					else{
						mult=Integer.parseInt(""+cin);
//							System.out.println(mult);
							d=multi(mult-1,prev,d);
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
				System.out.print(d);
				moves = 0;
				code = cin;
			}
		}

				System.out.println();
		System.out.println(line);
		System.out.println(decoded);
		
		
	}//main

}