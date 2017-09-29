/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import com.sun.xml.internal.ws.api.server.Adapter;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * GameBoard.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//The main class in which everything happens. Creates a bunch of game objects which all make the game function.
public class GameBoard extends JFrame implements ActionListener, KeyListener{

    //fields
    DrawingPanel panel = new DrawingPanel(1000, 1000); //creates JPanel
    Graphics pen = panel.getGraphics(); //creates graphics object pen, used to draw on drawing panel
    Player player = new Player(); //creates the player
    Inventory inventory = new Inventory(5); //begging inventory at bottom of the screen
    HungerBar hungerBar = new HungerBar(); //Hunger Display
    HealthBar healthBar = new HealthBar(); //Health Display
    Timer t = new Timer(2, this); //Initializes game timer
    int gameTick = 0; //records game time
    int velX, velY; //velocity of the player
    Input input = new Input(); //allows option of enabling console comands
    AllLocations allLocations = new AllLocations(); //An array list of the locations on the game board
    Shop shop = new Shop();


    //constructor, starts  the timer and implements key listener.
    public GameBoard () {
        panel.frame.addKeyListener(this);
        panel.frame.setTitle("The Lousy Adventures Of Will Napkin");
        t.start();
        drawBoard();
        panel.frame.setResizable(false);
        panel.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();

    }

    //draws board, each item
    public void drawBoard () {
        Location location = allLocations.getLocation(player);
        player.draw(pen);
        inventory.draw(pen);
        hungerBar.draw(pen, player);
        healthBar.draw(pen, player);
        location.drawLocation(panel, pen);
    }
    //clears board
    public void clearBoard() {
        panel.clear();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //unused, required implementation
    }
    //KeyListener tracks arrow keys and action keys.
    @Override
    public void keyPressed(KeyEvent e) {
        boolean shopDisplayed = false;
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            velY = 2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            velY = -2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 2;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = -2;

        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.pickUpItem(inventory, allLocations.getLocation(player).items, allLocations.getLocation(player));
        }
        else if(e.getKeyCode() == KeyEvent.VK_1) {
            inventory.inventory[0].select();
            inventory.inventory[1].unselect();
            inventory.inventory[2].unselect();
            inventory.inventory[3].unselect();
            inventory.inventory[4].unselect();
        }
        else if(e.getKeyCode() == KeyEvent.VK_2) {
            inventory.inventory[0].unselect();
            inventory.inventory[1].select();
            inventory.inventory[2].unselect();
            inventory.inventory[3].unselect();
            inventory.inventory[4].unselect();
        }
        else if(e.getKeyCode() == KeyEvent.VK_3) {
            inventory.inventory[0].unselect();
            inventory.inventory[1].unselect();
            inventory.inventory[2].select();
            inventory.inventory[3].unselect();
            inventory.inventory[4].unselect();
        }
        else if(e.getKeyCode() == KeyEvent.VK_4) {
            inventory.inventory[0].unselect();
            inventory.inventory[1].unselect();
            inventory.inventory[2].unselect();
            inventory.inventory[3].select();
            inventory.inventory[4].unselect();
        }
        else if(e.getKeyCode() == KeyEvent.VK_5) {
            inventory.inventory[0].unselect();
            inventory.inventory[1].unselect();
            inventory.inventory[2].unselect();
            inventory.inventory[3].unselect();
            inventory.inventory[4].select();
        }
        else if(e.getKeyCode() == KeyEvent.VK_D) {
            player.dropItem(inventory, allLocations.getLocation(player));
        }
        else if (e.getKeyCode() == KeyEvent.VK_E) {
            player.eatItem(inventory);
        }
        else if (e.getKeyCode() == KeyEvent.VK_S) {
            shop.displayShop(panel.frame);
            t.stop();
            panel.panel.setVisible(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            shop.hideShop(panel.frame);
            panel.panel.setVisible(true);
            t.start();
        }
        else {
            velX = 0;
            velY = 0;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
       if(e.getKeyCode() == KeyEvent.VK_UP) {
            velY = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            velY = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 0;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = 0;

        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        clearBoard();
        player.up(velY);
        player.right(velX);
        if (gameTick % 2000 == 0 && player.getHunger() != 0) {
            player.setHunger(player.getHunger() - 1);
        }
        if (gameTick % 2000 == 0 && player.getHunger() <= 0) {
            player.setHealth(player.getHealth() - 1);
        }
        if (gameTick % 2000 == 0 && player.getHunger() == 10) {
            player.setHealth(player.getHealth() + 1);
        }
        if (player.getHealth() == 0) {
            System.out.println("GAME OVER");
        }
        drawBoard();
        gameTick++;
    }


}
