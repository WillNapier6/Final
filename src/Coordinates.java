/**
 * Created by Sawyer Cole on 6/7/2017.
 */
/**
 * Coordinates.java
 * Assignment: Final Project
 * Purpose: Through this project I apply the skills that I have learned throughout the year and create an original and unique project
 *
 * @version 5/9/17
 */
//Variable for efficiently storing the location of an item on the game board.
public class Coordinates {
    //fields
    int x;
    int y;
    //constructor
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //gets the distance between this coordinate and another using the distance formula, returns a double
    public double getDistance(int x, int y) {
        return Math.sqrt((this.x - x)* (this.x - x) + (this.y - y) * (this.y - y));
    }
}
