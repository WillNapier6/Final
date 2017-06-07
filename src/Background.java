import sun.print.BackgroundLookupListener;

/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import java.awt.*;
import java.util.ArrayList;

public class Background {
    Color[] basicColors = {Color.BLUE, Color.CYAN, Color.RED};
    Color[] presetColors = {basicColors[(int) (Math.random() * 3)], };
    Color backgroundColor;
    int amountOfTrees;
    boolean orginizeTrees;
    ArrayList<Tree> trees = new ArrayList<Tree>();

    public Background(int i) {
        if (i == 1) {
            setBasicBackground();
        }
        else if (i == 2){
            setForest();
        }
        for (int j = 0; j < amountOfTrees; j++) {
            trees.add(new Tree());
        }

    }


    public void drawBackground (DrawingPanel panel, Graphics pen) {
        panel.setBackground(backgroundColor);
        drawTree(pen, amountOfTrees, 15, 15);
    }
    public void setForest() {
        this.backgroundColor = Color.LIGHT_GRAY;
        amountOfTrees = 15;
        orginizeTrees = true;
    }

    public void setBasicBackground() {
        this.backgroundColor = presetColors[0];
        amountOfTrees = 2;
        orginizeTrees = false;
    }

    public void drawTree(Graphics pen, int amount, int width, int height) {


        for (Tree tree : trees) {
            tree.draw(pen);
        }

    }

}
