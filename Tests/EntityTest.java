package Tests;

//Importing Player and Enemy class
//Import goes packageName.class;
import Entities.Enemy;
import Entities.Player;

//Getting all the assert methods
import static org.junit.Assert.*;

//Importing Before and Test from JUNIT
import org.junit.Before;
import org.junit.Test;

/**
 * @author Tony Teets
 * @since 3/19/22
 * @version 1.1
 *
 * Tests the Entity class to make sure all of its components
 * are working correctly.
 * */
public class EntityTest {

    Player player;
    Enemy enemy;

    /**
     * Creates a new player and enemy object every time a test is called
     * @since 3/18/22
     */
    @Before
    public void setup(){
        player = new Player("Player", 15, 3);
        enemy = new Enemy("Enemy", 10, 2, 3);
    }//END setup METHOD

    /**
     * Tests if the getName() method is returning the correct information
     * @since 3/18/22
     */
    @Test
    public void getNameTest(){
        assertEquals("Player", player.getName());
        assertEquals("Enemy", enemy.getName());
    }//END getNameTest METHOD

    /**
     * Tests if the getHealth() method is returning the correct information
     * @since 3/18/22
     */
    @Test
    public void getHealthTest(){
        assertEquals(15, player.getHealth());
        assertEquals(10, enemy.getHealth());
    }//END getHealthTest METHOD

    /**
     * Checks if the getDamage() method is returning the correct information
     * @since 3/18/22
     */
    @Test
    public void getDamageTest(){
        assertEquals(3, player.getDamage());
        assertEquals(2, enemy.getDamage());
    }//END getDamageTest METHOD

    /**
     * Tests if the getEXP() method is returning the correct information
     * @since 3/18/22
     */
    @Test
    public void getEXPTest(){
        assertEquals(0, player.getExp());
        assertEquals(3, enemy.getExp());
    }//END getExpTest METHOD

    /**
     * Tests if the isDead() method is returning the correct information
     * @since 3/18/22
     */
    @Test
    public void isDeadTrueTest(){
        do{
            enemy.damage(player);
        }while(!player.isDead());

        assertTrue(player.isDead());
    }//END isDeadTrueTest METHOD

    /**
     * Tests if the isDead() method is returning the correct information
     * @since 3/18/22
     */
    @Test
    public void isDeadFalseTest(){
        assertFalse(enemy.isDead());
        assertFalse(player.isDead());
    }//END isDeadFalseTest METHOD

    /**
     * Tests if the damageTest() method is returning the correct information
     * @since 3/18/22
     */
    @Test
    public void damageTest(){
        player.damage(enemy);
        enemy.damage(player);

        assertEquals(7, enemy.getHealth());
        assertEquals(13, player.getHealth());
    }//END damageTest METHOD

    /**
     * Tests if the levelUp() method in the Player class is returning the
     * correct information
     * @since 3/19/22
     */
    @Test
    public void levelUpTest(){
        do{
            player.damage(enemy);
        }while(!enemy.isDead());

        assertEquals(2, player.getLevel());
    }//END levelUpTest METHOD

    /**
     * Tests if the toString() method is returning the correct information
     * @since 3/19/22
     */
    @Test
    public void toStringTest(){
        String playerExpected = String.format("%s (LVL %d):%n%-8s %-6s", "Player", 1, "15 HP", "3 DMG");
        String enemyExpected = String.format("%s (%d EXP):%n%-8s %-6s", "Enemy", 3, "10 HP", "2 DMG");

        assertEquals(playerExpected, player.toString());
        assertEquals(enemyExpected, enemy.toString());
    }//END toStringTest METHOD
}//END Tests.EntityTest METHOD
