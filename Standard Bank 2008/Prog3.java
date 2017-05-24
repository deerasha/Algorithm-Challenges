/*
 * Created on 2008/03/08
 */
/**
 * Solved: 2008/03/09 11:17AM
 */
import java.io.*;
import java.util.*;

public class Prog3 {

    private static int startTime;//in minutes

    private static int n;//number of teams

    private static char[] teamNames;//A,B,C....

    //for every failed attempt, these Strings record the question failed at
    private static String[] questionsAttempted;

    //  the number of questions successfully answered by each team (running
    // total)
    private static int[] numSolved;

    //total time as calculated for each team(running total)
    private static int[] totalTime;

    public static void swap(int i, char order) {
        int tempSolved;
        int tempTime;
        char tempName;

        if (order == 'h') {
            tempSolved = numSolved[i - 1];
            numSolved[i - 1] = numSolved[i];
            numSolved[i] = tempSolved;

            tempTime = totalTime[i - 1];
            totalTime[i - 1] = totalTime[i];
            totalTime[i] = tempTime;

            tempName = teamNames[i - 1];
            teamNames[i - 1] = teamNames[i];
            teamNames[i] = tempName;
        }

        if (order == 'l') {
            tempSolved = numSolved[i];
            numSolved[i] = numSolved[i - 1];
            numSolved[i - 1] = tempSolved;

            tempTime = totalTime[i];
            totalTime[i] = totalTime[i - 1];
            totalTime[i - 1] = tempTime;

            tempName = teamNames[i];
            teamNames[i] = teamNames[i - 1];
            teamNames[i - 1] = tempName;
        }

    }

    public static void calcTime(int i, String questionNumber, String finalHM) {

        //get final time for this team's question in mins
        String[] hm = finalHM.split(":");
        int finalH = Integer.parseInt(hm[0]);
        int finalM = Integer.parseInt(hm[1]);
        int finalTime = (finalH * 60) + finalM;

        //work out number of penalty minutes for this question
        int penalty = 0;
        String[] fails = questionsAttempted[i].split(",");
        for (int j = 0; j < fails.length; j++) {
            if (fails[j].equals(questionNumber))
                penalty++;
        }

        //calculate final total for this question, add to total for team
        totalTime[i] += (finalTime - startTime) + (penalty * 20);

    }//calcTime
    
    // ******************************MAIN*************************************
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Prog3.dat"));
        PrintWriter fout = new PrintWriter(new FileWriter("Prog3.out"));
        Scanner fin = new Scanner(br);
        String line = "";

        //INPUT
        line = fin.nextLine();
        
        while (!line.equals("##")) {

            String[] hm = line.split(":");//get hours as "xx" and mins as "xx"
            //startTime is saved in mins
            startTime = (Integer.parseInt(hm[0]) * 60)
                    + Integer.parseInt(hm[1]);

            n = Integer.parseInt(fin.nextLine().trim());

            //INITIALISATION: teamNames, questionsAttempted
            teamNames = new char[n];
            questionsAttempted = new String[n];
            numSolved = new int[n];
            totalTime = new int[n];
            for (int k = 0; k < n; k++) {
                teamNames[k] = (char) ('A' + k);
                System.out.println(teamNames[k]);
                questionsAttempted[k] = "";
                numSolved[k] = 0;
                totalTime[k] = 0;
            }

            //INPUT:multiple lines of 4 elements
            String[] element;
            int i;
            while (!line.equals("#") && !(line.equals("##"))) {
                line = fin.nextLine();
                if (!line.equals("#") && !line.equals("##")) {
                    element = line.split("\\s");
                    i = (int) (element[0].charAt(0) - 'A');//typecast to be
                    // safe
                    if (element[3].equals("F")) {
                        //record this failed attempt's questionNumber in the
                        // String for this team
                        questionsAttempted[i] += element[1] + ",";
                    } else {//its a "P"
                        //add to total solved
                        numSolved[i]++;
                        //take team, questionNumber, timeElapsed(for this
                        // question)
                        calcTime(i, element[1], element[2]);
                    }
                }
            } //while !"#" end INPUT for one record

            //Rank the teams for this competition
            int r;
            boolean stillSwapping = true;
            while (stillSwapping) {
                stillSwapping = false;
                r = 1;
                while (r < n) {
                    if (numSolved[r - 1] < numSolved[r]) {
                        stillSwapping = true;
                        swap(r, 'h');
                    } else if ((numSolved[r - 1] == numSolved[r])
                            && (totalTime[r - 1] > totalTime[r])) {
                        stillSwapping = true;
                        swap(r, 'l');
                    } else if (numSolved[r - 1] == numSolved[r]
                            && (totalTime[r - 1] == totalTime[r])
                            && (teamNames[r - 1] > teamNames[r])) {
                        stillSwapping = true;
                        swap(r, 'l');
                    }
                    r++;
                }//while i<n
            }//while stillSwapping

            //OUTPUT for one record
            for (int j = 0; j < n; j++) {
                fout.print(teamNames[j]);
                fout.print(" " + numSolved[j] + " ");
                if(totalTime[j]==0){
                    fout.print("-:--");
                }
                else{
                fout.print(totalTime[j] / 60 + ":");
                if(totalTime[j]%60<10){
                    fout.print("0");
                }
                fout.print(totalTime[j] % 60);}
                fout.println();
            }
            fout.println();
            //end OUTPUT for one record

            //are there more records? take next line to find out
            line = fin.nextLine();
        }//while !"##" end INPUT for whole file

        fin.close();
        fout.close();
    } //main
}
//class

