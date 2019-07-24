package Models;

import Models.Point2D;
import wirtualnakamera.Matrix;

/**Klasa zawiera definicje punktu w przestrzeni 3D*/
public class Point3D extends Point2D {

    public double x;
    public double y;
    public double z;
    double w;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = 1;
    }

    public Point3D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    public Point3D(double[][] tmpVector) {
        this.x = tmpVector[0][0];
        this.y = tmpVector[1][0];
        this.z = tmpVector[2][0];
        this.w = tmpVector[3][0];
    }

    public double[][] tmpVector() {
        double tmp[][] = {
            {this.x},
            {this.y},
            {this.z},
            {this.w}
        };
        return tmp;
    }

    /**Metoda normalizuje punkt w 3D*/
    public void normalization() {
        this.x = this.x / this.w;
        this.y = this.y / this.w;
        this.z = this.z / this.w;
        this.w = this.w / this.w;
    }

    @Override
    public String toString() {
        return "Point3D{" + "x=" + x + ", y=" + y + ", z=" + z + ", w=" + w + '}' + "\n";
    }
}
