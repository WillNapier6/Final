import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/5/2017.
 */
/**
 * Tree.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//A type of item. Doesn't do much right now. In the future you will not be able to walk through it.
public class Tree extends Item{
    //fields
    int width;
    int height;
    //constructs tree
    public Tree(double size, int x, int y) {
        super.coordinates = new Coordinates(x, y);
        super.size = size;
        super.canPickUp = true;
        super.itemId = 1;
        super.isEdible = false;
        width = (int) Math.round(super.size * 16);
        height = (int) Math.round(super.size * 32);
    }

    //draws tree
    public void draw(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(super.coordinates.x, super.coordinates.y, width, height);
        pen.setColor(Color.ORANGE);
        pen.fillRect((super.coordinates.x + width/2) - width/4, super.coordinates.y + height, width/2, height/2 );
    }

    //picks up tree, adds to specified inventory, removes from specified location
    public void pickUp(Inventory inventory, Location location) {
        System.out.println("You cant pick that up");
        inventory.add(this);
        location.items.remove(this);
    }


}
