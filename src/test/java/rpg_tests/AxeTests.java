package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private Dummy dummy;
    private Axe axe;
    private Axe brokenAxe;

    @BeforeTest
    public void setUp(){
        System.out.println("hello");
        this.axe = new Axe(10,10);
        this.brokenAxe = new Axe(10,0);
        this.dummy = new Dummy(100,100);
    }

    @Test
    public void weaponAttacksLosesDurability(){

        axe.attack(dummy);

        Assert.assertEquals(9,axe.getDurabilityPoints());
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testAxeAttackThrowsIfAxeIsBroken() {

        brokenAxe.attack(dummy);
    }
}
