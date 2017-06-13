import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/7/2017.
 */
public class Inventory {
    int size;
    int numberOfItems;
    InventorySlot[] inventory;
    public void draw(Graphics pen){
        int i = 0;
        for (InventorySlot inventorySlot: inventory) {
            inventorySlot.draw(pen, i);
            i++;
        }
    }
    public Inventory(int size) {
        this.size = size;
        inventory = new InventorySlot[size];
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new InventorySlot();
        }
    }
    public void add(Item item) {
        boolean didAdd = false;
        for(int i = 0; i < inventory.length && !didAdd; i++) {
            didAdd = inventory[i].add(item);
        }
        if (!didAdd) {
            System.out.println("Inventory full");
        }
    }
    public  void remove(Item item) {
        boolean didRemove = false;

    }
    public int getSelectedSlot() {
        int i = 0;
        for (InventorySlot slot: inventory) {
            if(slot.isSelected) {
                return i;
            }
            i++;
        }
        return 0;
    }
}
