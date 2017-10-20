import javax.swing.*;
import java.awt.*;

/**
 * Created by Sawyer Cole on 9/28/2017.
 */
public class Shop {
    Button sell = new Button("sell");
    Button buy = new Button("buy");
    Button close = new Button("close");
    JPanel shop = new JPanel();
    JPanel centerPanel = new JPanel();
    public Shop() {
        shop.setLayout(new BorderLayout());
        shop.add(centerPanel, BorderLayout.CENTER);
        centerPanel.add(buy);
        centerPanel.add(sell);
        shop.add(close, BorderLayout.SOUTH);
    }
    public void displayShop(JFrame frame) {
        frame.add(shop);
        shop.setVisible(true);
    }
    public void hideShop(JFrame frame) {
        shop.setVisible(false);
        frame.remove(shop);
    }
}
