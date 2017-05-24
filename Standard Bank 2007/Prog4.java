/*
 * Created on Apr 28, 2007
 *  
 */
/**
 * This was the solution we came up with on the day. 
 * 15|12|2007 It seems to be working perfectly...
 * 19|01|2008 Consider cleaning up the case statements, and
 * the algorithm in general
 */

import java.io.*;
import java.util.*;

public class Prog4 {
    static int globalmonth = 0;

    static String[] month = {};

    static String[] day = {};

    public static int getmonth(String s) {
        int tempmonth = 0;
        if (s.equals("JANUARY")) {
            tempmonth = 1;
        } else if (s.equals("FEBRUARY")) {
            tempmonth = 2;
        } else if (s.equals("MARCH")) {
            tempmonth = 3;
        } else if (s.equals("APRIL")) {
            tempmonth = 4;
        } else if (s.equals("MAY")) {
            tempmonth = 5;
        } else if (s.equals("JUNE")) {
            tempmonth = 6;
        } else if (s.equals("JULY")) {
            tempmonth = 7;
        } else if (s.equals("AUGUST")) {
            tempmonth = 8;
        } else if (s.equals("SEPTEMBER")) {
            tempmonth = 9;
        } else if (s.equals("OCTOBER")) {
            tempmonth = 10;
        } else if (s.equals("NOVEMBER")) {
            tempmonth = 11;
        } else if (s.equals("DECEMBER")) {
            tempmonth = 12;
        } else {
            tempmonth = -1;
        }
        return tempmonth;
    }

    public static String MakeDay(int day, int month, int year) {
        String tempsplitter[];
        String Easter = normDate("" + year);
        tempsplitter = Easter.split("[ ]");
        int dayeaster = Integer.parseInt(tempsplitter[1]);
        String dayweek = "";
        int dayofweek = 0;
        dayofweek += (day - dayeaster);
        int temp = month - globalmonth;

        switch (temp) {
        case -2:
            dayofweek += 31;
            break;
        case -1: {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                dayofweek += 29;
            } else
                dayofweek += 28;
        }
        case 0:
            break;
        case 1:
            dayofweek += 30;
            break;
        case 2:
            dayofweek += 31;
            break;
        case 3:
            dayofweek += 30;
            break;
        case 4:
            dayofweek += 31;
            break;
        case 5:
            dayofweek += 31;
            break;
        case 6:
            dayofweek += 30;
            break;
        case 7:
            dayofweek += 31;
            break;
        case 8:
            dayofweek += 30;
            break;
        case 9:
            dayofweek += 31;
            break;

        }

