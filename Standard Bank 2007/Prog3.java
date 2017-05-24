/*
 * Created on Apr 28, 2007
 *
 */

/**
 * We did not come up with a solution on the day. 19|01|2008 Will attempt this
 * problem. 23|05|2008 Still at it. Having problems with the parm sides being
 * parallel with edges- my algo accepted rectangles.
 */

import java.io.*;
import java.util.*;

public class Prog3 {
    static String deny = " are not the vertices of an acceptable figure";

    static int[] row = { 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91,
            105, 120, 136, 153, 171, 190, 210, 231, 253, 276, 300 };

    public static int[] convert(String[] s) {
        int[] i = new int[s.length];
        for (int j = 0; j < i.length; j++) {
            i[j] = Integer.parseInt(s[j]);
        }
        return i;
    }

    public static int inRow(int pt) {
        boolean found = false;
        int j = 1;
        while (!found) {
            if (pt > row[j]) {
                j++;
            } else {
                found = true;
            }
        }
        return j;
    }//inRow

    public static String triangle(int[] pts) {
        int a = pts[0];
        int b = pts[1];
        int c = pts[2];
        int aRow = inRow(a);
        int bRow = inRow(b);
        int cRow = inRow(c);
        int x = -1;//horizontal distance between points on the same line: pt
        // values
        int y = 1;//vertical distance between points on separate lines:
        // inRow(pt) values
        if (aRow == bRow && aRow != cRow) {
            x = Math.abs(a - b);
            y = Math.abs(aRow - cRow);
        } else if (aRow == cRow && aRow != bRow) {
            x = Math.abs(a - c);
            y = Math.abs(aRow - bRow);
        } else if (bRow == cRow && bRow != aRow) {
            x = Math.abs(b - c);
            y = Math.abs(bRow - aRow);
        }
        if (x == y) {
            return " are the vertices of a triangle";
        } else
            return deny;
    }

    public static String parallelogram(int[] pts) {
        int a = pts[0];
        int b = pts[1];
        int c = pts[2];
        int d = pts[3];
        int aRow = inRow(a);
        int bRow = inRow(b);
        int cRow = inRow(c);
        int dRow = inRow(d);
        int x = -1;
        int y = 1;

        return deny;
    }

    public static String hexagon(int[] pts) {
        boolean is = false;
        return deny;
    }

    public static void main(String[] args) throws IOException {

        Scanner fin = new Scanner(new FileReader("Prog3.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter("Prog3.out"));

        String line = "";
        String[] sPoints;

        int[] iPoints;

        line = fin.nextLine();
        while (!(line.equals("#"))) {
            sPoints = line.split(" ");
            if (sPoints.length == 3) {
                iPoints = convert(sPoints);
                fout.println(line + triangle(iPoints));
            } else if (sPoints.length == 4) {
                iPoints = convert(sPoints);
                fout.println(line + parallelogram(iPoints));
            } else if (sPoints.length == 6) {
                iPoints = convert(sPoints);
                fout.println(line + hexagon(iPoints));
            } else {
                fout.println(line + deny);
            }
            line = fin.nextLine();
        }
        fin.close();
        fout.close();
    }//main
}//class
