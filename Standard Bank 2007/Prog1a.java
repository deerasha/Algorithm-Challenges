
import java.io.*;
import java.util.*;

/*
 * Created on 2008/01/19
 */
/**
 * STANDARD BROADLOOM CARPETS
 * 
 *  
 */

public class Prog1a {
    static int[] stock = new int[100];

    static int[] rollEnds = new int[100];

    static int day = 0;
//array ordersMet
    //ordersOutstanding
//    public static void sort()
    public static void cutCall(int rollToday, String callers) {
        String[] calls = callers.split(" ");
        int[] cut = new int[calls.length];
        for (int j = 0; j < calls.length; j++) {
            cut[j] = Integer.parseInt(calls[j]);
        }
        int i = 0;

        while (i < cut.length) {
            if (rollToday >= cut[i]) {
                rollToday = rollToday - cut[i];
                System.out.println("cutting " + cut[i] + " and left "
                        + rollToday);
            }
            i++;
        }

        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        Scanner fin = new Scanner(new FileReader("Prog1a.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter("Prog1a.out"));

        //INPUT VARIABLES
        String[] line;
        String sn;
        String callers;
        String post;

        int n;

        do {
            line = fin.nextLine().split(" ");
            sn = line[2];
            //System.out.println(sn);
            n = Integer.parseInt(sn);
            line = fin.nextLine().split("CALLERS ");
            callers = line[1];
            //                System.out.println(callers);
            line = fin.nextLine().split("BY POST ");
            post = line[1];
            //                System.out.println(post);
            cutCall(n, callers);

            fin.nextLine();

        } while (fin.hasNext());

        fin.close();
        fout.close();
    }//main
}//class
