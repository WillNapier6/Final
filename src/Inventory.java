import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/7/2017.
 */
public class Inventory {
    ArrayList<Item> inventory = new ArrayList<Item>();
    public void draw(Graphics pen){
        int i = 0;
        for (Item item: inventory) {


            pen.setColor(Color.GRAY);
            pen.fillRect(100 + 30 * i, 800, 20, 20);
            item.makeInventory(i);
            item.draw(pen);
            i++;
        }
    }
}
