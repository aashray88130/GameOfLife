package conwaygame;
/*
 * Class used to create Buttons to be used on each page of the driver.
 */
import java.awt.Color;

public class Button extends Rectangle {
    public String name;

    public Button(int x, int y, int halfWidth, int halfHeight, String name, boolean filled) {
        super(x, y, halfWidth, halfHeight, filled);
        this.name = name;
    }

    public void draw() {
        super.draw();
        Color tmp = StdDraw.getPenColor();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(x, y, name);
        StdDraw.setPenColor(tmp);
    }
}