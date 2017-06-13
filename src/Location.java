/**
 * Created by Sawyer Cole on 5/3/2017.
 */
import java.awt.*;
import java.util.*;

public class Location {
    int panelX;
    int panelY;
    int itemCount;
    Background background;
    ArrayList<Item> items = new ArrayList<Item>();

    public Location(int panelX, int panelY, int type) {
        this.panelX = panelX;
        this.panelY = panelY;
        this.background = new Background(type);
        if (type == 1) {
            addTrees(4);
            addCoins(10);
            addBerryBushes(5);
        }
        else if (type == 2) {
            addTrees(15);
            addCoins(5);
            addBerryBushes(10);
        }
    }

    public void drawLocation(DrawingPanel panel, Graphics pen) {
        background.drawBackground(panel, pen);
        writeLocation(pen);
        pen.setColor(Color.MAGENTA);
        pen.drawRect(50, 50, 900, 900);
        for (Item item: items) {
            item.draw(pen);
        }
    }
    public void writeLocation(Graphics pen) {
        pen.setColor(Color.LIGHT_GRAY);
        pen.drawString("X: " + panelX + " Y: " + panelY, 20, 20);

    }
    public void addTrees (int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(new Tree(1, (int) (Math.round(Math.random() * 900)), (int) (Math.round(Math.random() * 900))));
        }
    }
    public void addCoins (int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(new Coin(1, (int) (Math.round(Math.random() * 900)), (int) (Math.round(Math.random() * 900))));
        }
    }
    public void addBerryBushes (int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(new BerryBush(1, (int) (Math.round(Math.random() * 900)), (int) (Math.round(Math.random() * 900))));
        }
    }




}
