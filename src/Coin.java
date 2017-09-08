import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/8/2017.
 */
/**
 * Coin.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
/* Currently useless item. In the future it may be worth value which it can be sold for at the shop.

*/
public class Coin extends Item {
    //field
    int width;
    int height;
    //constructs coin
    public Coin(double size, int x, int y) {
        super.coordinates = new Coordinates(x, y);
        super.size = size;
        super.canPickUp = true;
        super.itemId = 2;
        super.isEdible = false;
        width = (int) Math.round(super.size * 16);
        height = (int) Math.round(super.size * 16);
    }
    //draw method
    public void draw(Graphics pen) {
        pen.setColor(Color.YELLOW);
        pen.fillOval(super.coordinates.x, super.coordinates.y,width, height);
    }

    //pick up method, removes from gameboard, adds to inventory
    public void pickUp(Inventory inventory, Location location) {
        System.out.println("You can pick that up");
        inventory.add(this);
        location.items.remove(this);
    }
}
