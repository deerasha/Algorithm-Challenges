/*
 * Created on 2007/04/21
 */

import java.io.*;
import java.util.*;

/*
 * //debug if (debug) { System.out.println(": " + ); }//end debug
 * 
 * //d //\d
 */

public class OneBSupplyBuying {

	public static String Soundex(String pot) {

		boolean debugS = false;

		//Calc SoundEx
		String step1a = "";//get the first letter
		String step1b = "";//get the significant letters
		String[] drop;//letters to be ignored contained here
		String step2;//assign numbers to letters
		String step3 = "";//ignore duplicates
		String step4 = "";//make code of 4 chars
		String exEntry = "";

		//debugS
		if (debugS) {
			System.out.println("pot:" + pot);
		}//end debugS

		//manipulate pot

		//step 1a: retain the first letter
		step1a = "" + pot.charAt(0);

		//if first letter is the same as second letter
		/**
		 * TODO: find a better way to do this: use something other than
		 * replaceFirst or change structure of if
		 */
		String c0 = "" + pot.charAt(0);
		String c1 = "" + pot.charAt(1);
		if (c0.equalsIgnoreCase(c1)) {
			pot = pot.replaceFirst(c0, " ");
			pot = pot.replaceFirst(c1, " ");
		} else
			pot = pot.replaceFirst(c0, " ");

		//debugS
		if (debugS) {
			System.out.println("step1a: " + step1a);
			System.out.println("pot:" + pot);
		}//end debugS

		//step 2: assign values to letters places
		step2 = pot;
		step2 = step2.replaceAll("[bBfFpPvV]", "1");
		step2 = step2.replaceAll("[cCgGjJkKqQsSxXzZ]", "2");
		step2 = step2.replaceAll("[dDtT]", "3");
		step2 = step2.replaceAll("[lL]", "4");
		step2 = step2.replaceAll("[mMnN]", "5");
		step2 = step2.replaceAll("[rR]", "6");
		pot = step2;

		//debugS
		if (debugS) {
			System.out.println("step 2: " + step2);
			System.out.println("pot:" + pot);
		}//end debugS

		//step 3
		//this algo saves the final occurrence of the repeated character in pot
		// to step3
		int p = 0;
		int q = 1;

		step3 += pot.charAt(0);
		while (p < pot.length()) {

			if (!(pot.charAt(p) == pot.charAt(q))) {
				q = p;
				step3 += pot.charAt(q);
			} else {
				p++;
			}
		}//end do...while

		//debugS
		if (debugS) {
			System.out.println("step3: " + step3);
		}//end debugS

		//step1b
		drop = step3.split("[aAeEiIoOuUhHwWyY\\s]");
		for (int x = 0; x < drop.length; x++) {
			step1b += drop[x];
			//debugS
			if (debugS) {
				System.out.println("drop[" + x + "]: " + drop[x]);
				System.out.println("                 now in step1b: " + step1b);
			}//end debugS
		}

		//debugS
		if (debugS) {
			System.out.println("final step1b: " + step1b);
		}//end debugS

		//step 4
		step4 = step1a + step1b;
		//debugS
		if (debugS) {
			System.out.println("step4: " + step4);
		}//end debugS
		if (step4.length() < 4) {
			//debugS
			if (debugS) {
				System.out.println("step4 is less than 4");
			}//end debugS
			for (int h = 0; h < 4; h++) {
				if (h < step4.length()) {
					exEntry += step4.charAt(h);
					//debugS
					if (debugS) {
						System.out.println("exEntry if: " + exEntry);
					}//end debugS
				} else {
					exEntry += "0";
					//debugS
					if (debugS) {
						System.out.println("exEntry else: " + exEntry);
					}//end debugS
				}
			}
		} else {
			//debugS
			if (debugS) {
				System.out.println("step4 is greater than/equal to 4");
			}//end debugS
			for (int i = 0; i < 4; i++) {
				exEntry += step4.charAt(i);
				//debugS
				if (debugS) {
					System.out.println("exEntry: " + exEntry);
				}//end debugS
			}
		}

		//debugS
		if (debugS) {
			System.out.println("final exEntry: " + exEntry);
		}//end debugS

		return (exEntry);
	}//end Soundex

