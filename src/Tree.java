import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/5/2017.
 */
public class Tree extends Item{
    boolean canPickUp = false;
    int x;
    int y;
    int width;
    int height;
    public Tree() {
        this.x = (int) (Math.round(Math.random() * 900));
        this.y = (int) (Math.round(Math.random() * 900));
        width = 15;
        height = 25;
    }
    public void draw(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(this.x, this.y, width, height);
        pen.setColor(Color.ORANGE);
        pen.fillRect((this.x + width/2) - width/4, this.y + height, width/2, height/2 );
    }

    public void organizeTrees(ArrayList<Tree> trees) {
        for (Tree tree: trees) {

        }
    }


}
