import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/8/2017.
 */
public class InventorySlot{
    ArrayList<Item> itemHolding = new ArrayList<Item>();
    int holdingId;
    boolean isSelected = false;

    public void draw(Graphics pen, int i) {
        pen.setColor(Color.LIGHT_GRAY);
        if (isSelected) {
            pen.setColor(Color.WHITE);
        }
        pen.fillRect(100 + 60 * i, 800, 50, 50);

        if (itemHolding.size() > 0) {
            itemHolding.get(0).setSizeInventory(i);
            itemHolding.get(0).draw(pen);
            pen.setColor(Color.BLACK);
            pen.drawString("" + itemHolding.size(), 100 + 60 * i, 810);
        }
    }
    public boolean add(Item item) {
        if (itemHolding.size() <= 0) {
            itemHolding.add(item);
            holdingId = item.itemId;
            return true;
        }
        else if (itemHolding.size() > 0 && itemHolding.size() < 16 && item.itemId == holdingId) {
            itemHolding.add(item);
            return true;
        }
        else {
            System.out.println("Cant add to inventory");
            return false;
        }
    }

    public void select() {
        isSelected = true;
    }
    public void unselect() {
        isSelected = false;
    }

}
