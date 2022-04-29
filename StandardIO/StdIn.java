package StandardIO;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Tony Teets
 * @version 1.0
 * @since 4/12/22
 *
 * This class sets out the standard way things are inputted
 * into the terminal for the game
 */
public class StdIn {
    /**Scanner getting all the information*/
    private static final Scanner input = new Scanner(System.in);

    /**
     * Gets a string value from user
     * @return The string value entered
     *
     * @since 4/12/22
     */
    public static String text(){
        return input.nextLine();
    }//END text METHOD

    /**
     * <p>Gets an action from the user</p>
     * @return The char of the users action
     *
     * @since 4/26/22
     */
    public static char action(){
        char action = ' ';

        try{
            action = input.nextLine().charAt(0);
        }catch(StringIndexOutOfBoundsException e){

        }

        return action;
    }//END action METHOD

    /**
     * Pauses for the user to be able to read text
     * on the screen before it is cleared with StdDraw.clear()
     *
     * @since 4/26/22
     */
    public static void pause(){
        StdDraw.drawText("Press enter to continue... ");

        try{
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//END pause METHOD
}//END StdIn CLASS
