package Models;

public class Edge2D {
    public Point2D point1;
    public Point2D point2;
    public int wallNumber1;
    public int wallNumber2;

    public Edge2D(Point2D point1, Point2D point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Edge2D(Point2D point1, Point2D point2, int wallNumber1, int wallNumber2) {
        this.point1 = point1;
        this.point2 = point2;
        this.wallNumber1 = wallNumber1;
        this.wallNumber2 = wallNumber2;
    }

    @Override
    public String toString() {
        return "Krawędz2D{" + "punkt1=" + point1 + ", punkt2=" + point2 + '}' + "\n";
    }
    
    
}
