import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/5/2017.
 */
public class Tree extends Item{

    int width;
    int height;
    public Tree(double size, int x, int y) {
        super.coordinates = new Coordinates(x, y);
        super.size = size;
        super.canPickUp = true;
        super.itemId = 1;
        super.isEdible = false;
        width = (int) Math.round(super.size * 16);
        height = (int) Math.round(super.size * 32);
    }

    public void update() {
        width = (int) Math.round(super.size * 16);
        height = (int) Math.round(super.size * 32);
    }


    public void draw(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(super.coordinates.x, super.coordinates.y, width, height);
        pen.setColor(Color.ORANGE);
        pen.fillRect((super.coordinates.x + width/2) - width/4, super.coordinates.y + height, width/2, height/2 );
    }
    public void pickUp(Inventory inventory, Location location) {
        System.out.println("You cant pick that up");
        inventory.add(this);
        location.items.remove(this);
    }


}
