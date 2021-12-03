package rpg_tests;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int BROKEN_AXE_DURABILITY = 0;

    private Target dummy;
    private Weapon axe;
    private Weapon brokenAxe;

    @BeforeTest
    public void setUp(){
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_ATTACK,BROKEN_AXE_DURABILITY);
        this.dummy = new Dummy(100,100);
    }

    @Test
    public void weaponAttacksLosesDurability(){

        axe.attack(dummy);

        Assert.assertEquals(AXE_DURABILITY-1,axe.getDurabilityPoints());
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testAxeAttackThrowsIfAxeIsBroken() {

        brokenAxe.attack(dummy);
    }
}
