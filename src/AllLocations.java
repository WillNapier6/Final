/**
 * Created by Sawyer Cole on 5/9/2017.
 */
import java.util.*;
public class AllLocations {
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

    public Location getLocation(Player player) {
        int j = 0;
        for(int i = 0; !(possibleLocations[i].panelX == player.getPanelX() && possibleLocations[i].panelY == player.getPanelY()); i++) {
            j++;
        }
        return possibleLocations[j];
    }

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
