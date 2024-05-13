package conwaygame;
/*
 * Class to be used as an extension (extend) for classes such as Button and Board.
 */
import java.awt.Color;

public class Rectangle {
    public int x;
    public int y;
    public int halfWidth;
    public int halfHeight;
    public boolean filled;
    public Color color;

    public Rectangle(int x, int y, int halfWidth, int halfHeight, boolean filled) {
        this.x = x;
        this.y = y;
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.filled = filled;
    }

    public void draw() {
        color = StdDraw.getPenColor();
        if (filled) {
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);            
        } else {
            StdDraw.rectangle(x, y, halfWidth, halfHeight);
        }
    }

    public void changeColor(Color c) {
        Color tmp = StdDraw.getPenColor();
        StdDraw.setPenColor(c);
        draw();  // Calls sub class's draw()
        StdDraw.setPenColor(tmp);
    }

    public boolean containsMouse() {
        double mX = StdDraw.mouseX();
        double mY = StdDraw.mouseY();
        return ((x - halfWidth < mX && mX < x + halfWidth) && (y - halfHeight < mY && mY < y + halfHeight));
    }
}
