import sun.print.BackgroundLookupListener;

/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import java.awt.*;
import java.util.ArrayList;

public class Background {
    //fields
    Color veryLightGreen = new Color(209, 255, 209);
    Color[] basicColors = {Color.BLUE, Color.CYAN, veryLightGreen};
    Color[] presetColors = {basicColors[(int) (Math.random() * 3)], };
    Color backgroundColor;
    Color brown = new Color(153, 76, 0);
    int amountOfTrees;

    //constructor chooses between 2 background presets
    public Background(int i) {
        if (i == 1) {
            setBasicBackground();
        }
        else if (i == 2){
            setForest();
        }


    }

    //draws background
    public void drawBackground(DrawingPanel panel, Graphics pen) {
        panel.setBackground(backgroundColor);
        //drawTree(pen, amountOfTrees, 15, 15);
    }
    //forest preset
    public void setForest() {
        this.backgroundColor = brown;
        amountOfTrees = 15;
    }
    //not forest preset
    public void setBasicBackground() {
        this.backgroundColor = presetColors[0];
        amountOfTrees = 2;
    }



}
