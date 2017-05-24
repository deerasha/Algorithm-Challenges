/*
 * Created on 2007/12/20
 * Completed on 2008/01/03
 */

/**
 * Note that this is similar to ACM 2005 Problem F, but alot more complicated.
 * number: 999 999 to -999 999 
 * (use ans >= -999 999 and ans <= 999 999 range)-can be expanded
 * TODO:error checking
 * 		remove console output
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Vector;
import java.io.IOException;

public class Code {

    static int i = 0;

    static Vector p;

    static String[] digit = { "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", };

    static String[] teen = { "#", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

    static String[] nty = { "#", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety" };

    public static int evaluate(String line) {
        process(line);
        return add_subtract();
    }

    public static int add_subtract() {
        int result;
        result = divide_multiply();
        while (i < p.size() - 1
                && ((p.elementAt(i).equals("plus")) || (p.elementAt(i)
                        .equals("minus")))) {
            if (p.elementAt(i).toString().equals("plus")) {
                i++;
                result = result + divide_multiply();
                System.out.println("adding...");
            } else if (p.elementAt(i).toString().equals("minus")) {

                i++;
                result = result - divide_multiply();
                System.out.println("subtracting...");
            }
        }
        System.out.println("add_sub returns: " + result);
        return result;
    }

    public static int divide_multiply() {
        int result;
        result = numUnBrac();
        while (i < p.size() - 1
                && ((p.elementAt(i).equals("times") || (p.elementAt(i)
                        .equals("divided by"))))) {
            if (p.elementAt(i).equals("times")) {
                i++;
                result = result * numUnBrac();
                System.out.println("multiplying...");
            } else if (p.elementAt(i).equals("divided by")) {
                i++;
                result = result / numUnBrac();
                System.out.println("dividing...");
            }
        }
        System.out.println("div_mult returns: " + result);
        return result;
    }

    public static int numUnBrac() {
        int result = 0;
        if (Character.isDigit(p.elementAt(i).toString().charAt(0))) {
            System.out.println("numUnBrac returns number: " + p.elementAt(i));
            return (Integer.parseInt(p.elementAt(i++).toString()));
        } else if (p.elementAt(i).equals("bracket")) {
            i++;
            System.out.println("evaluating bracket:");
            result = add_subtract();
            i++;
            if (i < p.size() - 1
                    && p.elementAt(i).toString().equals("endbracket")) {
                i++;
                return add_subtract();
            } else {
                return result;
            }
        } else if (isUn(p.elementAt(i).toString())) {
            while (i < p.size() - 1 && (isUn(p.elementAt(i).toString()))) {
                if (p.elementAt(i).equals("minus")) {
                    i++;
                    result = -1 * numUnBrac();
                    System.out.println("negating...");
                } else if (p.elementAt(i).equals("square root of")) {
                    i++;
                    result = (int) Math.sqrt((double) numUnBrac());
                    System.out.println("rooting...");
                } else if (p.elementAt(i).equals("absolute of")) {
                    i++;
                    result = Math.abs(numUnBrac());
                    System.out.println("absoluting...");
                }
            }
            return result;
        } else {
            System.err.println("Unexpected symbol");
            return 0;
        }
    }

    public static void process(String line) {
        String[] words = line.split(" ");
        Vector tokens = new Vector();
        int j = 0;
        String collect = "";
        while (j < words.length) {
            while (j < words.length && isNum(words[j])) {
                collect += words[j] + " ";
                j++;
            }
            if (collect.length() != 0) {
                tokens.addElement(new Integer(toNumber(collect)));
                collect = "";
            } else if (words[j].equals("divided")
                    || words[j].equals("absolute")) {
                tokens.addElement(words[j] + " " + words[j + 1]);
                j += 2;
            } else if (words[j].equals("square")) {
                tokens.addElement(words[j] + " " + words[j + 1] + " "
                        + words[j + 2]);
                j += 3;
            } else {
                tokens.addElement(words[j]);
                j++;
            }
        }
        p = tokens;
    }

    public static boolean classify(String token, String[] type) {
        int j = 0;
        while (j < type.length) {
            if (token.equals(type[j])) {
                return true;
            } else {
                j++;
            }
        }
        return false;
    }

    public static boolean isUn(String token) {
        String[] unary = { "minus", "square root of", "absolute of" };
        if (classify(token, unary))
            return true;
        else
            return false;
    }

    public static boolean isNum(String token) {

        String[] other = { "hundred", "and", "thousand" };
        if (classify(token, digit)) {
            return true;
        } else if (classify(token, teen)) {
            return true;
        } else if (classify(token, nty)) {
            return true;
        } else if (classify(token, other)) {
            return true;
        }
        return false;
    }

    public static int toNumber(String sNumber) {
        int iNum = 0;

        String addFix;

        int thouIndex = sNumber.indexOf("thousand");

        if (thouIndex != -1) {
            addFix = sNumber.substring(0, thouIndex).trim();
            iNum += 1000 * toNumber(addFix);
            sNumber = sNumber.substring(thouIndex, sNumber.length());

            if (sNumber.length() != 0) {
                int thouAndIndex = sNumber.indexOf("thousand and");

                if (thouAndIndex != -1) {
                    addFix = sNumber.substring(
                            thouAndIndex + ("thousand and").length(),
                            sNumber.length()).trim();

                    iNum += toNumber(addFix);
                } else {
                    addFix = sNumber.substring(
                            thouAndIndex + ("thousand").length(),
                            sNumber.length()).trim();

                    iNum += toNumber(addFix);
                }
            }
        }

        else {
            int hundIndex = sNumber.indexOf("hundred");

            if (hundIndex != -1) {
                addFix = sNumber.substring(0, hundIndex).trim();
                iNum += 100 * toNumber(addFix);

                int hundAndIndex = sNumber.indexOf("hundred and");

                if (hundAndIndex != -1) {
                    addFix = sNumber.substring(
                            hundAndIndex + ("hundred and").length(),
                            sNumber.length()).trim();

                    iNum += toNumber(addFix);
                }
            }

            else {

                int ntyIndex = -1;
                int k = 0;
                boolean numFound = false;
                while ((!numFound) && (k < nty.length)) {
                    ntyIndex = sNumber.indexOf(nty[k]);
                    if (ntyIndex != -1) {
                        iNum = iNum + (k * 10);
                        sNumber = sNumber.substring(ntyIndex + nty[k].length(),
                                sNumber.length());
                        numFound = true;
                    } else {
                        k++;
                    }
                }

                int teenIndex = -1;
                numFound = false;
                k = 0;
                while ((!numFound) && (k < teen.length)) {
                    teenIndex = sNumber.indexOf(teen[k]);
                    if (teenIndex != -1) {
                        iNum += k + 10;
                        numFound = true;
                    } else {
                        k++;
                    }
                }

                if (teenIndex == -1) {
                    int digIndex;

                    numFound = false;
                    k = 0;
                    while (!numFound && k < digit.length) {
                        digIndex = sNumber.indexOf(digit[k]);
                        if (digIndex != -1) {
                            iNum += k;
                            numFound = true;
                        } else {
                            k++;
                        }
                    }
                }//end if teenIndex
            }//end if hundIndex
        }//end if thouIndex

        return iNum;
    }

    public static String toWords(int iNum) {
        String sNum = "";
        int thousands;
        int hundreds;
        int iNty;
        if (iNum < 0) {
            sNum += "minus ";
            iNum = iNum * -1;
        }
        if (iNum < 10) {
            sNum += digit[iNum] + " ";
        } else if (iNum == 10) {
            sNum += "ten ";
        } else if (iNum < 20 && iNum > 10) {
            sNum += teen[iNum % 10] + " ";
        } else if (iNum < 100 && iNum > 19) {
            iNty = iNum / 10;
            sNum += nty[iNty] + " ";
            if (iNum % 10 > 0) {
                sNum += toWords(iNum % 10);
            }
        } else if (iNum > 99 && iNum < 1000) {
            hundreds = iNum / 100;
            sNum += toWords(hundreds) + "hundred ";
            if (iNum % 100 > 0) {
                sNum += "and " + toWords(iNum % 100);
            }
        } else if (iNum > 999 && iNum < 1000000) {
            thousands = iNum / 1000;
            sNum += toWords(thousands) + "thousand ";//spaces
            if (iNum % 1000 > 99) {
                sNum += toWords(iNum % 1000);
            } else if (iNum % 1000 > 0) {
                sNum += "and " + toWords(iNum % 1000);
            }
        }
        return sNum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("in.txt"));
        PrintWriter out2 = new PrintWriter(new FileWriter("out2.txt"));
        PrintWriter out1 = new PrintWriter(new FileWriter("out1.txt"));
        //Input
        String line = "";
        int num;
        line = in.readLine();
        while (!(line.equals("-1"))) {
            num = evaluate(line);
            out2.println(num);
            out1.println(toWords(num));
            p = null;
            i = 0;
            line = in.readLine();
        }
        in.close();
        out2.close();
        out1.close();
    }//end main
}//end class
