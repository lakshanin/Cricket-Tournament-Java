package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionTest {

    @Test
    public void selectedTeam() {

        int groupNo =1;
        int teamNo = 1;
        Team slTeam = sample.Team.slTeam();
        Team ausTeam = sample.Team.ausTeam();
        Team wiTeam = sample.Team.wiTeam();
        Team nzTeam = sample.Team.nzTeam();
        Team indTeam = sample.Team.indTeam();
        Team banTeam = Team.banTeam();
        Team engTeam = sample.Team.engTeam();
        Team pakTeam = Team.pakTeam();

        Team expectedTeam = slTeam;
        Team actualTeam = Selection.SelectedTeam(groupNo, teamNo, slTeam, ausTeam, wiTeam, nzTeam, indTeam, banTeam, engTeam, pakTeam);
        assertSame(expectedTeam, actualTeam);
    }

    @Test
    public void selectedTeamName() {
        int groupNo =1;
        int teamNo=1;
        String userTeam = "Sri Lanka";

        String actualOutput = Selection.selectedTeamName(groupNo, teamNo);
        assertSame(userTeam, actualOutput);
    }
}