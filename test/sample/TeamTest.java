package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void opponentTeamNo() {

        int teamNo = 1;
        int unexpectedValue= 1;

        int actualValue = Team.OpponentTeamNo(teamNo);
        assertNotSame(unexpectedValue, actualValue);
    }
}