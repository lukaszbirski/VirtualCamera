package Models;

import java.awt.Color;

/**Klasa zawiera definicję parametrów ściany w przestrzeni 3D;
 * punkty narożników, krawędzie, kolor ściany i współczynniki
 * równania płaszczyzn. Potrzebne do rzutowań z 3D na 2D*/
public class Wall {

    private Point3D point1;
    private Point3D point2;
    private Point3D point3;
    private Point3D point4;
    private Color color;
    private Edge3D edge1;
    private Edge3D edge2;
    private Edge3D edge3;
    private Edge3D edge4;
    //potrzebne do algorytmu zasłaniania
    private double A;
    private double B;
    private double C;
    private double D;

    public Wall(Point3D point1, Point3D point2, Point3D point3, Point3D point4, Color color) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.color = color;

        double x1, x2, x3, y1, y2, y3, z1, z2, z3;
        x1 = point1.x;
        y1 = point1.y;
        z1 = point1.z;

        x2 = point2.x;
        y2 = point2.y;
        z2 = point2.z;

        x3 = point3.x;
        y3 = point3.y;
        z3 = point3.z;

        this.A = y1 * z2 - y1 * z3 - y2 * z1 + y2 * z3 + y3 * z1 - y3 * z2;
        this.B = -x1 * z2 + x1 * z3 + x2 * z1 - x2 * z3 - x3 * z1 + x3 * z2;
        this.C = x1 * y2 - x1 * y3 - x2 * y1 + x2 * y3 + x3 * y1 - x3 * y2;
        this.D = -x1 * y2 * z3 + x1 * y3 * z2 + x2 * y1 * z3 - x2 * y3 * z1 - x3 * y1 * z2 + x3 * y2 * z1;
        
        this.edge1 = new Edge3D(point1, point2);
        this.edge2 = new Edge3D(point2, point3);
        this.edge3 = new Edge3D(point3, point4);
        this.edge4 = new Edge3D(point4, point1);
    }

    public Point3D getPoint1() {
        return point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public Point3D getPoint3() {
        return point3;
    }

    public Point3D getPoint4() {
        return point4;
    }

    public Color getColor() {
        return color;
    }

    public Edge3D getEdge1() {
        return edge1;
    }

    public void setEdge1(Edge3D edge1) {
        this.edge1 = edge1;
    }

    public Edge3D getEdge2() {
        return edge2;
    }

    public void setEdge2(Edge3D edge2) {
        this.edge2 = edge2;
    }

    public Edge3D getEdge3() {
        return edge3;
    }

    public void setEdge3(Edge3D edge3) {
        this.edge3 = edge3;
    }

    public Edge3D getEdge4() {
        return edge4;
    }

    public void setEdge4(Edge3D edge4) {
        this.edge4 = edge4;
    }

    public double getA() {
        return A;
    }

    public double getB() {
        return B;
    }

    public double getC() {
        return C;
    }

    public double getD() {
        return D;
    }

    @Override
    public String toString() {
        return "Ściana{" + "pkt1=" + point1 + ", pkt2=" + point2 + ", pkt3=" + point3 + ", pkt4=" + point4 + '}' + "\n";
    }
}