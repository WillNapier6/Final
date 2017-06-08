import java.awt.*;

/**
 * Created by Sawyer Cole on 5/3/2017.
 */
public abstract class Item extends GameObject {
    int nourishment;
    int value;
    boolean canPickUp;
    Coordinates coordinates;
    public abstract void pickUp();


}
