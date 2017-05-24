/*
 * Created on Mar 8, 2008
 */

import java.io.*;
import java.util.*;

public class Prog4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Prog4.dat"));
		PrintWriter fout = new PrintWriter(new FileWriter("Prog4.out"));
		Scanner fin = new Scanner(br);

		String line = fin.nextLine();
		while (!line.equals("2")) {

		}

		fin.close();
		fout.close();
	}
}
