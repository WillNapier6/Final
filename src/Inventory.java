import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/7/2017.
 */
public class Inventory {
    int size;
    int numberOfItems;
    Item[] inventory;
    public void draw(Graphics pen){

        for (int j = 0; j < inventory.length; j++) {
            pen.setColor(Color.GRAY);
            pen.fillRect(100 + 30 * j, 800, 20, 20);
        }
        for (int i = 0; i < numberOfItems; i++) {
            inventory[i].setSizeInventory(i);
            inventory[i].draw(pen);
        }
    }
    public Inventory(int size) {
        this.size = size;
        numberOfItems = 0;
        inventory = new Item[size];
    }
}
