import sun.print.BackgroundLookupListener;

/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import java.awt.*;
public class Background {
    Color[] basicColors = {Color.BLUE, Color.CYAN, Color.RED};
    Color[] presetColors = {basicColors[(int) (Math.random() * 3)]};
    Color backgroundColor;
    public Background(int i) {

        this.backgroundColor = presetColors[i - 1];
    }

    public void drawBackground (DrawingPanel panel) {
        panel.setBackground(backgroundColor);
    }

}
