import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/7/2017.
 */
public class Inventory {
    ArrayList<Item> inventory = new ArrayList<Item>();
    public void draw(Graphics pen){
        for (Item item: inventory) {
            int i = 1;
            item.size = .5;
            pen.setColor(Color.GRAY);
            pen.fillRect(100 + 20 * i, 800, 20, 20);
        }
    }
}
