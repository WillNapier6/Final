/**
 * Created by Sawyer Cole on 5/4/2017.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GameBoard.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//Is the main object that contains all the information and records player input and draws the game board accordingly.
public class GameBoard extends JPanel implements ActionListener, KeyListener{

    //fields
    //private DrawingPanel panel = new DrawingPanel(1000, 1000); //creates JPanel
    //private Graphics pen = panel.getGraphics(); //creates graphics object pen, used to draw on drawing panel
    private Player player = new Player(); //creates the player
    private Inventory inventory = new Inventory(5); //begging inventory at bottom of the screen
    private HungerBar hungerBar = new HungerBar(); //Hunger Display
    private HealthBar healthBar = new HealthBar(); //Health Display
    private Timer t = new Timer(2, this); //Initializes game timer
    private int gameTick = 0; //records game time
    private int velX, velY; //velocity of the player
    //Input input = new Input(); //allows option of enabling console comands
    private AllLocations allLocations = new AllLocations(); //An array list of the locations on the game board
    private Shop shop = new Shop();
    private Toolkit tk = Toolkit.getDefaultToolkit();
    Graphics pen = this.getGraphics();


    //constructor, starts  the timer and implements key listener.
    public GameBoard () {
        addKeyListener(this);
        setVisible(true);
        setOpaque(true);
        //pen.setColor(Color.BLUE);
        setBackground(Color.BLUE);
        t.start();
        repaint();


    }

    //draws board, each item
    public void paint() {

        Location location = allLocations.getLocation(player);
        pen.setColor(location.background.backgroundColor);
        this.setBackground(Color.BLACK);
        player.draw(pen);
        inventory.draw(pen);
        hungerBar.draw(pen, player);
        healthBar.draw(pen, player);
        location.drawLocation(this, pen);

    }
    //clears board
    /*public void clearBoard() {
        panel.clear();
    }*/

    @Override
    public void keyTyped(KeyEvent e) {
        //unused, required implementation
    }
    //KeyListener tracks arrow keys and action keys.
    @Override
    public void keyPressed(KeyEvent e) {
        boolean shopDisplayed = false;
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            velY = 8;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            velY = -8;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 8;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = -8;

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
        /*else if (e.getKeyCode() == KeyEvent.VK_S) {
            shop.displayShop(this.frame);
            t.stop();
            panel.panel.setVisible(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            shop.hideShop(panel.frame);
            panel.panel.setVisible(true);
            t.start();
        }*/
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
        repaint();
        gameTick++;
    }


}
