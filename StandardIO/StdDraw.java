package StandardIO;

import Entities.Enemy;
import Entities.Player;

/**
 * @author Tony Teets
 * @version 1.0
 * @since 4/12/22
 *
 * This class sets out the standard way things are printed
 * out into the terminal.
 */
public class StdDraw {

    /**String that clears the terminal when printed*/
    private final static String clearANSI = "\033[H\033[2J";

    /**
     * Clears the terminal of all text and leaves blank
     *
     * @since 4/12/22
     */
    public static void clear(){
        //Clears the terminal
        System.out.print(clearANSI);
    }//END clear METHOD

    /**
     * Prints text out into the terminal
     *
     * @param text The text being printed out
     *
     * @since 4/12/22
     */
    public static void drawText(String text){
        //Prints out text regularly
        System.out.print(text);
    }//END drawText METHOD

    /**
     * Prints text out in a box into the terminal
     * @param text The text being printed into a box
     *
     * @since 4/12/22
     */
    public static void drawBoxText(String text){
        //Creates a line for the box
        String line = line(text);

        //Formats the box with the text and prints out
        System.out.printf("%s%n   %s   %n%s%n", line, text, line);
    }//END drawBoxText METHOD

    /**
     * Draws the stats of the player and enemy
     * @param player The player
     * @param enemy The enemy
     *
     * @custom.require player.name <= 10
     * @custom.require enemy.name <= 10
     * @custom.ensure Correctly formatted text block
     *
     * @since 4/12/22
     */
    public static void drawStats(Player player, Enemy enemy){
        //Creates a line for the text
        String line = line(58);
        //Creates the text block for the stats
        String statsBlock = statsBlock(player, enemy);

        //Prints out the text block
        System.out.printf("%s%n   %s%n%s%n", line, statsBlock, line);
    }//END drawStats METHOD

    /**
     * <p>Prints out all of the available actions</p>
     *
     * @since 4/26/22
     */
    public static void drawActions(){
        String[] actions = new String[]{"a: attack", "h: heal", "s: save", "l: load"};

        String formattedActions = "";

        for(String action : actions){
            formattedActions += String.format("%-10s ", action);
        }

        System.out.print(formattedActions + "\n Enter an action: ");
    }//END drawActions METHOD

    /**
     * Creates a block of text formatted with the player's
     * name, level, health, and damage and the enemy's
     * name, exp, health, and damage.
     *
     * @param player The player
     * @param enemy The enemy
     * @return The formatted text block
     *
     * @custom.require player.name <= 10
     * @custom.require enemy.name <= 10
     * @custom.ensure Correctly formatted text block
     *
     * @since 4/12/22
     */
    private static String statsBlock(Player player, Enemy enemy){
        //Formats the text in a certain way so that everything lines up
        return String.format("%-22s%-10s%-22s%n   %-8s %-6s%-17s%-8s %-6s",
                player.getName() + String.format(" (LVL %02d):", player.getLevel()),"", enemy.getName() + String.format(" (%02d EXP):", enemy.getExp()),
                player.getHealth() + " HP", player.getDamage() + " DMG", "", enemy.getHealth() + " HP", enemy.getDamage() + " DMG");
    }//END statsBlock METHOD

    /**
     * Makes a line the length of the String passed in
     * @param text The text being used to get the length
     * @return A line the length of the text
     *
     * @custom.require If string contains "\n" the first line should be the longest
     * @custom.ensure Correctly formatted box text
     *
     * @since 4/12/22
     */
    private static String line(String text){
        int length;
        // If the text contains a line break it will take
        // the length of the first line and create a line
        // with then length of the first line
        if(text.contains("\n")){
            int index = text.indexOf("\n");
            length = text.substring(0, index).length() + 6;
        }else {
            // Gets the length of the text and then gets
            // adds the space wanted on both sides
            length = text.length() + 6;
        }

        String line = "";
        for(int i = 0; i < length; i++){
            line += "*";
        }

        return line;
    }//END line METHOD

    /**
     * Creates a line of a set length
     * @param length The length of the line being created
     * @return The line of the set length
     *
     * @since 4/12/22
     */
    private static String line(int length){
        String line = "";

        for(int i = 0; i < length; i++){
            line += "*";
        }

        return line;
    }//END line METHOD

}//END StdDraw CLASS