        dayofweek = dayofweek % 7;
        switch (dayofweek) {
        case (-7):
            dayweek = "SUNDAY";
            break;
        case (-6):
            dayweek = "MONDAY";
            break;
        case (-5):
            dayweek = "TUESDAY";
            break;
        case (-4):
            dayweek = "WEDNESDAY";
            break;
        case (-3):
            dayweek = "THURSDAY";
            break;
        case (-2):
            dayweek = "FRIDAY";
            break;
        case (-1):
            dayweek = "SATURDAY";
            break;
        case 0:
            dayweek = "SUNDAY";
            break;
        case 1:
            dayweek = "MONDAY";
            break;
        case 2:
            dayweek = "TUESDAY";
            break;
        case 3:
            dayweek = "WEDNESDAY";
            break;
        case 4:
            dayweek = "THURSDAY";
            break;
        case 5:
            dayweek = "FRIDAY";
            break;
        case 6:
            dayweek = "SATURDAY";
            break;
        case 7:
            dayweek = "SUNDAY";
            break;
        default:
            dayweek = "DATE INVALID";
            break;
        }
        return dayweek;
    }

    public static String month(int nmonth) {
        String M = "";
        globalmonth = nmonth;
        switch (nmonth) {
        case 1:
            M = "JANUARY";
            break;
        case 2:
            M = "FEBRUARY";
            break;
        case 3:
            M = "MARCH";
            break;
        case 4:
            M = "APRIL";
            break;
        case 5:
            M = "MAY";
            break;
        case 6:
            M = "JUNE";
            break;
        case 7:
            M = "JULY";
            break;
        case 8:
            M = "AUGUST";
            break;
        case 9:
            M = "SEPTEMBER";
            break;
        case 10:
            M = "OCTOBER";
            break;
        case 11:
            M = "NOVEMBER";
            break;
        case 12:
            M = "DECEMBER";
            break;
        default:
            M = "Error";
        }

        return M;
    }

    public static String normDate(String sd) {
        //sd store normal input date(CAlc easter)

        int x = Integer.parseInt(sd);
        int a = x % 19;
        int c = x % 100;
        int b = x / 100;
        int d = b / 4;
        int e = b % 4;
        double f = ((8 * b) + 13) / 25.0;
        int g = ((11 * (b - d - (int) (Math.ceil(f)))) - 4) / 30;
        int h = ((7 * a) + g + 6) / 11;
        int i = ((19 * a) + (b - d - (int) (Math.ceil(f))) + 15 - h) / 29;
        int j = c / 4;
        int k = c % 4;
        int p = (32 + (2 * e) + (2 * j) - k - i) % 7;
        int m = (90 + (i + p)) / 25;
        int n = (90 + (i + p)) % 25;

        String normdate = month((int) m) + " " + (n + 1);

        return normdate;
    }

    public static void main(String[] args) throws IOException {

        //Input Variables
        String in = "";
        Vector date = new Vector();//stores raw input

        //Calc Variables
        String temp = "";//the String in the Vector date pos
        String temp2 = "";//getting output date from normDate
        String[] drop;
        //Output Variables
        Vector output = new Vector();

        //Init standard Input
        BufferedReader fin = new BufferedReader(
                new InputStreamReader(System.in));
        fin = new BufferedReader(new FileReader("Prog4.dat"));

        //Input
        in = fin.readLine();
        while (!(in.equals("#"))) {
            date.add(in);

            in = fin.readLine();

        }
        //Init for Calc

        //Calc
        for (int j = 0; j < date.size(); j++) {
            temp = "" + date.elementAt(j);
            if (temp.length() == 4) {
                if (Integer.parseInt(temp) <= 1582) {
                    output.add("PRE-GREGORIAN");
                } else
                    output.add(normDate(temp));
            } else {
                drop = temp.split("[.]");
                int year;
                int day;
                int month;
                if (drop[0].length() == 4) {
                    year = Integer.parseInt(drop[0]);
                    month = Integer.parseInt(drop[1]);
                    day = Integer.parseInt(drop[2]);
                    if (((year <= 1752) && (day < 14)) && (month < 9)) {
                        output.add("DATE INVALID");
                    } else {
                        if (MakeDay(day, month, year).equals("DATE INVALID")) {
                            output.add("DATE INVALID");
                        } else
                            output.add("" + day + " " + month(month) + " "
                                    + year + " AD IS "
                                    + MakeDay(day, month, year));
                    }
                } else if (drop[1].length() > 2) {
                    day = Integer.parseInt(drop[0]);
                    month = getmonth(drop[1]);
                    year = Integer.parseInt(drop[2]);
                    if (((year <= 1752) && (day < 14)) && (month < 9)) {
                        output.add("DATE INVALID");
                    } else {
                        if (MakeDay(day, month, year).equals("DATE INVALID")) {
                            output.add("DATE INVALID");
                        } else
                            output.add("" + day + " " + month(month) + " "
                                    + year + " AD IS "
                                    + MakeDay(day, month, year));
                    }
                } else {
                    year = Integer.parseInt(drop[2]);
                    month = Integer.parseInt(drop[1]);
                    day = Integer.parseInt(drop[0]);
                    if (((year <= 1752) && (day < 14)) && (month < 9)) {
                        output.add("DATE INVALID");
                    } else {
                        if (MakeDay(day, month, year).equals("DATE INVALID")) {
                            output.add("DATE INVALID");
                        } else
                            output.add("" + day + " " + month(month) + " "
                                    + year + " AD IS "
                                    + MakeDay(day, month, year));
                    }
                }

            }
        }
        //Output
        PrintWriter fout = new PrintWriter(new FileWriter("Prog4.out"));

        for (int k = 0; k < output.size(); k++) {
            fout.println(output.elementAt(k));
        }
        fout.close();
        fin.close();
        //end Output
    }//end main
}//end class
