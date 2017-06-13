import java.awt.*;

/**
 * Created by Sawyer Cole on 6/9/2017.
 */
public class HungerBar{
    public void draw(Graphics pen, Player player) {
        Color lightBrown = new Color(255, 128, 0);
        for (int i = 0; i < 5; i++) {
            pen.setColor(Color.RED);
            pen.fillRect(700 + i * 40, 30, 30, 30);
        }
        for (int i = 0; i < player.getHunger(); i++) {
            pen.setColor(lightBrown);
            pen.fillRect(700 + i * 15 + i/2 * 10, 30, 15, 30);
        }
    }
}
