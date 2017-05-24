/*
 * Created on 2007/05/25
 *  
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;

public class PrimeConcern {
    public static void main(String[] args) throws IOException {

        int num;
        int n = 1;
        int isp = 0;
        int maxprime = 0;
        BufferedReader brin = new BufferedReader(new FileReader(
                "PrimeConcern.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter("PrimeConcern.out"));

        String in = "";

        //Input
        in = brin.readLine();
        while (!(in.equals("-1"))) {
            while (!((in = brin.readLine()).equals("0")) && !(in.equals("-1"))) {

                num = Integer.parseInt(in);

                while ((n <= (num / 2)) && (isp < 3)) {
                    if (num % n == 0) {
                        isp++;
                    }
                    n++;
                }
                if ((isp < 3) && (num > maxprime)) {
                    maxprime = num;
                }
                isp = 0;
                n = 1;
 
            }//end 0 while

            //Output
            fout.println(maxprime);

            maxprime = 0;
        }//end -1 while

        brin.close();
        fout.close();

    }//end main
}//end class
