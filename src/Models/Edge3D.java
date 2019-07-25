package Models;

/**Klasa zawiera definicję krawędzie w 3D*/
public class Edge3D {
    private Point3D point1;
    private Point3D point2;
    private int wallNumber1;
    private int wallNumber2;

    public Edge3D(Point3D point1, Point3D point2, int wallNumber1, int wallNumber2) {
        this.point1 = point1;
        this.point2 = point2;
        this.wallNumber1 = wallNumber1;
        this.wallNumber2 = wallNumber2;
    }

    public Edge3D(Point3D point1, Point3D point2) {
        this.point1 = point1;
        this.point2 = point2;

    }

    public Point3D getPoint1() {
        return point1;
    }

    public void setPoint1(Point3D point1) {
        this.point1 = point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public void setPoint2(Point3D point2) {
        this.point2 = point2;
    }

    public int getWallNumber1() {
        return wallNumber1;
    }

    public void setWallNumber1(int wallNumber1) {
        this.wallNumber1 = wallNumber1;
    }

    public int getWallNumber2() {
        return wallNumber2;
    }

    public void setWallNumber2(int wallNumber2) {
        this.wallNumber2 = wallNumber2;
    }

    @Override
    public String toString() {
        return "Edge3D{" + "punkt1=" + point1 + ", punkt2=" + point2 + ", nr_sciany1=" + wallNumber1 + ", nr_sciany2=" + wallNumber2 + '}' + "\n";
    }
    


    
    
    
}
