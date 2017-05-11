/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import java.awt.*;
public class GameBoard {
    DrawingPanel panel = new DrawingPanel(1000, 1000);
    Graphics pen = panel.getGraphics();

    public void drawBoard (Player player, Location location) {
        player.drawPlayer(pen);
        location.drawLocation(panel, pen);

    }
    public void clearBoard(Player player, Location location) {

        panel.clear();
    }
}
