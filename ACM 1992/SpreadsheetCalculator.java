
import java.io.*;
import java.util.*;

/*
 * Created on 2008/05/14
 */
/**
 * 23|05|08 This is a graph theory problem. The expressions to be evaluated are
 * interdependent- how do we find the order in which to evaluate?
 */
public class SpreadsheetCalculator {

    static char[] lets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T' };

    static boolean isExp(String toCheck) {
        int n = 0;
        while (n < 20) {
            if (toCheck.charAt(0) == lets[n]) {
                return true;
            } else {
                n++;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        String line = "";
        String[] parts;
        int row = 0;
        int col = 0;
        String[][] input;
        int[][] output = new int[0][0];

        Scanner fin = new Scanner(new FileReader("SpreadsheetCalculator.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter(
                "SpreadsheetCalculator.out"));

        //Input
        while (!(line = fin.nextLine()).equals("0 0")) {
            parts = line.split(" ");
            row = Integer.parseInt(parts[0]);
            col = Integer.parseInt(parts[1]);
            input = new String[row][col];
            output = new int[row][col];
            boolean[][] evaled = new boolean[row][col];

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    input[r][c] = fin.nextLine().trim();
                    //extract given numerical input
                    if (!(isExp(input[r][c]))) {
                        output[r][c] = Integer.parseInt(input[r][c]);
                        evaled[r][c] = true;
                    }
                }
            }

        }

        //console
        for (int c = 0; c < col; c++) {
            System.out.print("\t" + c + " ");
        }
        System.out.println();
        for (int r = 0; r < row; r++) {
            System.out.print(r);
            for (int c = 0; c < col; c++) {
                System.out.print("\t" + output[r][c]);
            }
            System.out.println();
        }
        fin.close();
        fout.close();
    }
}