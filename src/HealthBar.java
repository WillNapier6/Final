import java.awt.*;

/**
 * Created by Sawyer Cole on 6/12/2017.
 */
public class HealthBar {
    public void draw(Graphics pen, Player player) {
        Color lightPink = new Color(255, 204, 229);
        for (int i = 0; i < 5; i++) {
            pen.setColor(Color.RED);
            pen.fillRect(100 + i * 40, 30, 30, 30);
        }
        for (int i = 0; i < player.getHealth(); i++) {
            pen.setColor(lightPink);
            pen.fillRect(100 + i * 15 + i/2 * 10, 30, 15, 30);
        }
    }
}
