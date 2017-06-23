import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.applet.*;
/**
 * Created by Sawyer Cole on 5/10/2017.
 */
/**
 * Input.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//currently unused. Was used for getting console commands.
public class Input {
    //currently unused. Could be used to implement console commands
    public static void getUserInput(Scanner console, Player player, GameBoard board) {
        String input = console.next();
        int times = console.nextInt();

        if (input.equals("north")) {
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




}
