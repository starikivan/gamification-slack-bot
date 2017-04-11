package juja.microservices.gamification.slackbot.model;

import juja.microservices.gamification.slackbot.exceptions.WrongCommandFormatException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

//@RunWith(SpringRunner.class)
//@TestPropertySource(value="classpath:/resources/application.properties")
public class ThanksAchievementTest {

    private ThanksAchievement expectedAchievement;

    @Before
    public void setup(){
        expectedAchievement = new ThanksAchievement("max", "bob", "Thanks bob for help");
    }

    @Test
    public void createAchievement() throws Exception {
        //given
        String fromUserUuid = "max";
        String text = "Thanks @#bob#@ for help";
        //when
        ThanksAchievement actualAchievement = new ThanksAchievement(fromUserUuid, text);
        //then
        assertEquals(expectedAchievement.toString(), actualAchievement.toString());
    }

    @Test(expected = WrongCommandFormatException.class)
    public void createAchievementWrongComand() throws Exception {
        //given
        String fromUserUuid = "max";
        String text = "Thanks @#bob#@ @#max#@ for help";
        //when
        ThanksAchievement actualAchievement = new ThanksAchievement(fromUserUuid, text);
        //then
        fail();
    }

    @Test(expected = WrongCommandFormatException.class)
    public void createAchievementWithoutUserTo() throws Exception {
        //given
        String fromUserUuid = "max";
        String text = "Thanks for help";
        //when
        ThanksAchievement actualAchievement = new ThanksAchievement(fromUserUuid, text);
        //then
        fail();
    }
}