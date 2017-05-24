
import java.io.*;
import java.util.*;

/*
 * Created on 2007/04/20
 */

public class OneASupplyBuying {

    public static String Soundex(String pot) {

        //Calc SoundEx
        String step1a = "";//get the first letter
        String step1b = "";//get the significant letters
        String[] drop;//letters to be ignored contained here
        String step2;//assign numbers to letters
        String step3 = "";//ignore duplicates
        String step4 = "";//make code of 4 chars
        String exEntry = "";

        //manipulate pot
        //step 1a: retain the first letter
        step1a = "" + pot.charAt(0);

        //if first letter is the same as second letter
        /**
         * TODO: find a better way to do this: use something other than
         * replaceFirst or change structure of if statement
         */
        String c0 = "" + pot.charAt(0);
        String c1 = "" + pot.charAt(1);
        if (c0.equalsIgnoreCase(c1)) {
            pot = pot.replaceFirst(c0, " ");
            pot = pot.replaceFirst(c1, " ");
        } else
            pot = pot.replaceFirst(c0, " ");

        //step 2: assign values to letters places
        step2 = pot;
        step2 = step2.replaceAll("[bBfFpPvV]", "1");
        step2 = step2.replaceAll("[cCgGjJkKqQsSxXzZ]", "2");
        step2 = step2.replaceAll("[dDtT]", "3");
        step2 = step2.replaceAll("[lL]", "4");
        step2 = step2.replaceAll("[mMnN]", "5");
        step2 = step2.replaceAll("[rR]", "6");
        pot = step2;

        //step 3
        //this algo saves the final occurrence of the repeated character in pot
        //to step3
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

        //step1b
        drop = step3.split("[aAeEiIoOuUhHwWyY\\s]");
        for (int x = 0; x < drop.length; x++) {
            step1b += drop[x];
        }

        //step 4
        step4 = step1a + step1b;
        if (step4.length() < 4) {
            for (int h = 0; h < 4; h++) {
                if (h < step4.length()) {
                    exEntry += step4.charAt(h);
                } else {
                    exEntry += "0";
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                exEntry += step4.charAt(i);
            }
        }

        return (exEntry);
    }//end Soundex

    public static void main(String args[]) throws IOException,
            FileNotFoundException {

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
        boolean found;
        //Calc SoundEx Variables
        String exEntry = "";//the entry into the vector

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
         * Note that Calc and Output are done within the input ## loop Output is
         * done with the Calc loop
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

            //input catalogue list: do...while until ended by #
            do {
                in = fin.readLine();//file input
                //guard for do...while
                if (!(in.equals("#")) && !(in.equals("##"))) {
                    ++catcount;

                    cat.add(in);
                }//end guard for do...while

            } while (!(in.equals("#")) && !(in.equals("##")));
            //end input catalogue list: do...while until ended by #

            //input search list: do...while until ended by #
            do {
                if (!(in.equals("##"))) {
                    in = fin.readLine();//file input

                    //guard for do...while
                    if (!(in.equals("#"))) {
                        ++scount;
                        search.add(in);

                    }//end guard for do...while
                }//end if(!(in.equals("##")))
            } while (!(in.equals("#")) && !(in.equals("##")));
            //end input search list: do...while until ended by #

            //Calc
            //Creating Vector exCat
            for (int k = 0; k < cat.size(); k++) {

                //Soundex encoding
                exEntry = Soundex("" + cat.elementAt(k));
                exCat.add(k, exEntry);
                //end Soundex encoding
            }

            //Creating Vector exSearch
            for (int j = 0; j < search.size(); j++) {
                //				debug

                //Soundex encoding
                exEntry = Soundex("" + search.elementAt(j));
                exSearch.add(j, exEntry);
                //end Soundex encoding
            }

            //search through exCat with exSearch element
            for (int j = 0; j < exSearch.size(); j++) {
                found = false;
                //Output
                for (int k = 0; k < exCat.size(); k++) {
                    if ((exSearch.elementAt(j).equals(exCat.elementAt(k)))
                            && !found) {
                        System.out.println("We have the following entries: "
                                + cat.elementAt(k));
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Cannot find any entries for "
                            + search.elementAt(j));
                }
            }
            System.out.println();
            //end Output
            //end search through exCat with exSearch element
            //end Calc
        }//input many lists: while not ended by ## do...
        //end Input and Input debugging
    }//end main
}//end class
