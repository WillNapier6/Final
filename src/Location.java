/**
 * Created by Sawyer Cole on 5/3/2017.
 */
import java.awt.*;
import java.util.*;
/**
 * Location.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//A panel of the game board. Contains all the items in that panel, and draws them in it's draw method.
public class Location {
    //fields
    int panelX;
    int panelY;
    Background background;
    ArrayList<Item> items = new ArrayList<Item>(); //stores the items in the location

    //constructor, creates a new location panel at the given location with a given preset
    public Location(int panelX, int panelY, int type) {
        this.panelX = panelX;
        this.panelY = panelY;
        this.background = new Background(type);
        if (type == 1) {
            addTrees(4);
            addCoins(10);
            addBerryBushes(5);
        }
        else if (type == 2) {
            addTrees(15);
            addCoins(5);
            addBerryBushes(10);
        }
    }

    //instructions for drawing the location, draws the background and each item stored in this location
    public void drawLocation(DrawingPanel panel, Graphics pen) {
        background.drawBackground(panel, pen);
        writeLocation(pen);
        for (Item item: items) {
            item.draw(pen);
        }
    }

    //writes the coordinates of this location in the top left corner of the panel, used for debugging
    public void writeLocation(Graphics pen) {
        pen.setColor(Color.LIGHT_GRAY);
        pen.drawString("X: " + panelX + " Y: " + panelY, 20, 20);

    }
    //adds a given amount of trees to this location with random coordinates
    public void addTrees (int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(new Tree(1, (int) (Math.round(Math.random() * 900)), (int) (Math.round(Math.random() * 900))));
        }
    }
    //adds a given amount of coins to this location with random coordinates
    public void addCoins (int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(new Coin(1, (int) (Math.round(Math.random() * 900)), (int) (Math.round(Math.random() * 900))));
        }
    }
    //adds a given amount of trees to BerryBushes location with random coordinates
    public void addBerryBushes (int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(new BerryBush(1, (int) (Math.round(Math.random() * 900)), (int) (Math.round(Math.random() * 900))));
        }
    }




}
