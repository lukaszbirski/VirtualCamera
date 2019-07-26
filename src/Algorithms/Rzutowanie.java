package Algorithms;

import Models.Edge3D;
import Models.Point3D;
import Models.Wall;

import java.util.ArrayList;

/**Klasa odpowiada za przepisywanie realnych obiektów w 3D na obiekty 2D widoczne na ekranie monitora*/
public class Rzutowanie {
    double d;
    Matrix matrix;
    double z_min = 0.1;

    public Rzutowanie(double d) {
        this.d = d;
        matrix = new Matrix(Matrix.projectionMatrix(d));
    }
    
    public Point3D rzutuj_punkt(Point3D p) {
        Point3D pkt = new Point3D(p.x * this.d / p.z, p.y * this.d / p.z, this.d);
        return pkt;
    }
    
    public Edge3D rzutuj_krawedz(Edge3D kr) {
        return new Edge3D(rzutuj_punkt(kr.getPoint1()), rzutuj_punkt(kr.getPoint2()), kr.getWallNumber1(), kr.getWallNumber2());
        
    }
    
    public ArrayList<Edge3D> rzutujKrawedzie(ArrayList<Edge3D> krawedzie) {
        ArrayList<Edge3D> zrzutowaneKrawedzie = new ArrayList<Edge3D>();
        for (Edge3D kr : krawedzie) {
            zrzutowaneKrawedzie.add(rzutuj_krawedz(kr));
        }
        return zrzutowaneKrawedzie;
    }
    
    public ArrayList<Wall> rzutujSciany(ArrayList<Wall> sciany) {
        ArrayList<Wall> zrzutowane = new ArrayList<Wall>();
        for (Wall sc : sciany) {
            zrzutowane.add(rzutujSciane(sc));
        }
        return zrzutowane;
    }
    
    public Wall rzutujSciane(Wall sciana) {
        sciana.setEdge1(rzutuj_krawedz(sciana.getEdge1()));
        sciana.setEdge2(rzutuj_krawedz(sciana.getEdge2()));
        sciana.setEdge3(rzutuj_krawedz(sciana.getEdge3()));
        sciana.setEdge4(rzutuj_krawedz(sciana.getEdge4()));
        return sciana;
    }
}
