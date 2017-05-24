/*
 * Created on Mar 8, 2008
 */

import java.io.*;
import java.util.*;

public class Prog1a {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Prog1a.dat"));
		PrintWriter fout = new PrintWriter(new FileWriter("Prog1a.out"));
		Scanner fin = new Scanner(br);

		String line = fin.nextLine();
		while (!line.equals("2")) {

		}

		fin.close();
		fout.close();
	}
}
