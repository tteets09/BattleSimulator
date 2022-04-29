import Game.Battle;
import StandardIO.StdDraw;

/**
 * @author Tony Teets
 * @since 4/26/22
 * @version 1.0
 *
 * <p>This is the runner class for the whole project.</p>
 */
public class Main {

    /**
     * Runs the battle simulator and creates a new battle
     * to run.
     *
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        //Clears the terminal
        StdDraw.clear();
        //Creates a new battle
        Battle battle = new Battle();

        //Creates a player
        battle.playerCreate();

        //Runs the battle
        battle.run();
    }//END main METHOD
}//END Main CLASS
