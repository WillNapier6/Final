/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.applet.*;

public class GameBoard extends Applet implements KeyListener{
    DrawingPanel panel = new DrawingPanel(1000, 1000);
    Graphics pen = panel.getGraphics();
    Player player = new Player();

    Scanner console = new Scanner(System.in);
    Input input = new Input();

    AllLocations allLocations = new AllLocations();

    public void drawBoard () {
        Location location = allLocations.getLocation(player);
        player.drawPlayer(pen);
        location.drawLocation(panel, pen);

    }
    public void clearBoard() {

        panel.clear();
    }

    public void sleep(int time) {
        panel.sleep(time);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        drawBoard();
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            player.up(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.down(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.right(1);
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.left(1);
        }
        clearBoard();
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
