/*
 * Created on 2008/02/29
 */

import java.io.*;
import java.util.*;

public class green {
    public static boolean noOne(int[] ppl) {
        for (int j = 0; j < ppl.length; j++) {
            if(ppl[j]!=0)
                return false;
        }
        return true;
    }
    public static boolean check(int[] ppl) {
        if (ppl[0] > 0 && ppl[ppl.length - 1] > 0) {
            return false;
        }
        for (int j = 1; j < ppl.length; j++) {
            if (ppl[j - 1] > 0 && ppl[j] > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader fin = new BufferedReader(new FileReader("green.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("green.out"));
        Scanner scan = new Scanner(fin);

        int n;
        int[] ppl;

        boolean done = false;

        while (scan.hasNextLine()) {
            n = scan.nextInt();
            ppl = new int[n];
            for (int i = 0; i < ppl.length; i++) {
                ppl[i] = scan.nextInt();
            }

            while (!done) {

                //handle first's dependency on last
                if ((ppl[ppl.length - 1] > 0)&&(ppl[0]>0)) {
                    ppl[0]--;
                }
                for (int j = 1; j < ppl.length; j++) {
                    if ((ppl[j-1] > 0)&&(ppl[j]>0)) {
                        ppl[j]--;
                    }
                }//for

                done = check(ppl);
            }//while !done
            //OUTPUT
            if(noOne(ppl)){
                fout.println(0);
            }
            else{
            for (int i = 0; i < ppl.length; i++) {
                if (ppl[i] > 0) {
                    fout.print(i+1 + " ");
                }
            }
            fout.println();
            }//OUTPUT
            done = false;
        }//while hasNextLine
        fin.close();
        fout.close();

    }//main
}//class
/*
 * 
 */