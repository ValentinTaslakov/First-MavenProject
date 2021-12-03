package rpg_tests;

import org.junit.Before;
import org.testng.annotations.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class DummyTest {
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp(){
        this.dummy = new Dummy(100,100);
        this.deadDummy = new Dummy(0,100);


    }


    @Test
    public void testDummyLossesHealthWhenAttacked() {

        int attackPoint = 10;

        dummy.takeAttack(attackPoint);

        assertEquals(90,dummy.getHealth());
    }

    @Test (expectedExceptions = IllegalStateException.class)
    public void testDeadDummyThrowsWhenAttacked( ){

        deadDummy.takeAttack(10);
    }
}
