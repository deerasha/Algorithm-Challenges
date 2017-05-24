/*
 * Created on 19 Sep 2008
 */
import java.util.*;
import java.io.*;

public class A {

    static String word = "";
    static String scramble = "";
    static char[] vowels = { 'A', 'E', 'I', 'O', 'U', 'Y'};
    static String[] vowelPairs = { "AI", "AY", "EA", "EE", "EO", "IO", "OA",
            "OO", "OY", "YA", "YO", "YU" };
    static String[] conGroups = { "BL", "BR", "CH", "CK", "CL", "CR", "DR",
            "FL", "FR", "GH", "GL", "GR", "KL", "KR", "KW", "PF", "PL", "PR",
            "SC", "SCH", "SCR", "SH", "SHR", "SK", "SL", "SM", "SN", "SP",
            "SQ", "ST", "SW", "TH", "THR", "TR", "TW", "WH", "WR" };
    static HashSet<String> hCon = new HashSet<String>();
    static HashSet<String> hVow = new HashSet<String>();

    public static boolean isReal() {
        int i = 0;
        if (isVowel(scramble.charAt(0))) {
            while (i < scramble.length()) {

                // word starts with a vowel or vowel pair
                if (isVowel(scramble.charAt(i))) {

                    if (/*(i + 1 < scramble.length())
                            && */(hVow.contains(scramble.substring(i, i + 1)))) {
                        System.out.println(scramble.substring(i, i + 1));
                        i += 2;
                    } else if (i < scramble.length()) {
                        System.out.println("v" + i);
                        i++;
                    }
                } else {
                    return false;
                }
                // next item must be a consonant or conGroup
                if ((i < scramble.length()) && (!isVowel(scramble.charAt(i)))) {
                    if ((i + 2 < scramble.length())
                            && (hCon.contains(scramble.substring(i, i + 2)))) {
                        System.out.println(scramble.substring(i, i + 2));
                        i += 2;
                    } else if ((i + 3 < scramble.length())
                            && (hCon.contains(scramble.substring(i, i + 3)))) {
                        System.out.println(scramble.substring(i, i + 3));
                        i += 3;
                    } else if (i < scramble.length()) {
                        System.out.println("c" + i);
                        i++;
                    }
                } else {
                    return false;
                }
            }// while
        }// if starts with vowel
        else {
            while (i < scramble.length()) {
                //

                // word starts with a consonant or conGroup
                if ((i < scramble.length()) && (!isVowel(scramble.charAt(i)))) {
                    System.out.println("c");
                    if ((i + 2 < scramble.length())
                            && (hCon.contains(scramble.substring(i, i + 2)))) {
                        System.out.println(scramble.substring(i, i + 2));
                        i += 2;
                    } else if ((i + 3 < scramble.length())
                            && (hCon.contains(scramble.substring(i, i + 3)))) {
                        System.out.println(scramble.substring(i, i + 3));
                        i += 3;
                    } else if (i < scramble.length()) {
                        i++;
                    }
                } else {
                    return false;
                }
                // next item must be a vowel or vowel pair
                if ((i < scramble.length()) && (isVowel(scramble.charAt(i)))) {
                    System.out.println("v" + i);
                    if ((i + 1 < scramble.length())
                            && (hVow.contains(scramble.substring(i, i + 1)))) {
                        System.out.println(scramble.substring(i, i + 1));
                        i += 2;
                    } else if (i < scramble.length()) {
                        i++;
                    }
                } else {
                    return false;
                }
            }// while
        }//else starts with consonant
        System.out.println("isReal");
        return true;
    }// isReal

    public static boolean inPlace() {
        for (int i = 0; i < word.length(); i++) {
            if (scramble.charAt(i) == word.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean consecTwo() {
        for (int i = 0; i < (word.length() - 1); i++) {
            if ((scramble.charAt(i) == word.charAt(i))
                    && (scramble.charAt(i + 1) == word.charAt(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVowel(char ch) {
        int i = 0;
        while (i < vowels.length) {
            if (ch == vowels[i]) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException,
            IOException {

        for (int c = 0; c < conGroups.length; c++) {
            hCon.add(conGroups[c]);
        }

        for (int v = 0; v < vowelPairs.length; v++) {
            hVow.add(vowelPairs[v]);
        }

        Scanner fin = new Scanner(new FileReader("A.in"));
        PrintWriter fout = new PrintWriter(new FileWriter("A.out"));

        word = fin.nextLine();
        while (!(word.equals("999"))) {
            scramble = fin.nextLine();
            System.out.println(word +"--->"+scramble);
          
            if (word.equals(scramble)) {
                fout.println("\"" + scramble + "\" is not a scramble of \""
                        + word + "\"");
            } else if (!inPlace() && isReal()) {
                fout.println("\"" + scramble + "\" is a good scramble of \""
                        + word + "\"");
            } else if (((scramble.charAt(0) == word.charAt(0)) || consecTwo())
                    && (!isReal())) {
                fout.println("\"" + scramble + "\" is a poor scramble of \""
                        + word + "\"");
            } else {
                fout.println("\"" + scramble + "\" is a fair scramble of \""
                        + word + "\"");
            }

            word = fin.nextLine();
        }

        fin.close();
        fout.close();
    }// main
}// class
