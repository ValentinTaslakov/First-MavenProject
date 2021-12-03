package rpg_tests;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 100;
    private static final int DEAD_DUMMY_HEALTH = 0;
    private static final int ATTACK_POINT = 10;
    private static final int EXPECTED_DUMMY_HEALTH = DUMMY_HEALTH - ATTACK_POINT;

    private Dummy dummy;
    private Dummy deadDummy;

    @BeforeTest
    public void setUp() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);


    }


    @Test
    public void testDummyLossesHealthWhenAttacked() {

        dummy.takeAttack(ATTACK_POINT);

        assertEquals(EXPECTED_DUMMY_HEALTH, dummy.getHealth());
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testDeadDummyThrowsWhenAttacked() {

        deadDummy.takeAttack(ATTACK_POINT);
    }

    @Test
    public void testDeadDummyCanGiveXP() {

        Assert.assertEquals(DUMMY_EXPERIENCE,deadDummy.giveExperience());
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testAliveDummyCanGiveXP() {
        dummy.giveExperience();
    }

}
