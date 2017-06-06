/**
 * Created by Sawyer Cole on 5/3/2017.
 */
import java.awt.*;
public class Location {
    int panelX;
    int panelY;
    int itemCount;
    Background background;

    public Location(int panelX, int panelY, Background background) {
        this.panelX = panelX;
        this.panelY = panelY;
        this.background = background;
    }

    public void drawLocation(DrawingPanel panel, Graphics pen) {
        background.drawBackground(panel, pen);
        writeLocation(pen);
        pen.drawRect(50, 50, 900, 900);
    }
    public void writeLocation(Graphics pen) {
        pen.setColor(Color.LIGHT_GRAY);
        pen.drawString("X: " + panelX + " Y: " + panelY, 20, 20);

    }




}
