/**
 * Created by Sawyer Cole on 5/4/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard extends JFrame implements ActionListener, KeyListener{
    DrawingPanel panel = new DrawingPanel(1000, 1000);
    JFrame f = new JFrame();
    Graphics pen = panel.getGraphics();
    Player player = new Player();
    Inventory inventory = new Inventory();
    Timer t = new Timer(2, this);
    int velX, velY;


    Scanner console = new Scanner(System.in);
    Input input = new Input();

    AllLocations allLocations = new AllLocations();
    public GameBoard () {
        f.setSize(10, 10);
        f.setVisible(true);
        f.setTitle("Game Board");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        t.start();
        f.addKeyListener(this);
        f.setFocusable(true);
        f.setFocusTraversalKeysEnabled(true);
        drawBoard();
    }
    public void drawBoard () {
        Location location = allLocations.getLocation(player);
        player.draw(pen);
        inventory.draw(pen);
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
            velY = 2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            velY = -2;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 2;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = -2;

        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.pickUpItem(inventory, allLocations.getLocation(player).items);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            velY = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            velY = 0;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            velX = 0;

        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            velX = 0;

        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        clearBoard();
        player.up(velY);
        player.right(velX);
        drawBoard();
    }
}
