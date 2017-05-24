
import java.io.*;
import java.util.*;

/*
 * Created on 2007/10/21
 */

public class Red {
    public static void main(String[] args) throws IOException {

        BufferedReader brin = new BufferedReader(new FileReader("anagrams.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("anagrams.out"));

        String in = "";
        Vector dictionary = new Vector();
        Vector targets = new Vector();
        Vector anagrams = new Vector();

        //Input
        in = brin.readLine();
        while (!(in.equals("-1"))) {
            dictionary.addElement(in);
            in = brin.readLine();

        }
        in = brin.readLine();
        while (!(in.equals("-2"))) {
            targets.addElement(in);
            in = brin.readLine();

        }

        
        for (int a = 0; a < targets.size(); a++) {
            //for each target word
            HashMap tword = new HashMap();
            String aTarget = targets.elementAt(a) + "";
            for (int b = 0; b < aTarget.length(); b++)
                if (tword.containsKey(aTarget.charAt(b) + "")) {
                    Integer j = (Integer) tword.get(aTarget.charAt(b) + "");
                    Integer k = new Integer(j.intValue() + 1);
                    tword.put(aTarget.charAt(b) + "", k);
                } else {
                    tword.put(aTarget.charAt(b) + "", new Integer(1));
                }
            
            
            
            
            
            
            
        }

    }

    public static String[] order(Vector anagrams) {
        String[] anagramsA = new String[anagrams.size()];
        for (int k = 0; k < anagrams.size(); k++) {
            anagramsA[k] = anagrams.elementAt(k) + "";
        }

        for (int i = 0; i < anagramsA.length; i++) {
            for (int j = i; j < anagramsA.length; j++) {
                if (anagramsA[i].compareToIgnoreCase(anagramsA[j]) > 0) {
                    String temp = anagramsA[i];
                    anagramsA[i] = anagramsA[j];
                    anagramsA[j] = temp;
                }

            }

        }
        return anagramsA;
    }
}