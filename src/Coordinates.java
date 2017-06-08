/**
 * Created by Sawyer Cole on 6/7/2017.
 */
public class Coordinates {
    int x;
    int y;
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double getDistance(int x, int y) {
        return Math.sqrt((this.x - x)* (this.x - x) + (this.y - y) * (this.y - y));
    }
}
