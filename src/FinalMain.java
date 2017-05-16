/**
 * Created by Sawyer Cole on 5/3/2017.
 */
import javafx.event.Event;
import javafx.scene.input.KeyEvent;

import java.awt.event.KeyListener;
import java.util.*;
import java.applet.*;
public class FinalMain extends Applet implements KeyListener{
    Player player = new Player();
    boolean playGame = true;
    Scanner console = new Scanner(System.in);
    Input input = new Input();
    GameBoard board = new GameBoard();
    AllLocations allLocations = new AllLocations();

    public static void main(String[] args) {

        while (playGame) {
            Location currentLocation = allLocations.getLocation(player);
            board.drawBoard(player, allLocations.getLocation(player));
            board.clearBoard(player, currentLocation);
        }

    }
    public FinalMain(){

    }

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {


        if(e.getKeyCode() == java.awt.event.KeyEvent.VK_UP) {
            player.up(1);
        }
        else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN) {
            player.down(1);
        }
        else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT) {
            player.right(1);
        }
        else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT) {
            player.right(1);
        }

    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {

    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }
}
