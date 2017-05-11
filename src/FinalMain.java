/**
 * Created by Sawyer Cole on 5/3/2017.
 */
import javafx.event.Event;
import javafx.scene.input.KeyEvent;

import java.util.*;
import java.applet.*;
public class FinalMain {
    public static void main(String[] args) {
        Player player = new Player();
        boolean playGame = true;
        Scanner console = new Scanner(System.in);
        Input input = new Input();
        GameBoard board = new GameBoard();
        AllLocations allLocations = new AllLocations();

        while (playGame) {
            Location currentLocation = allLocations.getLocation(player);
            board.drawBoard(player, allLocations.getLocation(player));
            input.getUserInput(console, player, board);
            board.clearBoard(player, currentLocation);
        }
    }

}
