import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Sawyer Cole on 6/5/2017.
 */
public class Tree extends Item{
    int width;
    int height;
    public Tree() {
        super.coordinates = new Coordinates((int) (Math.round(Math.random() * 900)), (int) (Math.round(Math.random() * 900)));

        super.canPickUp = true;
        width = 15;
        height = 25;
    }


    public void organizeTrees(ArrayList<Tree> trees) {
        for (Tree tree: trees) {

        }
    }


    public void draw(Graphics pen) {
        pen.setColor(Color.GREEN);
        pen.fillRect(super.coordinates.x, super.coordinates.y, width, height);
        pen.setColor(Color.ORANGE);
        pen.fillRect((super.coordinates.x + width/2) - width/4, super.coordinates.y + height, width/2, height/2 );
    }
    public void pickUp() {
        System.out.println("You cant pick that up");
    }


}