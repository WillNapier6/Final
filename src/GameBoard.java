/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class GameBoard extends JPanel implements ActionListener, KeyListener{
    DrawingPanel panel = new DrawingPanel(1000, 1000);
    JTextField keyL = new JTextField(80);
    Graphics pen = panel.getGraphics();
    Player player = new Player();
    Timer t = new Timer(5, this);
    int velX, velY;


    Scanner console = new Scanner(System.in);
    Input input = new Input();

    AllLocations allLocations = new AllLocations();
    public GameBoard () {
        t.start();
        keyL.addKeyListener(this);
        keyL.setFocusable(true);
        keyL.setFocusTraversalKeysEnabled(true);
        drawBoard();
    }
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

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            velX = 0;
            velY = 2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = -2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 2;
            velY = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = -2;
            velY = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        clearBoard();
        player.up(velY);
        player.right(velX);
        drawBoard();
    }
}
