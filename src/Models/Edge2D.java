package Models;

/**Klasa zawiera definiuję krawędzi w 2D*/
public class Edge2D {
    private Point2D point1;
    private Point2D point2;
    private int wallNumber1;
    private int wallNumber2;

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

    public Point2D getPoint1() {
        return point1;
    }

    public Point2D getPoint2() {
        return point2;
    }

    public int getWallNumber1() {
        return wallNumber1;
    }

    public int getWallNumber2() {
        return wallNumber2;
    }

    @Override
    public String toString() {
        return "Krawędz2D{" + "punkt1=" + point1 + ", punkt2=" + point2 + '}' + "\n";
    }
    
    
}
