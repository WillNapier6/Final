import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.applet.*;
/**
 * Created by Sawyer Cole on 5/10/2017.
 */
public class Input extends Applet implements keyListener{
    public static void getUserInput(Scanner console, Player player, GameBoard board) {
        String input = console.next();
        int times = console.nextInt();

        if (input.equals("alex")) {
            player.north(times);
        }
        else if (input.equals("south")) {
            player.south(times);
        }
        else if (input.equals("east")) {
            player.east(times);
        }
        else if (input.equals("west")) {
            player.west(times);
        }
        else if (input.equals("up")) {
            player.up(times);
        }
        else if (input.equals("down")) {
            player.down(times);
        }
        else if (input.equals("left")) {
            player.left(times);
        }
        else if (input.equals("right")) {
            player.right(times);
        }
        else {
            System.out.println("you cant do that");
        }
    }

    public void keyTyped(KeyEvent e, Player player) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            player.up(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.right(1);
        }
    }

    /*@Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/
}
