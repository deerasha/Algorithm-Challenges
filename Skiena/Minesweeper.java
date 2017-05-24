/*
 * Created on 2007/05/09
 *
 */

/**
 * @author Deerasha Singh
 *  
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.FileReader;
//import java.io.PrintWriter;
//import java.io.FileWriter;

//import java.util.*;
public class Minesweeper {

    private static char[][] field;//stores the indiv elements in the minefield

    public static char Plus(int rPoint, int cPoint) {
        int intBlock;
        String strBlock="*";
        if (field[rPoint][cPoint] != '*'){
            intBlock = Integer.parseInt("" + field[rPoint][cPoint]) + 1;
        	strBlock = "" + intBlock;}

        return strBlock.charAt(0);
    }

    public static void main(String[] args) throws IOException {

       
        String line = "";
        String[] words;
        int rows;
        int cols;

        
//        BufferedReader brin = new BufferedReader(new FileReader(
//                "Minesweeper.dat"));
        
       
        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
        
        
        boolean rMin = false;
        boolean cMin = false;
        boolean rMax = false;
        boolean cMax = false;

//        PrintWriter fout = new PrintWriter(new FileWriter("Minesweeper.out"));
        int fieldnum = 0;

        //Input
        while (!((line = brin.readLine()).equals("0 0"))) {
            words = line.split(" ");
            rows = Integer.parseInt(words[0]);
            cols = Integer.parseInt(words[1]);

            field = new char[rows][cols];
            for (int r = 0; r < rows; r++) {
                line = brin.readLine();
                for (int c = 0; c < cols; c++) {
                    field[r][c] = line.charAt(c);
                }
            }
            fieldnum++;

            //Calculation
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (field[r][c] == '.') {
                        field[r][c] = '0';
                    }
                }
            }//end first calc for-loop

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (field[r][c] == '*') {

                        rMin = (r - 1) > -1;
                        //Integer.parseInt(""+field[r-1][c])>-1;
                        cMin = (c - 1) > -1;
                        //Integer.parseInt(""+field[r][c-1])>-1;
                        rMax = (r + 1) < rows;
                        //Integer.parseInt(""+field[r+1][c])<rows;
                        cMax = (c + 1) < cols;
                        //Integer.parseInt(""+field[r][c+1])<cols;
                    }

                    if (rMin) {
                        if (cMin) {
                            field[r - 1][c - 1] = Plus(r - 1, c - 1);
                        }
                        field[r - 1][c] = Plus(r - 1, c);
                        if (cMax) {
                            field[r - 1][c + 1] = Plus(r - 1, c + 1);
                        }
                    }
                    if (cMin) {
                        field[r][c - 1] = Plus(r, c - 1);
                    }
                    if (cMax) {
                        field[r][c + 1] = Plus(r, c + 1);
                    }
                    if (rMax) {
                        if (cMin) {
                            field[r + 1][c - 1] = Plus(r + 1, c - 1);
                        }
                        field[r + 1][c] = Plus(r + 1, c);
                        if (cMax) {
                            field[r + 1][c + 1] = Plus(r + 1, c + 1);
                        }
                    }
                    rMin = false;
                    cMin = false;
                    rMax = false;
                    cMax = false;

                }

            }//end second calc for-loop

//            //Output
//            fout.println("Field #" + fieldnum + ":");
//            for (int r = 0; r < rows; r++) {
//
//                for (int c = 0; c < cols; c++) {
//                    fout.print(field[r][c]);
//                }
//                fout.println();
//            }
//            fout.println();
//        }
        
        
        //Output
        System.out.println("Field #" + fieldnum + ":");
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
       // brin.close();
       // fout.close();

    }//end main
}//end class
