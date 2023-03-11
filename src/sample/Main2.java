package sample;

import javafx.event.ActionEvent;

import java.io.IOException;

public class Main2{

    public  void Main2(ActionEvent event) throws InterruptedException, IOException {

        // Teams and Players assigning
        Team.TeamPlayers();

        int groupNo = 0;
        int userTeamNo = 0;
        Team userTeam = null;
        Team slTeam, ausTeam, nzTeam, wiTeam, indTeam, banTeam, engTeam, pakTeam;

        if (SriLanka.getSelected() == 1) {
            slTeam = SriLanka.getSlTeam();
            groupNo = 1;
            userTeamNo = 1;
            userTeam = slTeam;
        } else slTeam = Team.slTeam();
        if (Australia.getSelected() == 1) {
            ausTeam = Australia.getAusTeam();
            groupNo = 1;
            userTeamNo = 2;
            userTeam = ausTeam;
        } else ausTeam = Team.ausTeam();
        if (WestIndies.getSelected() == 1) {
            wiTeam = WestIndies.getWiTeam();
            groupNo = 1;
            userTeamNo = 3;
            userTeam = wiTeam;
        } else wiTeam = Team.wiTeam();
        if (NewZealand.getSelected() == 1) {
            nzTeam = NewZealand.getNzTeam();
            groupNo = 1;
            userTeamNo = 4;
            userTeam = nzTeam;
        } else nzTeam = Team.nzTeam();
        if (India.getSelected() == 1) {
            indTeam = India.getIndTeam();
            groupNo = 2;
            userTeamNo = 1;
            userTeam = indTeam;
        } else indTeam = Team.indTeam();
        if (Bangladesh.getSelected() == 1) {
            banTeam = Bangladesh.getBanTeam();
            groupNo = 2;
            userTeamNo = 2;
            userTeam = banTeam;
        } else banTeam = Team.banTeam();
        if (England.getSelected() == 1) {
            engTeam = England.getEngTeam();
            groupNo = 2;
            userTeamNo = 3;
            userTeam = banTeam;
        } else engTeam = Team.engTeam();
        if (Pakistan.getSelected() == 1) {
            pakTeam = Pakistan.getPakTeam();
            groupNo = 2;
            userTeamNo = 4;
            userTeam = pakTeam;
        }
        else pakTeam = Team.pakTeam();

        String userTeamName = Selection.selectedTeamName(groupNo, userTeamNo);

        System.out.println("- You will be competing with -");
        int opponentTeamNo = Team.OpponentTeamNo(userTeamNo);


        String opponentTeamName = Selection.selectedTeamName(groupNo, opponentTeamNo);
        System.out.println("");
        System.out.println("   "+opponentTeamName);
        System.out.println("");

        Team opponentTeam = Selection.SelectedTeam(groupNo, opponentTeamNo, slTeam, ausTeam, wiTeam, nzTeam, indTeam, banTeam, engTeam, pakTeam);
        Thread.sleep(1000);

        //Toss
        int min = 1, max = 2;
        int toss = (int) (Math.random() * (max - min + 1) + min);

        String fTeamName;
        Team fTeam;
        String sTeamName;
        Team sTeam;

        if (toss == 1) {
            int userChoice = Validation.ValidationTwoInputs("You won the Toss! Enter 1 for Batting, 2 for Bowling");
            if (userChoice == 1) {
                fTeamName = userTeamName;
                fTeam = userTeam;
                sTeamName = opponentTeamName;
                sTeam = opponentTeam;
            } else {
                fTeamName = opponentTeamName;
                fTeam = opponentTeam;
                sTeamName = userTeamName;
                sTeam = userTeam;

            }
        } else {
            System.out.println("You lost the Toss!");
            fTeamName = userTeamName;
            fTeam = userTeam;
            sTeamName = opponentTeamName;
            sTeam = opponentTeam;
        }

        //First Inning
        System.out.println("");
        System.out.println("     FIRST INNING");
        System.out.println("");
        Thread.sleep(1000);
        int score1 = Match.Match(fTeamName, fTeam, sTeamName, sTeam, 10000, 1);
        Thread.sleep(1000);

        //Second Inning
        System.out.println("");
        System.out.println("     SECOND INNING");
        System.out.println("");
        Thread.sleep(1000);
        int score2 = Match.Match(sTeamName, sTeam, fTeamName, fTeam, score1, 2);
        Thread.sleep(1000);

        // Match Summary
        System.out.println("");
        System.out.println("   MATCH SUMMARY   ");
        System.out.println("");
        Thread.sleep(1000);

        if (score1 > score2) {
            int winingScore = score1 - score2;
            System.out.println(fTeamName + " won by " + winingScore + " runs!");
        } else {
            int winingScore = score2 - score1;
            System.out.println(sTeamName + " won by " + winingScore + " runs!");
        }
        Thread.sleep(1000);

        Match.displayPlayerResult(fTeamName, score1, sTeamName, score2);
        System.out.println("");
        Thread.sleep(1000);

        Match.top5();
        Thread.sleep(1000);
        System.out.println("");
        System.out.println("    TOURNAMENT STANDINGS");
        Match.tournamentStandings(groupNo, Group.groupA(), Group.groupB(), fTeamName, score1, sTeamName, score2);
    }
}

