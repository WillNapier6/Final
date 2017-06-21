import java.awt.*;

/**
 * Created by Sawyer Cole on 5/3/2017.
 */
public abstract class Item {
    int itemId;
    int nourishment;
    int value;
    double size;
    boolean canPickUp;
    boolean isEdible;
    Coordinates coordinates;
    public abstract void pickUp(Inventory inventory, Location location);
    public abstract void draw(Graphics pen);

    public void setSizeInventory(int i) {
        size = 1;
        coordinates.x = 100 + 60 * i + 12;
        coordinates.y = 805;
    }
    public void setSizeGameBoard(Coordinates coordinates) {
        size = 1;
        this.coordinates.x = coordinates.x;
        this.coordinates.y = coordinates.y;
    }


}
