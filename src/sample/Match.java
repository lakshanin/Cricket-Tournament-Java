package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Match {

    private static ArrayList<String> fTeamNames  = new ArrayList<>();
    private static ArrayList<Integer> fTeamCaps = new ArrayList<>();
    private static ArrayList<Integer> fTeamRuns = new ArrayList<>();
    private static ArrayList<Integer> fTeamWickets = new ArrayList<>();

    private static ArrayList<String> sTeamNames  = new ArrayList<>();
    private static ArrayList<Integer> sTeamCaps = new ArrayList<>();
    private static ArrayList<Integer> sTeamRuns = new ArrayList<>();
    private static ArrayList<Integer> sTeamWickets = new ArrayList<>();

    private static HashMap highestWickets = new HashMap();
    private static HashMap highestRuns = new HashMap();

    public static int Match(String battingTeamName, Team battingTeam, String bowlingTeamName, Team bowlingTeam, int pScore, int inning) throws InterruptedException {

        int bowlingIndex = 0;
        String bowler = bowlingTeam.getName().get(bowlingIndex);
        int bowlerWickets = 0;
        int battingIndex = 0;
        String batsman = battingTeam.getName().get(battingIndex);
        if (inning==1){
            fTeamCaps.add(battingTeam.getCap().get(battingIndex));
            fTeamNames.add(batsman);
        }
        else{
            sTeamCaps.add(battingTeam.getCap().get(battingIndex));
            sTeamNames.add(batsman);
        }
        int batsmanScore = 0;
        int bOvers = 0;
        int tScore = 0;
        int tWickets = 0;
        int tOvers = 20;
        int tBalls = 120;

        System.out.println("   Team " + battingTeamName + " is batting");
        System.out.println(batsman + " is batting");
        System.out.println("");
        System.out.println("   Team " + bowlingTeamName + " is bowling");
        System.out.println(bowler + " is bowling");
        System.out.println("");

        for(int i = 1; i <tBalls; i++){
            if (pScore>=tScore){
                if (tOvers>0 && tWickets<10){
                    int min = 1, max = 7;
                    int x = (int) (Math.random() * (max - min + 1) + min); // getting random number to get score
                    if (x==6){
                        batsmanScore +=6;
                        tScore +=6;
                        System.out.println("It's a Six!");
                        System.out.println(batsman+" earned 6 points");
                    }
                    else if (x==4){
                        batsmanScore +=4;
                        tScore +=4;
                        System.out.println("It's a Four!");
                        System.out.println(batsman+" earned 4 points");
                    }
                    else if (x==7) {
                        tWickets +=1;
                        bowlerWickets +=1;
                        max = 2;
                        int y = (int) (Math.random() * (max - min + 1) + min);
                        if (y==1)
                            System.out.println("It's a Catch!");
                        else System.out.println("It's a Run-Out!");
                        if (inning ==1)                             //batsman score assigning
                            fTeamRuns.add(batsmanScore);
                        else sTeamRuns.add(batsmanScore);
                        highestRuns.put(batsman, batsmanScore);
                        System.out.println(batsman+" out with "+batsmanScore+" points");
                        batsmanScore = 0;
                        battingIndex +=1;
                        try {
                            batsman = battingTeam.getName().get(battingIndex);
                            System.out.println("");
                            System.out.println(batsman + " is batting now");
                        }
                        catch (Exception ignored){}
                        if (inning==1){
                            fTeamCaps.add(battingTeam.getCap().get(battingIndex));
                            fTeamNames.add(batsman);
                        }
                        else{
                            sTeamCaps.add(battingTeam.getCap().get(battingIndex));
                            sTeamNames.add(batsman);
                        }
                    }
                    else {
                        batsmanScore +=x;
                        tScore +=x;
                        System.out.println(batsman+" earned "+x+ " points");
                    }

                    if (i%6==0){
                        bOvers +=1;
                        tOvers -=1;
                    }

                    System.out.println("Total score is "+tScore);

                    if ((tBalls-i)%6==0){
                        System.out.println(tOvers+" are left");
                    }
                    else {
                        System.out.println((tOvers-1)+" overs and "+((tBalls-i)%6)+" balls are left");
                    }

                    System.out.println(tWickets+" Wickets");

                    if (bOvers == 4) {
                        if (inning ==1)                         // bowler wickets assigning
                            sTeamWickets.add(bowlerWickets);
                        else fTeamWickets.add(bowlerWickets);
                        highestWickets.put(bowler, bowlerWickets);
                        bowlingIndex +=1;
                        try {
                            bowler = bowlingTeam.getName().get(bowlingIndex);
                            bOvers =0;
                            bowlerWickets =0;
                            System.out.println("");
                            System.out.println(bowler+" is bowling now");
                        }
                        catch (Exception ignored){}
                    }
                    Thread.sleep(500);
                }
            }
        }

        if (inning ==1)
            sTeamWickets.add(bowlerWickets);
        else fTeamWickets.add(bowlerWickets);
        highestWickets.put(bowler, bowlerWickets);
        if (inning ==1)
            fTeamRuns.add(batsmanScore);
        else sTeamRuns.add(batsmanScore);
        highestRuns.put(batsman, batsmanScore);

        // Final results
        System.out.println("");
        if (pScore<tScore)
            System.out.println(battingTeamName+" Won!");
        else System.out.println("Team "+battingTeamName);
        System.out.println("Total score is "+tScore);
        if (tOvers!=0)
            System.out.println((tOvers-1)+" overs are left");
        else System.out.println(tOvers+" overs are left");
        System.out.println(tWickets+" Wickets");

        return tScore;
    }

    public static void displayPlayerResult(String fTeamName, int fTeamScore, String sTeamName, int sTeamScore) throws InterruptedException, IOException {
        System.out.println("");
        System.out.println("   "+fTeamName+" SCORED "+fTeamScore+" POINTS");
        System.out.println();
        System.out.println("CAP  -  NAME  -  WICKETS  -  RUNS");
        System.out.println("");
        for (int i = 0; i < fTeamCaps.size(); i++) {
            try {
                System.out.print(fTeamCaps.get(i) + " - ");
            } catch (Exception e) {
                System.out.print(" 0 - ");
            }
            try {
                System.out.print(fTeamNames.get(i) + " - ");
            } catch (Exception e) {
                System.out.print(" 0 - ");
            }
            try {
                System.out.print(fTeamWickets.get(i) + " - ");
            } catch (Exception e) {
                System.out.print(" 0 - ");
            }
            try {
                System.out.print(fTeamRuns.get(i));
            } catch (Exception e) {
                System.out.print(" 0");
            }
            System.out.println("");
        }

        Thread.sleep(1000);

        System.out.println("");
        System.out.println("   "+sTeamName+" SCORED "+sTeamScore+" POINTS");
        System.out.println("");
        System.out.println("CAP  -  NAME  -  WICKETS  -  RUNS");
        System.out.println("");
        for (int i = 0; i < sTeamCaps.size(); i++) {
            try {
                System.out.print(sTeamCaps.get(i) + " - ");
            } catch (Exception e) {
                System.out.print(" 0 - ");
            }
            try {
                System.out.print(sTeamNames.get(i) + " - ");
            } catch (Exception e) {
                System.out.print(" 0 - ");
            }
            try {
                System.out.print(sTeamWickets.get(i) + " - ");
            } catch (Exception e) {
                System.out.print(" 0 - ");
            }
            try {
                System.out.print(sTeamRuns.get(i));
            } catch (Exception e) {
                System.out.print(" 0");
            }
            System.out.println("");
        }
        FileWriter summary = new FileWriter("MatchSummary.txt",true);
        try {
            summary.write("Team1: "+fTeamName+"\n");
            summary.write("Score: "+fTeamScore+"\n");
            summary.write("Team 2: "+sTeamName+"\n");
            summary.write("Score: "+sTeamScore+"\n");
            if (fTeamScore>sTeamScore)
                summary.write("Winner: "+fTeamName+"\n");
            else summary.write("Winner: "+sTeamName+"\n");
            summary.write(" \n");
            summary.close();
        }catch (IOException ignored) {}
    }

    public static void  top5() throws InterruptedException {

        Map<String, Integer> TopBatsmen = Hashmap.sortByComparator(highestRuns, false);
        Map<String, Integer> TopBowlers = Hashmap.sortByComparator(highestWickets, false);

        System.out.println("   TOP 5 BOWLERS   ");
        System.out.println("");
        System.out.println("  NAME   -   WICKETS");
        System.out.println("");
        int count1 = 0;
        for (String key : TopBowlers.keySet()) {
            System.out.println(key+ " - " + TopBowlers.get(key));
            count1++;
            if (count1 == 5)
                break;
        }

        Thread.sleep(1000);
        System.out.println("");
        System.out.println("   TOP 5 BATSMEN   ");
        System.out.println("");
        System.out.println("  NAME   -   SCORE");
        System.out.println("");
        int count2 = 0;
        for (String key : TopBatsmen.keySet()) {
            System.out.println(key+ " - " + TopBatsmen.get(key));
            count2++;
            if (count2 == 5)
                break;
        }
    }

    public static void tournamentStandings( int groupNo, ArrayList groupA, ArrayList groupB,String fTeamName, int fTeamScore,String sTeamName, int sTeamSore) {
        HashMap<String, Integer> groupAResult = new HashMap();
        HashMap<String, Integer> groupBResult = new HashMap();

        if (groupNo == 1) {
            groupAResult.put(fTeamName, fTeamScore);
            groupAResult.put(sTeamName, sTeamSore);

            for (int i = 0; i < groupA.size(); i++) {
                if (groupA.get(i) != fTeamName && groupA.get(i) != sTeamName) {
                    groupAResult.put((String) groupA.get(i), 0);
                }
            }
            for (int i = 0; i < groupB.size(); i++) {
                groupBResult.put((String) groupB.get(i), 0);

            }
        }
         else{
             groupBResult.put(fTeamName, fTeamScore);
             groupBResult.put(sTeamName, sTeamSore);


            for (int i = 0; i < groupB.size(); i++) {
                if (groupB.get(i) != fTeamName && groupB.get(i) != sTeamName) {
                    groupBResult.put((String) groupB.get(i), 0);
                }
            }
            for (int i = 0; i < groupA.size(); i++) {
                groupAResult.put((String) groupA.get(i), 0);
            }
         }

        Map<String, Integer>  groupAStanding = Hashmap.sortByComparator(groupAResult, false);
        Map<String, Integer>  groupBStanding = Hashmap.sortByComparator(groupBResult, false);

        System.out.println("");
        System.out.println("   GROUP A");
        for (String key : groupAStanding.keySet()) {
            System.out.println(key + " - " + groupAStanding.get(key));
        }

        System.out.println("");
        System.out.println("   GROUP B");
        for (String key : groupBStanding.keySet()) {
            System.out.println(key + " - " + groupBStanding.get(key));
        }
    }
}
