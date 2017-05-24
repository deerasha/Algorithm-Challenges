/*
 * Created on Apr 28, 2007
 *
 */
/**
 * We did not come up with a solution on the day, but this is a firsties
 * problem!
 */

import java.io.*;
import java.util.*;

public class Prog2 {

    public static void main(String[] args) throws IOException {

        Vector denoms = new Vector();
        Vector amounts = new Vector();
        Vector answers = new Vector();
        String line = "";

        BufferedReader cin = new BufferedReader(new FileReader("Prog2.dat"));
        line = cin.readLine();

        while (!(line.equals("#"))) {

            StringTokenizer t = new StringTokenizer(line, " ");
            while (t.hasMoreElements()) {
                denoms.addElement(t.nextToken());
            }

            line = cin.readLine();

            while (!(line.equals(null)) && !(line.equals("#"))) {
                amounts.add(line);
                line = cin.readLine();
            }

            String ans = "";

            for (int k = 0; k < amounts.size(); k++) {
                for (int i = 0; i < denoms.size(); i++) {
                    int n = 0;
                    int amount = Integer.parseInt("" + amounts.elementAt(k));
                    int div = 0;

                    div = amount / Integer.parseInt("" + denoms.elementAt(i));

                    if (div != 0) {
                        ans += div + "x" + denoms.elementAt(i) + ", ";
                    }

                    amount = amount
                            % Integer.parseInt("" + denoms.elementAt(i));

                }

                ans += "\n";
                String tempans = "";
                if (k != 0) {
                    tempans = answers.elementAt(k - 1) + ans;
                } else
                    tempans = ans;

                answers.add(tempans);

            }
            denoms.clear();
            amounts.clear();

            line = cin.readLine();

        }//end while !"#"
        cin.close();
        PrintWriter fout = new PrintWriter(new FileWriter("Prog2.out"));

        for (int i = 0; i < answers.size(); i++) {
            fout.println(answers.elementAt(i));
        }

        fout.close();

    }//end main
}//end class

