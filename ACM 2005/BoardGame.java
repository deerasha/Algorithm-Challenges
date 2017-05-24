/*
 * Created on 2007/05/27
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.PrintWriter;
import java.io.FileWriter;

/**
 * There will be a problem with the input in this program for very large M and
 * N- String will not hold them all! Test it on a marker to see the type of
 * error... and then learn how to do input without resorting to such jippos!
 * 
 * ok... using Scanner here for the first time- hope there are no issues!
 * Captain's log: there are issues with scanner: reads null string in after a
 * line. I don't like it!
 * 
 * biggest issue is memory: will the array hold 100 000 numbers? Will the string
 * hold so many characters?
 * 
 * prog is working but need to generate bigger datasets to make sure algo works
 * for big numbers
 * 
 * 17|07|07
 * Looks like I didn't use Scanner after all.
 * 
 */

public class BoardGame {
    public static void main(String[] args) throws IOException {

        BufferedReader brin = new BufferedReader(
                new FileReader("BoardGame.dat"));

        PrintWriter fout = new PrintWriter(new FileWriter("BoardGame.out"));

        String in = "";
        String[] parts;

        int n = 0;
        int m = 0;

        int[] board;
        int[] coinpos;

        int k = 0;
        int moves = 0;
        int blockval = 0;

        //Input
        while (!((in = brin.readLine()).equals("-1 -1"))) {

            //for one board
            //get N and M
            parts = in.split(" ");
            if ((Character.isDigit(parts[0].charAt(0)))) {
                n = Integer.parseInt(parts[0]);
                m = Integer.parseInt(parts[1]);
            }
            //get board values
            board = new int[n];
            in = brin.readLine();
            parts = in.split(" ");
            for (int b = 0; b < n; b++) {
                board[b] = Integer.parseInt(parts[b]);
            }

            //get board positions of coins
            coinpos = new int[m];
            in = brin.readLine();
            parts = in.split(" ");
            for (int c = 0; c < m; c++) {
                coinpos[c] = Integer.parseInt(parts[c]) - 1;
                // -1 because java arrays start at 0 and coinpos is a list of
                // positions on board- why not correct it here?
            }

            //Calculation
            while (k < m) {
                blockval = board[coinpos[k]];
                for (int j = coinpos[k] + 1; j < n; j++) {
                    //+1 to compare block that follows block with coin
                    if (board[j] > blockval) {
                        moves++;
                        blockval = board[j];
                    }

                }
                k++;
            }
            //Output
            fout.println(moves);
            k = 0;
            moves = 0;

            //end for one board

        } //end Input

        brin.close();
        fout.close();

    }
    //end main
}
//end class
