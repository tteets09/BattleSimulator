package Entities;

import StandardIO.StdDraw;
import StandardIO.StdIn;

/**
 * @author Tony Teets
 * @since 3/19/22
 * @version 1.0
 *
 * A class that represents the player that is playing
 * the game. Handles all the player's information and
 * handles attacks and leveling system.
 */
public class Player extends Entity{

    /**The level of the player*/
    private int level;
    /**The amount the health will go up on next levelup*/
    private int levelUpHealthAmt;

    /**The max health the user can have*/
    private int maxHealth;

    /**The health potions the user has*/
    private int healthPotion;

    /**
     * @param name The player's name
     * @param health The player's health
     * @param damage The player's damage
     * @since 3/19/22
     *
     * @custom.require name != ""
     * @custom.require name.length() <= 10
     * @custom.require health >= 15
     * @custom.require damage >= 2
     * @custom.ensure name != "" && getName() != ""
     * @custom.ensure health >= 15
     * @custom.ensure damage >= 2
     */
    public Player(String name, int health, int damage){
        super(name, health, damage);
        maxHealth = health;
        level = 1;
        levelUpHealthAmt = 2;
        healthPotion = 5;
    }//END CONSTRUCTOR

    /**
     * <p>Overrides the original from class Entity to add exp to
     * their current exp amount.</p>
     *
     * @param other the other entity that is being damaged
     * @since 3/19/22
     *
     * @custom.require damage > 0
     * @custom.ensure other.health -= damage
     */
    @Override
    public void damage(Entity other){
        other.takeDamage(damage);

        // If the enemy is dead then move to the levelUp method
        if(other.isDead()){
            levelUp(other.getExp());
        }
    }//END damage METHOD

    /**
     * <p>Heals the player and uses one of the 5 health
     * potions they were given in the beginning</p>
     *
     * @since 4/26/22
     * @custom.require isDead == false
     * @custom.ensure health += levelupHealthAmt + 3
     */
    public void heal(){
        // Decrements the amount of health potions the user
        // has left
        healthPotion--;

        //If the player is not dead then heal them
        if(!isDead() && healthPotion != 0){
            health += levelUpHealthAmt + 3;
        }else if(healthPotion == 0){
            StdDraw.clear();
            StdDraw.drawBoxText("You do not have any potions left!");
            StdIn.pause();
        }
    }//END heal METHOD

    /**
     * <p>Gets the level of the player</p>
     *
     * @return The level of the player
     * @since 3/19/22
     */
    public int getLevel(){
        return this.level;
    }//END getLevel METHOD

    /**
     * <p>Gets the max health of the user</p>
     * @return The max health from the user
     */
    public int getMaxHealth(){
        return this.maxHealth;
    }//END getMaxHealth METHOD

    /**
     *<p>Adds the amount of exp the enemy had to theirs and checks if
     * the player needs to be leveled up</p>
     *
     * @param exp The amount of exp to be added to the Player's
     * @since 3/19/22
     */
    private void levelUp(int exp){
        //Add the exp from the enemy to the player's exp
        this.exp += exp;

        // If the exp is divisible by 5 then add to the player's
        // damage. If the exp is divisible by 3 then it will add
        // to the player's health. Both will add a level to the
        // player's current level
        if((this.exp % 5) == 0){
            damage++;
            level++;
        }else if((this.exp % 3) == 0){
            maxHealth += levelUpHealthAmt++;
            health = maxHealth;
            levelUpHealthAmt += 3;
            level++;
        }
    }//END damage METHOD

    /**
     * <p>Returns a String with the players name, health, and level</p>
     *
     * <pre>
     * Player (LVL 1):
     * 15 HP    3 DMG
     * </pre>
     *
     * @return String of the player's information to be displayed
     * @since 3/19/22
     */
    @Override
    public String toString(){
        return String.format("%s (LVL %d):%n%-8s %-6s", getName(), getLevel(),
                getHealth() + " HP", getDamage() + " DMG");
    }//END toString METHOD
}//END Player CLASS
