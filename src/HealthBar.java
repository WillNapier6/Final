import java.awt.*;

/**
 * Created by Sawyer Cole on 6/12/2017.
 */
/**
 * HealthBar.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
public class HealthBar {
    //draws a visual representation of player health
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
