package rpg_tests;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int BROKEN_AXE_DURABILITY = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY -1;



    private Dummy dummy;
    private Axe axe;
    private Axe brokenAxe;

    @BeforeTest
    public void setUp(){
        System.out.println("hello");
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_ATTACK,BROKEN_AXE_DURABILITY);
        this.dummy = new Dummy(100,100);
    }

    @Test
    public void weaponAttacksLosesDurability(){

        axe.attack(dummy);

        Assert.assertEquals(EXPECTED_DURABILITY,axe.getDurabilityPoints());
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testAxeAttackThrowsIfAxeIsBroken() {

        brokenAxe.attack(dummy);
    }
}
