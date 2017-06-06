import sun.print.BackgroundLookupListener;

/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import java.awt.*;
public class Background {
    Color[] basicColors = {Color.BLUE, Color.CYAN, Color.RED};
    Color[] presetColors = {basicColors[(int) (Math.random() * 3)], };
    Color backgroundColor;

    int amountOfTrees;
    public Background(int i) {
        if (i == 1) {
            setBasicBackground();
        }
        else if (i == 2){
            setForest();
        }
    }

    public void drawBackground (DrawingPanel panel, Graphics pen) {
        panel.setBackground(backgroundColor);
        drawTree(pen, amountOfTrees, 15, 15);
    }
    public void setForest() {
        this.backgroundColor = Color.LIGHT_GRAY;
        amountOfTrees = 15;
    }

    public void setBasicBackground() {
        this.backgroundColor = presetColors[0];
        amountOfTrees = 2;
    }

    public void drawTree(Graphics pen, int amount, int width, int height) {


        for(int i = 1; i <= amount; i++) {
            new Tree().draw(pen);

        }
    }

}
