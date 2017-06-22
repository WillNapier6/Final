import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/7/2017.
 */
/**
 * Inventory.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
public class Inventory {
    int size;
    int numberOfItems;
    InventorySlot[] inventory;
    //draws a visual representation of the items in the player's inventory
    public void draw(Graphics pen){
        int i = 0;
        for (InventorySlot inventorySlot: inventory) {
            inventorySlot.draw(pen, i);
            i++;
        }
    }
    //constructs a new inventory made up of a given number of inventory slots
    public Inventory(int size) {
        this.size = size;
        inventory = new InventorySlot[size];
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = new InventorySlot();
        }
    }
    //adds an item to the inventory providing that it is valid
    public void add(Item item) {
        boolean didAdd = false;
        for(int i = 0; i < inventory.length && !didAdd; i++) {
            didAdd = inventory[i].add(item);
        }
        if (!didAdd) {
            System.out.println("Inventory full");
        }
    }

    //returns the inventory slot currently selected by the player
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
