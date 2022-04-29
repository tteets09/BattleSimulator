package Entities;

/**
 * @author Tony Teets
 * @since 3/19/22
 * @version 1.0
 *
 *<p>A class that represents the simple version of an enemy
 *  * in the game. Holds information like name, health, damage,
 *  * and exp amount. Handles the way the information is displayed.</p>
 */
public class Enemy extends Entity{

    /**
     * @param name The name of the enemy
     * @param health The health of the enemy
     * @param damage The damage of the enemy
     * @param exp The exp amount the enemy will give
     *
     * @custom.require name != ""
     * @custom.require name.length() <= 10
     * @custom.require health > 10
     * @custom.require damage > 1
     * @custom.require exp >= 2
     * @custom.ensure name != ""
     * @custom.ensure health > 10
     * @custom.ensure damage > 1
     * @custom.ensure exp >= 2
     *
     * @since 3/19/22
     */
    public Enemy(String name, int health, int damage, int exp){
        super(name, health, damage, exp);
    }//END Enemy METHOD

    /**
     * <p>Returns the enemy's information formatted like this: </p>
     *
     * <pre>
     * Enemy (2 EXP):
     * 10 HP    2 DMG
     * </pre>
     *
     * @return String of the enemy's information to be displayed
     *
     * @since 3/19/22
     */
    @Override
    public String toString(){
        return String.format("%s (%d EXP):%n%-8s %-6s", getName(), getExp(),
                getHealth() + " HP", getDamage() + " DMG");
    }//END toString METHOD
}//END Enemy CLASS
