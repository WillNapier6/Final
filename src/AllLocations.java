/**
 * Created by Sawyer Cole on 5/9/2017.
 */
import java.util.*;
/**
 * AllLocations.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//Stores all of the locations that the player can go to. Contains a method that returns the location of the player.
public class AllLocations {
    //fields
    //stores an array of the possible locations in the game
    Location possibleLocations[] = new Location[] {
        new Location(-1, -1, choseLocation()),
        new Location(0, -1, choseLocation()),
        new Location(1, -1, choseLocation()),
        new Location(-1, 0, choseLocation()),
        new Location(0, 0, choseLocation()),
        new Location(1, 0, choseLocation()),
        new Location(-1, 1, choseLocation()),
        new Location(0, 1, choseLocation()),
        new Location(1, 1, choseLocation())
    };

    //gets the location that the player is currently in and returns it
    public Location getLocation(Player player) {
        int j = 0;
        for(int i = 0; !(possibleLocations[i].panelX == player.getPanelX() && possibleLocations[i].panelY == player.getPanelY()); i++) {
            j++;
        }
        return possibleLocations[j];
    }

    //random number generator
    public static int choseLocation() {
        Random r = new Random();
        int number = r.nextInt(99) + 1;
        if (number >= 75) {
            return 2;
        }
        else {
            return 1;
        }

    }


}
