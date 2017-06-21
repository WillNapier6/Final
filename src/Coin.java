import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/8/2017.
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
    public void draw(Graphics pen) {
        pen.setColor(Color.YELLOW);
        pen.fillOval(super.coordinates.x, super.coordinates.y,width, height);
    }

    public void pickUp(Inventory inventory, Location location) {
        System.out.println("You can pick that up");
        inventory.add(this);
        location.items.remove(this);
    }
}
