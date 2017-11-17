/**
 * Created by Sawyer Cole on 5/3/2017.
 */
import javafx.event.Event;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.applet.*;
/**
 * FinalMain.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *.lll
 * @version 5/9/17
 */
//contains main method
public class FinalMain extends JFrame{
    public static void main(String[] args) {
        //creates a new game board
        new FinalMain();

    }
    GameBoard board = new GameBoard();

    public FinalMain() {
        add(board);
        setSize(1000, 1000);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("The Lousy Adventures of Will Napkin");
        
    }


}
