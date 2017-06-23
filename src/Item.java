import java.awt.*;

/**
 * Created by Sawyer Cole on 5/3/2017.
 */
/**
 * Item.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//The abstract template for Items. Contains draw and pick up methods.
public abstract class Item {
    //fields
    int itemId; //each item type has a unique ID
    int nourishment; //the amount of hunger an item restores when eaten
    int value;  //currently unused, will later be used to sell and buy things
    double size;    //the size of an item
    boolean canPickUp;  //whether or not you can pick up an item, currently true for all items
    boolean isEdible;   //whether or not an item is edible, currently only tru for berries
    Coordinates coordinates;    //the location of an item on the game board
    public abstract void pickUp(Inventory inventory, Location location); //the instructions for picking up each item time
    public abstract void draw(Graphics pen); //the instructions for drawing each item type

    //sets the item to be displayed in the inventory
    public void setSizeInventory(int i) {
        size = 1;
        coordinates.x = 100 + 60 * i + 12;
        coordinates.y = 805;
    }

    //sets the item to be displayed on the game board in a givenlocation
    public void setSizeGameBoard(Coordinates coordinates) {
        size = 1;
        this.coordinates.x = coordinates.x;
        this.coordinates.y = coordinates.y;
    }


}
