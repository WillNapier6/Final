import java.awt.*;

/**
 * Created by Sawyer Cole on 6/9/2017.
 */
/**
 * HungerBar.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
public class HungerBar{
    //draws a visual representation of player hunger
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
