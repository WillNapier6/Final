import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/8/2017.
 */
/**
 * InventorySlot.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//A single inventory unit. Stores up to 16 of a single item type.
public class InventorySlot{
    //fields
    ArrayList<Item> itemHolding = new ArrayList<Item>(); //holds up to 16 of a single type of item
    int holdingId;
    boolean isSelected = false;

    //draws inventory slot
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
    //adds an item to this inventory slot, returns true if successfully added otherwise returns false
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
    //selects this inventory slot
    public void select() {
        isSelected = true;
    }

    //unselects this inventory slot
    public void unselect() {
        isSelected = false;
    }

}
