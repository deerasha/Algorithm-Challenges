/*
 * Created on 2007/04/20
 *  
 */
/**
 * TODO: change to version from OneASupplyBuying because this one is not
 * completely correct!
 */

import java.util.*;

//import java.io.*;
public class Soundex {

	public static void main(String args[]) {
		boolean debug = true;

		Vector cat = new Vector();
		//cat.add("Washingtone");
		//cat.add("Lee");
		//cat.add("Lezzdsfwfft");

		Vector exCat = new Vector();

		//Calc SoundEx
		String step1a = "";//get the first letter
		String step1b = "";//get the significant letters
		String[] drop;//letters to be ignored contained here
		String step2;//assign numbers to letters
		String step3 = "";//ignore duplicates
		String step4 = "";//make code of 4 chars
		String pot = "";
		String exEntry = "";

		/**
		 * TODO: change 0 to counter in Cat loop
		 */
		pot = "" + cat.elementAt(0);

		System.out.println("pot:" + pot);

		//manipulate pot
		//step 1a: retain the first letter
		step1a = "" + pot.charAt(0);
		pot = pot.replaceFirst("" + pot.charAt(0), " ");

		//debug
		if (debug) {
			System.out.println("step1a: " + step1a);
			System.out.println("pot:" + pot);
		}//end debug

		//step 2: assign values to letters places
		step2 = pot;
		step2 = step2.replaceAll("[bfpv]", "1");
		step2 = step2.replaceAll("[cgjkqsxz]", "2");
		step2 = step2.replaceAll("[dt]", "3");
		step2 = step2.replaceAll("l", "4");
		step2 = step2.replaceAll("[mn]", "5");
		step2 = step2.replaceAll("[r]", "6");
		pot = step2;

		//debug
		if (debug) {
			System.out.println("step 2: " + step2);
			System.out.println("pot:" + pot);
		}//end debug

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

		//debug
		if (debug) {
			System.out.println("step3: " + step3);
		}//end debug

		//step1b
		drop = step3.split("[aeiouhwy\\s]");
		for (int x = 0; x < drop.length; x++) {
			step1b += drop[x];
			//debug
			if (debug) {
				System.out.println("drop[" + x + "]: " + drop[x]);
				System.out.println("                 now in step1b: " + step1b);
			}//end debug
		}

		//debug
		if (debug) {
			System.out.println("final step1b: " + step1b);
		}//end debug

		//step 4
		step4 = step1a + step1b;

		if (step4.length() < 4) {
			for (int h = 0; h < 4; h++) {
				if (h < step4.length()) {
					exEntry += step4.charAt(h);
				} else {
					exEntry += '0';
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				exEntry += step4.charAt(i);
			}
		}

		//debug
		if (debug) {
			System.out.println(step4);
		}//end debug

		exCat.add(exEntry);

		//debug
		if (debug) {
			/**
			 * TODO: change 0 to counter variable
			 */
			System.out.println(exCat.elementAt(0));
		}//end debug

	}//end main
}//end class


