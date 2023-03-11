package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {

    @Test
    public void match() throws InterruptedException {

        String battingTeamName = "Sri Lanka";
        Team battingTeam = Team.slTeam();
        String bowlingTeamName = "Australia";
        Team bowlingTeam = Team.ausTeam();

        int unexpectedValue = 0;
        int actualOutput = Match.Match(battingTeamName, battingTeam, bowlingTeamName, bowlingTeam, 0, 1);

        assertNotEquals(unexpectedValue, actualOutput);
    }
}