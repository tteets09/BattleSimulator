package Game;

import Entities.Enemy;
import Entities.Player;
import StandardIO.StdDraw;
import StandardIO.StdIn;

import java.io.Serializable;
import java.util.Random;

/**
 * @author Tony Teets
 * @since 4/26/22
 * @version 1.0
 *
 * This class handles the whole battle itself. It will handle
 * all action coming from the user and executing them.
 */
public class Battle implements Serializable{

    /** The player being used in the game*/
    Player player;
    /** The enemy being used in the game*/
    Enemy enemy;

    /**
     * <p>Creates a new player with a specific name from
     * the user</p>
     *
     * @since 4/26/22
     */
    public void playerCreate(){
        // Getting the name of the player from the user
        // If the name is more than 10 characters or
        // empty then it will continue to ask for the user
        // to enter a name.
        String playerName = "";
        while(!(playerName.length() <= 10) || playerName.equals("")){
            // Printing out welcome title
            StdDraw.drawBoxText("Welcome!");
            // Prompting the user for the name
            StdDraw.drawText("Name (Less than 10 characters): ");
            //Getting the name from the user
            playerName = StdIn.text();

            // Clearing the terminal
            StdDraw.clear();
        }

        player = new Player(playerName, 25, 2);
    }//END createPlayer METHOD

    /**
     * <p>Creates a new enemy depending on the stats from
     * the player</p>
     *
     * @since 4/26/22
     */
    public void enemyFactory(){
        // Getting a random name for the enemy
        String[] enemyName = new String[]{"Lil dragon", "Slime Ball", "Froggy", "Ogre", "Giant", "Spider", "Gremlin"};
        Random random = new Random();
        int index = random.nextInt(enemyName.length - 1);

        //Calculating the enemies stats
        int enemyHealth = (player.getMaxHealth() * 2) / 3;
        int enemyDamage = player.getDamage() / 2;
        int enemyEXP = (player.getLevel() * 4) / 2;

        // Creating a new enemy
        enemy = new Enemy(enemyName[index], enemyHealth, enemyDamage, enemyEXP);
    }//END enemyFactory METHOD


    /**
     * <p>Runs the battle</p>
     *
     * @since 4/26/22
     */
    public void run() {
        enemyFactory();
        // While the enemy is not dead continue to loop
        while(!player.isDead()){
            //Draws the stats of the player and enemy
            StdDraw.drawStats(player, enemy);

            //Draws all the possible actions the user can do
            StdDraw.drawActions();

            //Gets the action from the user
            char action = StdIn.action();
            //Executes the action
            execute(action);
            StdDraw.clear();

            if(player.isDead()) break;

            if(enemy.isDead()){
                StdDraw.clear();
                StdDraw.drawBoxText("You have defeated the enemy!");
                StdDraw.drawText(String.format("You have been rewarded %d EXP!%n%n", enemy.getExp()));
                StdIn.pause();
                enemyFactory();
                StdDraw.clear();
            }
        }
    }//END run METHOD

    /**
     * <p>Handles the actions from the users input
     * in the run method</p>
     * @param action The action the user chose
     *
     * @since 4/26/222
     */
    public void execute(char action){
        switch(action){
            case 'a':
                attack();
                break;
            case 'h':
                heal();
                break;
            case 's':
                save();
                break;
            case 'l':
                load();
                break;
            default:
                StdDraw.clear();
                StdDraw.drawBoxText("Invalid action!");
                StdIn.pause();
        }
    }//END execute METHOD

    /**
     * <p> Allows the player to attack and the
     * enemy will return an attack</p>
     *
     * @since 4/26/22
     */
    private void attack(){
        player.damage(enemy);
        enemy.damage(player);
    }//END attack METHOD

    /**
     * <p>Allows the player to heal and the
     * enemy will return an attack</p>
     *
     * @since 4/26/22
     */
    private void heal(){
        player.heal();
        enemy.damage(player);
    }//END heal METHOD

    /**
     * <p>Allows the player to save the game</p>
     *
     * @since 4/26/22
     */
    private void save(){
        SaveLoad.save(this);
    }

    /**
     * <p>Loads save from save file and updates the game
     * to the state from the save file</p>
     *
     * @since 4/26/22
     */
    private void load(){
        //Gets the battle from the save
        Battle battle = SaveLoad.load();
        if(battle == null) return;

        //Sets the player and enemy
        this.player = battle.getPlayer();
        this.enemy = battle.getEnemy();
    }//END load METHOD

    /**
     * <p>Gets the player</p>
     * @return The current state of the player
     *
     * @since 4/26/22
     */
    protected Player getPlayer(){
        return this.player;
    }//END getPlayer METHOD

    /**
     * <p>Gets the enemy</p>
     * @return The current state of the enemy
     *
     * @since 4/26/22
     */
    protected Enemy getEnemy(){
        return this.enemy;
    }//END getEnemy METHOD
}//END Battle CLASS
