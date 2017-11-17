import java.awt.*;

/**
 * Created by Sawyer Cole on 6/9/2017.
 */
/**
 * Berry.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
/* A type of item. Is edible and restores hunger to the user when eaten.
    Can only be obtained by picking a berry bush.
 */
public class Berry extends Item{
    //fields
    int width;
    int height;
    //constructor
    public Berry(double size, int x, int y) {
        super.coordinates = new Coordinates(x, y);
        super.size = size;
        super.canPickUp = true;
        super.itemId = 4;
        super.nourishment = 4;
        super.isEdible = true;
        width = (int) Math.round(super.size * 32);
        height = (int) Math.round(super.size * 32);
    }

    //draws Berry
    public void draw(Graphics pen) {
        pen.setColor(Color.RED);
        pen.fillOval(super.coordinates.x + 5,super.coordinates.y + 5, 5, 5);
        pen.fillOval(super.coordinates.x + 10,super.coordinates.y + 25, 5, 5);
        pen.fillOval(super.coordinates.x + 20,super.coordinates.y + 10, 5, 5);
        pen.fillOval(super.coordinates.x + 25,super.coordinates.y + 25, 5, 5);
    }

    //pick up method
    public void pickUp(Inventory inventory, Location location) {
        inventory.add(this);
        location.items.remove(this);
    }

}
