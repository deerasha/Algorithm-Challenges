/*
 * Created on Aug 15, 2008
 *  
 */

import java.io.*;
import java.util.*;

public class FileIO {

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
			System.out.println(code +" with "+ moves+ " becomes "+alphabet[index]);
			return alphabet[index];
		} else {
			moves = moves * -1;
			index = (((code % 97) + moves) % 26);
			System.out.println(code +" the negative "+moves+" becomes " + reverse[index]);
			return alphabet[index];
		}
	}

	public static void main(String[] args) throws IOException,
			FileNotFoundException {

		Scanner fin = new Scanner(new FileReader("in.txt"));
		String line = "";
		char cin;
		char code=' ';
		char oldCode;
		int moves = 0;
		String decoded = "";
		//Input
		while (fin.hasNext()) {
			line = fin.nextLine();
			int i = 0;
			do {
				//			for (int i = 0; i < line.length(); i++) {
				cin = line.charAt(i);
				//				System.out.println(code +": "+ moves);
				if (!(isOp(cin))) {
					if (cin != ' ') {
						//					System.out.print(cin);
						if (i!=0){
						oldCode=code;
						code = cin;
						System.out.println(oldCode + ": " + moves);
						decoded += decode(oldCode, moves);}
						else{
							code =cin;
							decoded+=decode(code, moves);
						}
					} else {
						decoded += " ";
					}

					moves = 0;

					//					
				} else {
					if (cin == '+') {
						moves++;
					} else if (cin == '-') {
						moves--;
					}
				}
				i++;
			} while (i < line.length());
			System.out.println(line);
			//Calculation

		}
		System.out.println(decoded);
		//Output
		PrintWriter fout = new PrintWriter(new FileWriter("out.txt"));

		fin.close();
		fout.close();
	}//main
}//class
