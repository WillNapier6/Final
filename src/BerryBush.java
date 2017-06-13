import java.awt.*;
import java.util.Random;

/**
 * Created by Sawyer Cole on 6/9/2017.
 */
public class BerryBush extends Item{
    int width;
    int height;
    Color lime = new Color(51, 255, 51);
    boolean hasBerries = true;
    //Random r = new Random();

    public BerryBush(double size, int x, int y) {
        super.coordinates = new Coordinates(x, y);
        super.size = size;
        super.canPickUp = true;
        super.itemId = 3;
        super.isEdible = false;
        width = (int) Math.round(super.size * 32);
        height = (int) Math.round(super.size * 32);
    }
    public void draw(Graphics pen) {
        pen.setColor(lime);
        pen.fillRect(super.coordinates.x, super.coordinates.y, width, height);
        if (hasBerries) {
            pen.setColor(Color.RED);
            pen.fillOval(super.coordinates.x + 5,super.coordinates.y + 5, 5, 5);
            pen.fillOval(super.coordinates.x + 10,super.coordinates.y + 25, 5, 5);
            pen.fillOval(super.coordinates.x + 20,super.coordinates.y + 10, 5, 5);
            pen.fillOval(super.coordinates.x + 25,super.coordinates.y + 25, 5, 5);
        }
    }

    public void pickUp(Inventory inventory, Location location) {
        if (hasBerries) {
            inventory.add(new Berry(1, 1, 1));
            hasBerries = false;
        }
    }

    public void update() {
        width = (int) Math.round(super.size * 32);
        height = (int) Math.round(super.size * 32);
    }
}
