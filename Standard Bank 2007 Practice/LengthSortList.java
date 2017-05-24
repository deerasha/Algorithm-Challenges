/*
 * Created on 2007/04/19
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.*;

public class LengthSortList {

	public static void main(String args[]) throws IOException,FileNotFoundException {

		boolean debug = true;
		int d1;

		//for Input
		Vector names = new Vector();
		//for Calc
		Vector lengths = new Vector();
		//for Output
		Vector output = new Vector();

		//Init for Input
		BufferedReader fin = new BufferedReader(new
		 InputStreamReader(System.in));
			//BufferedReader fout = FileIO.open("testdata.txt"); //file we read from
		String filename="testdata.txt";
	  	
		try
	  	{
	  		fin = new BufferedReader(new FileReader(filename));
	  	}
	  	catch (FileNotFoundException e)
	  	{
	  		System.err.println();
	  		System.err.println("File " + filename + " does not exist.");
	  		System.err.println();
	  	}//end Init for input
		
		//Init for Calculation
		int count = 0; //count is num of elements not position in vector/array!
		int length;

		String info = "";
		//for all input
		while (!(info.equals("."))) {
			names.clear();
			lengths.clear();
			d1 = -1;

			//input a list: do...while until ended by #
			do {
				info = fin.readLine();//file input
				//debug
				if (debug) {
					System.out.println("info: " + info);
				}//end debug
				if (!(info.equals("#")) && !(info.equals("."))) {
					++count;
					names.add(info);
					//debug
					if (debug) {
						++d1;
						System.out.println("names : " + names.elementAt(d1)
								+ " at pos " + d1);
						System.out.println("count: " + count);
					}//end debug
				}
			} while (!(info.equals("#")) && !(info.equals("."))); 
			//end input a list: do...while until ended by #

			//debug
			if (debug) {
				System.out.println("Final count: " + count
						+ " and contents of Vector names:");
				for (int k = 0; k < names.size(); k++) {
					System.out.println(names.elementAt(k));

				}
			}//end debug
			//end Input and Input debugging

			//Calc
			//finding lengths in unsorted list
			for (int i = 0; i < names.size(); i++) {
				String s = "";
				s = (String) (names.elementAt(i));
				//debug
				if (debug) {
					System.out.println("s: " + s);

				}//end debug

				lengths.add("" + s.length());

				//debug
				if (debug) {
					System.out.println("lengths contents at position " + i
							+ ": " + lengths.elementAt(i));
					//System.out.println("count: " + count);
					System.out.println("i: " + i);
				}//end debug
			}//end finding lengths in unsorted list

			//debug
			if (debug) {
				System.out.println("size of lengths: " + lengths.size()
						+ " and contents of lengths:");
				for (int k = 0; k < lengths.size(); k++) {
					System.out.println(lengths.elementAt(k));
				}
			}//end debug

			//Bubble Sort
			int pass = 0;
			int n = lengths.size();
			//debug
			if (debug) {
				System.out
						.println("-----------------The Bubble Sort-------------");
			}//end debug
			// counts the number of passes
			boolean swapped;
			do {
				pass++;
				swapped = false;
				// no swaps made
				for (int i = 0; i < (n - pass); i++) {
					//debug
					if (debug) {
						System.out.println("At pass " + pass + " and i=" + i
								+ " names contains: ");
						for (int k = 0; k < names.size(); k++) {
							System.out.println(names.elementAt(k) + " at k="
									+ k);
						}
						//System.out.println("Is it displaying integer or
						//location code?> "
						//+ Integer.parseInt("" + lengths.elementAt(i)));
					}//end debug
					if ((Integer.parseInt("" + lengths.elementAt(i))) > (Integer
							.parseInt("" + lengths.elementAt(i + 1)))) {
						//debug
						if (debug) {
							System.out.println("look! " + names.elementAt(i)
									+ " is > than names pos i+1: "
									+ names.elementAt(i + 1));
							System.out.println("performing swap...");
						}//end debug
						//exchange values
						Object potLength = lengths.elementAt(i);
						Object potName = names.elementAt(i);

						lengths.setElementAt(lengths.elementAt(i + 1), i);
						lengths.setElementAt(potLength, i + 1);

						names.setElementAt(names.elementAt(i + 1), i);
						names.setElementAt(potName, i + 1);

						//debug
						if (debug) {
							System.out.println("Afer swap: ");
							System.out.println("names pos i: "
									+ names.elementAt(i));
							System.out.println("names pos i+1: "
									+ names.elementAt(i + 1));
						}//end debug

						swapped = true;
					}
				}
				//debug
				if (debug) {
					if (!(swapped))
						System.out.println("Elements were not swapped on pass "
								+ pass);
				}
				//end debug
			} while (swapped);// repeat while not sorted

			//put sorted names contents in output
			for (int k = 0; k < names.size(); k++) {
				output.add(names.elementAt(k));

			}

			if (!info.equals(".")) {
				output.add("#");
			}

			//debug
			if (debug) {
				System.out.println("output size: " + output.size()
						+ " and output contents: ");
				for (int k = 0; k < output.size(); k++) {
					System.out.println("at pos " + k + ":"
							+ output.elementAt(k));
				}
			}//end debug
		}//end .

		for (int k = 0; k < output.size(); k++) {
			System.out.println(output.elementAt(k));
		}
	}//end main
}//end class

