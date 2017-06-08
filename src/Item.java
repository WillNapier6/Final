import java.awt.*;

/**
 * Created by Sawyer Cole on 5/3/2017.
 */
public abstract class Item extends GameObject {
    int nourishment;
    int value;
    double size;
    boolean canPickUp;
    Coordinates coordinates;
    public abstract void pickUp(Inventory inventory, Location location);
    public abstract void update();
    public void setSizeInventory(int i) {
        size = 0.8;
        coordinates.x = 100 + 30 * i;
        coordinates.y = 800;
        update();
    }


}
