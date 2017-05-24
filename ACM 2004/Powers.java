/*
 * Created on 2007/05/24
 */
/**
 * "The first problem we solve was the Powers [WHITE] problem. We solved it very
 * quickly after Harry realised using logarithms was a very quick and short
 * solution."
 * 
 * This is a Math problem: how do we find the first digit of a really big
 * number? The biggest number in this prob is 9^1000000. That is very big. We
 * only want the first digit of these really big nums!
 * 
 * When 1337s say logs they mean use ln e in a nifty algo. What is this nifty
 * algo? This is an Aha! question- know the trick and you get it right. Would
 * going through old IMO questions help in coding comps? Looks like it. I
 * don't like this... its all about "clever" math yet again!
 * 
 * 12|6|7 Contacted Gallotta- he explained the niftyness(it does not use ln/e
 * but rather log10) Unfortunately I can't recall the full message from Facebook
 * and have run out of airtime so I can't check the details, because it doesn't
 * seem to working quite well... Eclipse is also misbehaving!
 * 
 * 18|6|7 I may have a breakthrough! I finally understand what he's talking
 * about! Yay!
 * Yep the program works B*E*A*U*T*I*F*U*L*L*Y
 *  
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Powers {
    public static void main(String[] args) throws IOException {

        double b = 0;
        double n = 0;

        double p;
        double logBtoN;
        double mantissaLog;
        double digitBtoN;
        String snum;

        String line = "";
        String[] parts;

        BufferedReader brin = new BufferedReader(new FileReader("Powers.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter("Powers.out"));
        //Input
        while (!(line = brin.readLine()).equals("0 0")) {
            //Calculation
            parts = line.split(" ");
            b = Double.parseDouble(parts[0]);
            n = Double.parseDouble(parts[1]);

            logBtoN = n * Math.log10(b);

            mantissaLog = logBtoN - ((int) logBtoN);

            digitBtoN = Math.pow(10, mantissaLog);

            //Output
            fout.println((int) digitBtoN);

        }
        brin.close();
        fout.close();

    }//end main
}//end class
