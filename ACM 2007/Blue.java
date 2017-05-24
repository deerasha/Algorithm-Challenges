import java.util.Scanner;
//import java.io.*;

public class Blue {

	public static void main(String[] args) {
		boolean isPalindrome = false;
		boolean isMirrored = false;
		
	
		
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		
		
		
		while (in.hasNext()&&in!=null) {
			isPalindrome = palindrome(line);
			isMirrored = mirrored(line);

			if (isPalindrome && isMirrored) {
				System.out.println("both");
			} else if (isPalindrome) {
				System.out.println("palindrome");
			} else if (isMirrored) {
				System.out.println("mirrored");
			} else {
				System.out.println("neither");
			}

			line = in.nextLine();

		}// end Input

		isPalindrome = palindrome(line);
		isMirrored = mirrored(line);
		if (isPalindrome && isMirrored) {
			System.out.println("both");
		} else if (isPalindrome) {
			System.out.println("palindrome");
		} else if (isMirrored) {
			System.out.println("mirrored");
		} else {
			System.out.println("neither");
		}
		
		
	}

	public static boolean palindrome(String word) {

		int i = 0;
		while (i < (word.length()/2)) {
			if (word.charAt(i) != word.charAt(word.length() - (i + 1))) {
				return false;
			}
			i++;
		}
		return true;

	}

	public static boolean mirrored(String word) {
		char[] left = { 'A', 'E', 'H', 'I', 'J', 'L', 'M', 'O', 'S', 'T', 'U',
				'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '5', '8' };
		char[] right = { 'A', '3', 'H', 'I', 'L', 'J', 'M', 'O', '2', 'T', 'U',
				'V', 'W', 'X', 'Y', '5', '1', 'S', 'E', 'Z', '8' };

		int i = 0;
		while (i < (word.length()/2+1)) {
			char tmp = word.charAt(i);
			int index = -1;
			for (int k = 0; k < left.length; k++) {
				if (tmp == left[k]) {
					index = k;
				}
			}
			if (index == -1)
				return false;
			else {
				
				char r=word.charAt(word.length() - (i + 1));
				if (r!=right[index]) {
					return false;
				}

			}
			i++;
		}

		return true;
	}
}