/*
 * Created on 2007/05/25
 */

/**
 * Rendering Fractal Images [GREEN] "Although it was easy to understand and the
 * solution was the least complex, it involved a lot of code and therefore it
 * took quite some time to complete. You could call it a "mechanical" problem.
 * There was no special algorithm involved - you just needed to follow a set of
 * rules to produce the fractals."
 * 
 * 18|6|7 I forgot that I already set up this problem. It's the second one I'll
 * attempt to solve fully in this batch.
 * 
 * There is an error in the question: Z2 = (1 + 1i)2 + (1 + 1i) = 1 + 3i Note
 * that |Z2| = 3.1623, <-----wrong! It is 2.8284 The -1 gained from i^2 was
 * forgotten in the calculation. The magnitude is sqrt8 not sqrt10.
 * 
 * I take that back. There isn't an error: you're working with magnitudes- so the
 * answer is sqrt10.
 * 
 * Well, its sort of working, but I think my iterations iInc and xInc may be
 * wrong- the image is not magnified correctly. It's either this or my
 * calculation went off somewhere.
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Vector;

class RenderingFractalImages {
    static double magnitude(double r, double i) {
        double magZ = Math.sqrt(Math.pow(r, 2.0) + Math.pow(i, 2.0));
        return magZ;
    }

    static char isMandelbrot(double x, double i) {

        double Zn_Re = x;
        double Zn_Im = i;

        double Znplus1_Re;
        double Znplus1_Im;

        double magZ = magnitude(Zn_Re, Zn_Im);

        int n = 0;

        //for one point's(x,i) sequence to >2.0 or 2047 iterations
        while ((magZ < 2.0) && (n < 2048)) {
            //recursion might work well here? Actually, yes- because this is a
            // subproblem- fully utilising the memory here would be optimising.
            // I think...

            Znplus1_Re = Math.pow(Zn_Re, 2) - Math.pow(Zn_Im, 2) + x;

            Znplus1_Im = (2 * Zn_Re * Zn_Im) + i;

            magZ = magnitude(Znplus1_Re, Znplus1_Im);

            n++;
            Zn_Re = Znplus1_Re;
            Zn_Im = Znplus1_Im;
        }
        if (magZ < 2.0) {
            return ' ';
        } else {
            return '*';
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader brin = new BufferedReader(new FileReader(
                "RenderingFractalImages.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter(
                "RenderingFractalImages.out"));

        String in;
        String[] part;

        int rows;
        int cols;
        int left;
        int top;
        int right;
        int bottom;

        double i;//value on the the Im axis
        double iInc;//the increment of the Im axis- the diff bet testing points
        double x;//value on the Re axis
        double xInc;//the increment of the Re axis- the diff bet testing points
        Vector[][] grid;

        //Input
        in = brin.readLine();
        part = in.split(" ");

        rows = Integer.parseInt(part[0]);
        cols = Integer.parseInt(part[1]);
        left = Integer.parseInt(part[2]);
        top = Integer.parseInt(part[3]);
        right = Integer.parseInt(part[4]);
        bottom = Integer.parseInt(part[5]);

        //Calculation

        //top, bottom->rows->i for Im
        //left,right->cols->x for Re

        xInc = (Math.abs(left - right)) / (cols * 1.0);
        iInc = (Math.abs(top - bottom)) / (rows * 1.0);

        //Output
        //r and c are the locations of the points displayed

        for (int r = 0; r < rows; r++) {
            i = top - (iInc * r);

            for (int c = 0; c < cols; c++) {
                x = left + (xInc * c);
                fout.print(isMandelbrot(x, i));
            }
            fout.println();
        }

        brin.close();
        fout.close();

    }//end main

}//end class
