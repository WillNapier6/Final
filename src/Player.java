/**
 * Created by Sawyer Cole on 5/3/2017.
 */

import java.awt.*;
import java.util.ArrayList;
/**
 * Player.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
public class Player {
    //fields
    private int hunger; //player's hunger, goes down over time, goes up when food is eaten
    private Coordinates coordinates; //Stores the player's location on the screen
    private int health; //player's health
    private int panelX; //stores the x coordinate of the panel the player is currently in
    private int panelY; //stores the y coordinate of the panel the player is currently in
    int width = 10;
    int height = 30;
    //draws the player onto the game board
    public void draw(Graphics pen) {
        pen.setColor(Color.PINK);
        pen.fillRect(coordinates.x, coordinates.y, width, height);
        pen.setColor(Color.LIGHT_GRAY);
        pen.drawString("X: " + (getX() - 500) + " Y: " + (getY() - 500) * -1, 20, 50);
    }

    //currently unused
    public void clearPlayer(Graphics pen, AllLocations allLocations, Player player) {
        pen.setColor((((allLocations.getLocation(player)).background).backgroundColor));
        pen.fillRect(coordinates.x, coordinates.y, width, height);
    }
    //creates a new player at (0, 0) in the middle of the screen
    public Player() {
        coordinates = new Coordinates(500, 500);
        panelX = 0;
        panelY = 0;
        hunger = 10;
        health = 10;
    }
    //sends the player to the panel directly upwards
    public void north(int x) {
        addPanelY(x);
        setY(900);
    }
    //sends the player to the panel directly downwards
    public void south(int x) {
        addPanelY(x * -1);
        setY(100);
    }
    //sends the player to the panel directly to the right
    public void east(int x) {
        addPanelX(x);
        setX(100);
    }
    //sends the player to the panel directly to the left
    public void west(int x) {
        addPanelX(x * -1);
        setX(900);
    }
    //moves the player up on the screen a given amount
    public void up(int y) {
        addY(y);
    }
    //moves the player down on the screen a given amount
    public void down(int y) {
        addY(y * -1);
    }
    //moves the player right on the screen a given amount
    public void right(int x) {
        addX(x);
    }
    //moves the player up left the screen a given amount
    public void left(int x) {
        addX(x * -1);
    }

    //adds an item to the specified inventory and removes it from the location given
    public void pickUpItem(Inventory inventory, ArrayList<Item> items, Location location) {
        Item pickUpItem = null;
        boolean itemToPickUp = false;
        double distance = 30000;
        for (Item item: items) {
            double distanceI = item.coordinates.getDistance(getX(), getY());
            if (distanceI < distance ) {
                distance = distanceI;
                if (distance <= 50 && item.canPickUp) {
                    pickUpItem = item;
                    itemToPickUp = true;
                }
            }
        }
        if (itemToPickUp) {


            pickUpItem.pickUp(inventory, location);

        }
        else {
            System.out.println("Nothing to pick up");
        }
    }
    //removes an item from the given inventory and adds it to the location given
    public void dropItem (Inventory inventory, Location location) {
        InventorySlot selectedSlot = inventory.inventory[inventory.getSelectedSlot()];

        selectedSlot.itemHolding.get(selectedSlot.itemHolding.size() - 1).setSizeGameBoard(coordinates);
        location.items.add(selectedSlot.itemHolding.get(selectedSlot.itemHolding.size() - 1));
        selectedSlot.itemHolding.remove(selectedSlot.itemHolding.get(selectedSlot.itemHolding.size() -1));
    }
    //removes item from the given inventory and adds it's nourishment value to the player's hunger
    public void eatItem (Inventory inventory) {
        InventorySlot selectedSlot = inventory.inventory[inventory.getSelectedSlot()];
        Item item = selectedSlot.itemHolding.get(selectedSlot.itemHolding.size() -1);
        if (item.isEdible) {
            addHunger(item.nourishment);
            selectedSlot.itemHolding.remove(item);
        }
    }

    // _______________________________ geters and setters ____________________________

    public void setPanelY(int x) {
        if (x <= 1 && x >= -1) {
            panelY = x;
        }
        else {
            System.out.println("You cant go there");
        }
    }
    public void setPanelX(int x) {
        if (x <= 1 && x >= -1) {
            panelX = x;
        }
        else {
            System.out.println("You cant go there");
        }
    }
    public void addPanelX(int x) {
        setPanelX(getPanelX() + x);
    }
    public void addPanelY (int x) {
        setPanelY(getPanelY() + x);
    }

    public void setX(int x) {
        coordinates.x = x;
        if(x >= 901) {
            east(1);
        }
        else if (x <= 99) {
            west(1);
        }
    }
    public void addX(int x) {
        setX(getX() + x);
    }
    public void addY(int y) {
        setY(getY() - y);
    }


    public void setY(int y) {
        coordinates.y = y;
        if(y >= 901) {
            south(1);
        }
        else if (y <= 99) {
            north(1);
        }
    }




    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
    public void addHunger(int i) {
        if (getHunger() + i <= 10) {
            setHunger(getHunger() + i);
        }
        else {
            setHunger(10);
        }
    }



    public void setHealth(int health) {
        if (this.health <= 10 && health > this.health) {
            this.health = health;
        }
        else if (health < this.health) {
            this.health = health;
        }
        else {
            this.health = 10;
        }
    }
    public int getX(){
        return coordinates.x;
    }
    public int getY(){
        return coordinates.y;
    }
    public int getPanelX() {
        return panelX;
    }
    public int getPanelY() {
        return panelY;
    }
    public int getHunger() {
        return hunger;
    }
    public int getHealth() {
        return health;
    }
}
