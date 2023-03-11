package sample;

public class Selection {

    public static Team SelectedTeam(int groupNo, int teamNo, Team slTeam, Team ausTeam, Team wiTeam, Team nzTeam, Team indTeam, Team banTeam, Team engTeam, Team pakTeam){

        Team userTeam = null;
        if (groupNo==1 && teamNo==1) {
            slTeam.PlayerView();
            userTeam = slTeam;
        }
        else if (groupNo==1 && teamNo==2) {
            ausTeam.PlayerView();
            userTeam = ausTeam;
        }
        else if (groupNo==1 && teamNo==3) {
            wiTeam.PlayerView();
            userTeam = wiTeam;
        }
        else if (groupNo==1 && teamNo==4) {
            nzTeam.PlayerView();
            userTeam = nzTeam;
        }
        else if (groupNo==2 && teamNo==1) {
            indTeam.PlayerView();
            userTeam = indTeam;
        }
        else if (groupNo==2 && teamNo==2) {
            banTeam.PlayerView();
            userTeam = banTeam;
        }
        else if (groupNo==2 && teamNo==3) {
            engTeam.PlayerView();
            userTeam = engTeam;
        }
        else if (groupNo==2 && teamNo==4) {
            pakTeam.PlayerView();
            userTeam = pakTeam;
        }
        return userTeam;
    }

    public static String selectedTeamName(int groupNo, int teamNo){

        String userTeam = null;
        if (groupNo==1 && teamNo==1) {
            userTeam = "Sri Lanka";
        }
        else if (groupNo==1 && teamNo==2) {
            userTeam = "Australia";
        }
        else if (groupNo==1 && teamNo==3) {
            userTeam = "West Indies";
        }
        else if (groupNo==1 && teamNo==4) {
            userTeam = "New Zealand";
        }
        else if (groupNo==2 && teamNo==1) {
            userTeam = "India";
        }
        else if (groupNo==2 && teamNo==2) {
            userTeam = "Bangladesh";
        }
        else if (groupNo==2 && teamNo==3) {
            userTeam = "England";
        }
        else if (groupNo==2 && teamNo==4) {
            userTeam = "Pakistan";
        }
        return userTeam;
    }
}
