import java.awt.*;

/**
 * Created by Sawyer Cole on 6/5/2017.
 */
public class Tree extends Item{
    boolean canPickUp = false;
    int x;
    int y;
    int width;
    int height;
    public void draw(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(this.x, this.y, width, height);
        pen.setColor(Color.ORANGE);
        pen.fillRect((this.x + width/2) - width/4, this.y + height, width/2, height/2 );
    }
    public Tree() {
        x = (int) (Math.round(Math.random()) * 900);
        y = (int) (Math.round(Math.random()) * 900);
        width = 15;
        height = 25;
    }
}
