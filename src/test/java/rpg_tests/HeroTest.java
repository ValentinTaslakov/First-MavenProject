package rpg_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTest {
    private static final int TARGET_XP = 100;
    private static final String HERO_NAME = "Name";

    @Test
    public void testHeroGainsXPWhenTargetISDead() {
        Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {
            }

            @Override
            public int giveExperience() {
                return TARGET_XP;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };
        Weapon fakeWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return 10;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Hero hero = new Hero(HERO_NAME,fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals(TARGET_XP,hero.getExperience());
    }
}
