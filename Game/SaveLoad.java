package Game;

import StandardIO.StdDraw;
import StandardIO.StdIn;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Tony Teets
 * @since 4/26/22
 * @version 1.0
 *
 * This class consists of the save and load process for the game
 */
public class SaveLoad {

    /**
     * <p>Checks if the save file exists</p>
     *
     * @return If the save file exists
     */
    private static boolean saveFileExists(){
        Path path = Paths.get("./Saves/GameSave.ser");
        return Files.exists(path);
    }//END saveFileExist METHOD

    /**
     * Saves the game in its current state
     * @param battle The game that is being saved
     */
    public static void save(Battle battle){
        try{
            StdDraw.clear();

            if(!saveFileExists()){
                File dir = new File("./Saves");
                dir.mkdir();
                File file = new File("./Saves/GameSave.ser");
                file.createNewFile();
            }

            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("./Saves/GameSave.ser")));

            outputStream.writeObject(battle);
            outputStream.close();

            StdDraw.drawBoxText("You have successfully saved!");
            StdIn.pause();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//END save METHOD

    /**
     * <p>Gets the players save if it exists</p>
     * @return The players save file
     */
    public static Battle load(){
        Battle battle = null;
        StdDraw.clear();

        if(saveFileExists()){
            try {

                ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("./Saves/GameSave.ser")));

                battle = (Battle)inputStream.readObject();

                inputStream.close();

                StdDraw.drawBoxText("You have successfully loaded your save!");
                StdIn.pause();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            StdDraw.drawBoxText("You do not have a save!");
            StdIn.pause();
        }

        return battle;
    }//END load METHOD
}//END SaveLoad CLASS
