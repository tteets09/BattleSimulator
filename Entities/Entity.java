package Entities;

import java.io.Serializable;

/**
 * @author Tony Teets
 * @since 3/15/22
 * @version 1.1
 *
 * This class represents the base layer of an entity in
 * the game. They can be damaged and can damage other entities.
 */
public abstract class Entity implements Serializable {

    /**The name of the entity*/
    protected String name;
    /**The health of the entity*/
    protected int health;
    /**The damage of the entity*/
    protected int damage;
    /**The exp of the entity*/
    protected int exp;

    /**
     * @param name The name of the entity
     * @param health The health of the entity
     * @param damage The damage of the entity
     * @param exp The exp of the entity
     *
     * @custom.require name != ""
     * @custom.require health > 0
     * @custom.require damage > 0
     * @custom.require exp >= 0
     * @custom.ensure name != "" && getName() == name
     * @custom.ensure health > 0 && getHealth() == health
     * @custom.ensure damage > 0 && getDamage() == damage
     * @custom.ensure exp >= 0 && getEXP() == exp
     *
     * @since 3/15/22
     */
    public Entity(String name, int health, int damage, int exp){
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.exp = exp;
    }//END CONSTRUCTOR

    /**
     * @param name The name of the entity
     * @param health The health of the entity
     * @param damage The damage of the entity
     *
     * @custom.require name != ""
     * @custom.require health > 0
     * @custom.require damage > 0
     * @custom.ensure name != "" && getName() == name
     * @custom.ensure health > 0 && getHealth() == health
     * @custom.ensure damage > 0 && getDamage() == damage
     *
     * @since 3/15/22
     */
    public Entity(String name, int health, int damage){
        this(name, health, damage, 0);
    }//END CONSTRUCTOR

    /**
     * <p>Gets the name of the entity</p>
     *
     * @return The name of the entity
     *
     * @custom.require name != ""
     * @custom.ensure name != "" && getName() == name
     *
     * @since 3/15/22
     */
    public String getName(){
        return this.name;
    }//END getName METHOD

    /**
     * <p>Gets the health of the entity</p>
     *
     * @return The health of the entity
     *
     * @custom.require health > 0
     * @custom.ensure health > 0 && getHealth() == health
     *
     * @since 3/15/22
     */
    public int getHealth(){
        return this.health;
    }//END getHealth METHOD

    /**
     * <p>Gets the damage of the entity</p>
     *
     * @return The damage of the entity
     *
     * @custom.require damage > 0
     * @custom.ensure damage > 0 && getDamage == damage
     *
     * @since 3/15/22
     */
    public int getDamage(){
        return this.damage;
    }//END getDamage METHOD

    /**
     * <p>Gets the exp of the entity</p>
     *
     * @return The exp of the entity
     *
     * @custom.require exp >= 0
     * @custom.ensure exp >= 0 && getEXP() == exp
     *
     * @since 3/15/22
     */
    public int getExp(){
        return this.exp;
    }//END getEXP METHOD

    /**
     * <p>Checks if the entity is dead or not by checking if the health is at 0.</p>
     * @return If the entity is dead or not
     *
     * @custom.require health >= 0
     * @custom.ensure (health == 0) ? true : false
     *
     * @since 3/15/22
     */
    public boolean isDead(){
        return health == 0;
    }//END isDead METHOD

    /**
     * <p>Damages another entity by specifying who is being damaged.</p>
     *
     * @param other the other entity that is being damaged
     *
     * @custom.require other.getHealth() > 0
     * @custom.require damage > 0
     * @custom.ensure other.health -= this.damage
     *
     * @since 3/15/22
     */
    public void damage(Entity other){
        other.takeDamage(damage);
    }//END damage METHOD

    /**
     * <p>If the entity has enough health to take all the damage it will be removed. If it does not
     * the health will be set to 0.</p>
     *
     * @param damage the damage to be taken away from entity
     *
     * @custom.require damage > 0
     * @custom.ensure (damage > health) ? health = 0 : health -= damage
     *
     * @since 3/15/22
     */
    protected void takeDamage(int damage){
        // If the damage is more than the current health
        // then set the health to 0
        if(damage > health){
            health = 0;
        }else {
            // If the damage is not more than the health
            // then the amount of damage will be subtracted
            // from the entities healths
            health -= damage;
        }
    }//END takeDamage METHOD

    /**
     * <p>Common method for both Player and Enemy</p>
     *
     * @return A string of the entity's information to be displayed
     * @since 3/19/22
     */
    @Override
    public abstract String toString(); //END ABSTRACT toString METHOD
}//END Entity CLASS