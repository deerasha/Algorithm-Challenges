/*
 * Created on 2007/12/20
 *
 */

/**
 * The first line of input will contain a single integer, N, which is the number
 * of expressions that need to be evaluated. 1 <= N <= 1000.
 * 
 * The next N lines will each contain an arithmetic expression of the form:
 * <NUMBER1><OPERATION><NUMBER2>
 * 
 * where <OPERATION>is one of: plus minus times divided by
 * 
 * and <NUMBER1>and <NUMBER2>are English representations of integers NUM1 and
 * NUM2, such that -999 999 999 <= NUM1, NUM2 <= 999 999 999
 * 
 * 23|12|07 Fully working for the ACM Question(which is quite limited).
 *  
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

public class WordSums {
    static String[] digit = { "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", };

    static String[] teen = { "#", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

    static String[] nty = { "#", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety" };

    public static String toWords(int iNum) {
        String sNum = "";
        int millions;
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
        }
        else if (iNum < 100 && iNum > 19) {
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
        } else if (iNum > 999999) {
            millions = iNum / 1000000;
            sNum += toWords(millions) + "million ";//spaces
            if ((iNum % 1000000) % 1000 == 0) {
                sNum += "and " + toWords(iNum % 1000000);
            } else if (iNum % 1000000 > 0) {
                sNum += toWords(iNum % 1000000);
            }
        }
        return sNum;
    }

    public static int evaluate(int a, int b, String sOp) {
        int iResult = 0;
        if (sOp.equals("plus"))
            iResult = a + b;
        if (sOp.equals("minus"))
            iResult = a - b;
        if (sOp.equals("times"))
            iResult = a * b;
        if (sOp.equals("divided by"))
            iResult = a / b;
        return iResult;
    }

    public static boolean isOp(String token) {
        String[] opWds = { "plus", "times", "divided", "by" };
        int j = 0;
        while (j < opWds.length) {
            if (token.equals(opWds[j])) {
                return true;
            } else {
                j++;
            }
        }
        return false;
    }

    public static boolean isNo(String token) {

        int j = 0;
        while (j < digit.length) {
            if (token.equals(digit[j])) {
                return true;
            } else {
                j++;
            }
        }

        j = 0;
        while (j < teen.length) {
            if (token.equals(teen[j])) {
                return true;
            } else {
                j++;
            }
        }

        j = 0;
        while (j < nty.length) {
            if (token.equals(nty[j])) {
                return true;
            } else {
                j++;
            }
        }

        String[] noWds = { "hundred", "and", "thousand", "million" };
        j = 0;
        while (j < noWds.length) {
            if (token.equals(noWds[j])) {
                return true;
            } else {
                j++;
            }
        }
        return false;
    }

    public static int process(String expression) {

        boolean neg = false;

        String sNum1 = "";
        String sOp = "";
        String sNum2 = "";

        String[] token = expression.split(" ");
        int i = 0;
        if (token[i].equals("minus")) {
            neg = true;
            i++;
        }

        while (isNo(token[i])) {
            sNum1 += token[i] + " ";
            i++;
        }

        int iNum1 = toNumber(sNum1);
        if (neg)
            iNum1 *= (-1);

        while (isOp(token[i])) {
            sOp += token[i] + " ";
            i++;
        }
        if (sOp.length() == 0) {
            sOp = "minus";
            i++;
        }

        neg = false;
        if (token[i].equals("minus")) {
            neg = true;
            i++;
        }
        while ((i < token.length) && isNo(token[i])) {
            sNum2 += token[i] + " ";
            i++;
        }

        int iNum2 = toNumber(sNum2);
        if (neg)
            iNum2 *= (-1);

        return evaluate(iNum1, iNum2, sOp.trim());

    }//end process

    public static int toNumber(String sNumber) {
        int iNum = 0;
        String addFix;
        int millIndex = sNumber.indexOf("million");
        if (millIndex != -1) {
            addFix = sNumber.substring(0, millIndex).trim();
            iNum += 1000000 * toNumber(addFix);
            sNumber = sNumber.substring(millIndex, sNumber.length());

            if (sNumber.length() != 0) {
                int millAndIndex = sNumber.indexOf("million and");
                if (millAndIndex != -1) {
                    addFix = sNumber.substring(
                            millAndIndex + ("million and").length(),
                            sNumber.length()).trim();
                    iNum += toNumber(addFix);
                } else {
                    addFix = sNumber.substring(
                            millAndIndex + ("million").length(),
                            sNumber.length()).trim();
                    iNum += toNumber(addFix);
                }
            }
        }

        if (millIndex == -1) {
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

            if (thouIndex == -1) {
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

                if (hundIndex == -1) {
                    int ntyIndex = -1;
                    int k = 0;
                    boolean numFound = false;
                    while ((!numFound) && (k < nty.length)) {
                        ntyIndex = sNumber.indexOf(nty[k]);
                        if (ntyIndex != -1) {
                            iNum = iNum + (k * 10);
                            sNumber = sNumber.substring(ntyIndex
                                    + nty[k].length(), sNumber.length());
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
        }//end if millIndex
        return iNum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader brin = new BufferedReader(new FileReader("WordSums.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter("WordSums.out"));

        //for Input
        String in = "";

        int lines;
        int j = 0;
        //Input
        in = brin.readLine();
        lines = Integer.parseInt(in);
        while (j < lines) {
            in = brin.readLine();
            //Output //Calculation
            fout.println(toWords(process(in)));
            j++;
        }
        brin.close();
        fout.close();
    }//end main
}//end class
