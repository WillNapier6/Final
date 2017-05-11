/**
 * Created by Sawyer Cole on 5/9/2017.
 */

public class AllLocations {
    Location possibleLocations[] = new Location[] {
        new Location(-1, -1, new Background(1)),
        new Location(0, -1, new Background(1)),
        new Location(1, -1, new Background(1)),
        new Location(-1, 0, new Background(1)),
        new Location(0, 0, new Background(1)),
        new Location(1, 0, new Background(1)),
        new Location(-1, 1, new Background(1)),
        new Location(0, 1, new Background(1)),
        new Location(1, 1, new Background(1))
    };

    public Location getLocation(Player player) {
        int j = 0;
        for(int i = 0; !(possibleLocations[i].panelX == player.getPanelX() && possibleLocations[i].panelY == player.getPanelY()); i++) {
            j++;
        }
        return possibleLocations[j];
    }


}
