
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created on Apr 18, 2007
 * 
 */

public class Main {

	public static void main(String args[]) throws IOException {

		boolean debug = false;

		//for Input
		Vector names = new Vector();
		//for Calc
		Vector lengths = new Vector();
		//for Output
		Vector output = new Vector();

		//Init for Input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		//Init for Calculation
		int count = 0;
		int length;
		
		
		//for all input
		do {
			names.clear();
			count = -1;
			
			//for a list ended by #
			do {
				++count;
				names.add(in.readLine());
				
				//debug
				if (debug) {
					System.out.println("names in # loop at pos "+count+":" + names.elementAt(count));
					System.out.println(count);
				}//end debug

			} while (!names.elementAt(count).equals("#"));
			//end for a list ended by #
			
			
			//finding lengths
			for (int i = 0; i < count - 1; i++) {
				String s = "";
				s = (String) (names.elementAt(count));
				lengths.add("" + s.length());

				if (debug) {
					System.out.println("lengths contents at position " + i
							+ ": " + lengths.elementAt(i));
					System.out.println("count: " + count);
					System.out.println("i: " + i);
				}
			}

			int pass = 0;
			int n = lengths.size();

			// counts the number of passes
			boolean swapped;
			do {
				pass++;
				swapped = false;
				// no swaps made
				for (int i = 0; i < (n - pass); i++) {
					if (debug) {
						System.out.println("" + lengths.elementAt(i));
						System.out.println("the integer "
								+ Integer.parseInt("" + lengths.elementAt(i)));
					}
					if (Integer.parseInt("" + lengths.elementAt(i)) > Integer
							.parseInt("" + lengths.elementAt(i + 1))) {
						Object temp = lengths.elementAt(i);
						Object temp2 = names.elementAt(i);
						// exchange values
						if (debug) {
							System.out.println("psodpfo");
						}
						lengths.add(i, lengths.elementAt(i + 1));
						lengths.add(i, temp);
						names.add(i, names.elementAt(i + 1));
						names.add(i, temp);
						swapped = true;
					}
				}
			} while (swapped);

			for (int k = 0; k < names.size(); k++) {
				output.add(names.elementAt(k));

			}
			output.add("#");

			// repeat while not sorted
			if (debug) {
				System.out.println("while" + count);
				for (int k = 0; k < output.size(); k++) {
					System.out.println("" + output.elementAt(k));
				}
			}
		} while (!(names.elementAt(count).toString()).equals("."));//end .
		for (int k = 0; k < output.size(); k++) {
			System.out.println("output at pos " +k+":"+ output.elementAt(k));
		}
	}//end main
}