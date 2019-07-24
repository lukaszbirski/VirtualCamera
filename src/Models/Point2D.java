package Models;

/**Klasa zawiera definicje punktu w przestrzeni 2D*/
public class Point2D {
    public int x;
    public int y;
    public double w;

    public Point2D(int x, int y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public Point2D() {
    }

    @Override
    public String toString() {
        return "Point2D{" + "x =" + x + ", y =" + y + '}';
    }
    
    
}
