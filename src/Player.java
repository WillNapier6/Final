/**
 * Created by Sawyer Cole on 5/3/2017.
 */

import java.awt.*;
import java.util.ArrayList;

public class Player extends GameObject{
    int hunger;
    private Coordinates coordinates;

    private int panelX;
    private int panelY;
    int width = 10;
    int height = 30;
    public void draw(Graphics pen) {
        pen.setColor(Color.PINK);
        pen.fillRect(coordinates.x, coordinates.y, width, height);
        pen.setColor(Color.LIGHT_GRAY);
        pen.drawString("X: " + (getX() - 500) + " Y: " + (getY() - 500) * -1, 20, 50);
    }
    public void clearPlayer(Graphics pen, AllLocations allLocations, Player player) {
        pen.setColor((((allLocations.getLocation(player)).background).backgroundColor));
        pen.fillRect(coordinates.x, coordinates.y, width, height);
    }

    public Player() {
        coordinates = new Coordinates(500, 500);
        panelX = 0;
        panelY = 0;
    }
    public void north(int x) {
        addPanelY(x);
        setY(880);
    }
    public void south(int x) {
        addPanelY(x * -1);
        setY(120);
    }
    public void east(int x) {
        addPanelX(x);
        setX(120);
    }
    public void west(int x) {
        addPanelX(x * -1);
        setX(880);
    }
    public void up(int y) {
        addY(y);
    }
    public void down(int y) {
        addY(y * -1);
    }
    public void right(int x) {
        addX(x);
    }
    public void left(int x) {
        addX(x * -1);
    }

    public int getPanelX() {
        return panelX;
    }
    public int getPanelY() {
        return panelY;
    }

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
    public int getX(){
        return coordinates.x;
    }
    public int getY(){
        return coordinates.y;
    }
    public void setX(int x) {
        coordinates.x = x;
        if(x >= 900) {
            east(1);
        }
        else if (x <= 100) {
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
        if(y >= 900) {
            south(1);
        }
        else if (y <= 100) {
            north(1);
        }
    }
    public void pickUpItem(ArrayList<Item> items) {

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
            pickUpItem.pickUp();
        }
        else {
            System.out.println("Nothing to pick up");
        }
    }

}