	public static void main(String args[]) throws IOException,
			FileNotFoundException {
		boolean debug = false;
		boolean debugC = true;
		boolean debugO = true;
		int d1 = -1;
		int d2 = -1;

		//Input Variables
		Vector cat = new Vector();//for catalogue
		int catcount = 0;
		Vector search = new Vector();//for customer search
		int scount = 0;
		String in = "";
		//count is num of elements not position in vector/array!

		//Calc Variables
		Vector exCat = new Vector();
		Vector exSearch = new Vector();
		int found=0;
		//Calc SoundEx Variables
		String entry = "";//entry from the input vector
		String exEntry = "";//the entry into the Soundex vector
		String exEntryNon="";//the non-prefixed entry into the Soundex Vector
		String[] preNon;
		int non=0;//position at end of Soundex catalogue to which the non(unprefixed) version of name is added 

		//Output Variables
		Vector output = new Vector();

		//Init for Input
		BufferedReader fin = new BufferedReader(
				new InputStreamReader(System.in));
		String filename = "Customer Search.txt";//add test input filename here

		try {
			fin = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.err.println();
			System.err.println("File " + filename + " does not exist.");
			System.err.println();
		}//end Init for input

		/*
		 * Note that Calc and Output are done within the input ## loop and
		 * Output is done within the Calc loop
		 */

		//Input
		//input many lists: while not ended by ## do...
		while (!(in.equals("##"))) {
			//init Vectors for each record
			cat.clear();
			search.clear();
			//Init for Calculation for each record
			exCat.clear();
			exSearch.clear();
			//debug
			if (debug) {
				d1 = -1;
				d2 = -1;
			}// end debug

			//input catalogue list: do...while until ended by #
			do {
				in = fin.readLine();//file input
				//debug
				if (debug) {
					System.out.println("in: " + in);
				}//end debug
				//guard for do...while
				if (!(in.equals("#")) && !(in.equals("##"))) {
					++catcount;

					cat.add(in);
					//debug
					if (debug) {
						++d1;
						System.out.println("cat " + catcount + ": "
								+ cat.elementAt(d1) + " at pos " + d1);
						System.out.println("catcount: " + catcount);
					}//end debug
				}//end guard for do...while

			} while (!(in.equals("#")) && !(in.equals("##")));
			//end input catalogue list: do...while until ended by #

			//debug
			if (debug) {
				System.out.println("Final catcount: " + catcount
						+ " and contents of Vector cat:");
				for (int k = 0; k < cat.size(); k++) {
					System.out.println(cat.elementAt(k));
				}
			}//end debug

			//input search list: do...while until ended by #
			do {
				if (!(in.equals("##"))) {
					in = fin.readLine();//file input
					//debug
					if (debug) {
						System.out.println("in: " + in);
					}//end debug
					//guard for do...while
					if (!(in.equals("#"))) {
						++scount;
						search.add(in);
						//debug
						if (debug) {
							++d2;
							System.out.println("search : "
									+ search.elementAt(d2) + " at pos " + d2);
							System.out.println("scount: " + scount);
						}//end debug
					}//end guard for do...while
				}//end if(!(in.equals("##")))
			} while (!(in.equals("#")) && !(in.equals("##")));
			//end input search list: do...while until ended by #

			//debug
			if (debug) {
				System.out.println("Final scount: " + scount
						+ " and contents of Vector search:");
				for (int k = 0; k < search.size(); k++) {
					System.out.println(search.elementAt(k));
				}
			}//end debug

			//Calc
			//Creating Vector exCat
			for (int k = 0; k < cat.size(); k++) {
				//debug
				if (debug) {
					System.out.println("cat[" + k + "]: " + cat.elementAt(k));
				}//end debug
				//Soundex encoding
				entry = "" + cat.elementAt(k);
				exEntry = Soundex(entry);
				exCat.add(exEntry);
				if (entry.contains(" ")) {
					preNon = entry.split("[\\s]");
					exCat.add(Soundex(preNon[1]));
				}
				
				//debugC
				if (debugC) {
					System.out.println("exCat: " + exCat);
				}//end debugC
				//end Soundex encoding
			}

			//Creating Vector exSearch
			for (int j = 0; j < search.size(); j++) {
				//Soundex encoding
				entry = "" + search.elementAt(j);
				exEntry = Soundex(entry);
				exSearch.add(exEntry);
				if (entry.contains(" ")) {
					preNon = entry.split("[\\s]");
					exSearch.add(Soundex(preNon[1]));
				}
				//end Soundex encoding
			}
			

			//Search through exCat with exSearch element
			
			
			
			
			for (int j = 0; j < exSearch.size(); j++) {
				found = 0;
				//debugO
				if (debugO) {
					System.out.println("Search for: " + search.lastElement());		
				}//end debugO
				//Output
				for (int k = 0; k < exCat.size(); k++) {
					if ((exSearch.elementAt(j).equals(exCat.elementAt(k)))){
						/**
						 * TODO: fix this! the element at k is not synchronised with the exSearch element index 
						 */
						System.out.println("We have the following entries: "
								+ cat.elementAt(k));
						found++;
					}
				}
				if (found==0) {
					/**
					 * TODO: fix this! the serach element at j is not synchronised with the exSearch element index 
					 */
					System.out.println("Cannot find any entries for "
							+ search.elementAt(j));
				}
			}//end Search
			System.out.println();
			//end Output
			//end search through exCat with exSearch element
			//end Calc
		}//input many lists: while not ended by ## do...
		//end Input and Input debugging
		fin.close();
	}//end main
}//end class

