package Algorithms;

import Models.Edge3D;
import Models.Point3D;
import Models.Wall;
import java.util.ArrayList;

/**Klasa odpowiada za przepisywanie realnych obiektów w 3D na
 * obiekty 2D widoczne na ekranie monitora*/
public class ProjectionAlgorithms {
    private double d;           //d to współrzędna rzutowania (0,0,-d)
    private Matrix matrix;

    public ProjectionAlgorithms(double d) {
        this.d = d;
        matrix = new Matrix(Matrix.projectionMatrix(d));
    }

    /**Algorytm rzutuje punkt w przestrzeni */
    public Point3D projectPoint(Point3D p3D) {
        Point3D point3D = new Point3D(p3D.x * this.d / p3D.z, p3D.y * this.d / p3D.z, this.d);
        return point3D;
    }

    /**Metoda rzutuje pojedyńczą krawędz 3D*/
    public Edge3D projectEdge3D(Edge3D edge3D) {
        return new Edge3D(projectPoint(edge3D.getPoint1()), projectPoint(edge3D.getPoint2()), edge3D.getWallNumber1(), edge3D.getWallNumber2());
        
    }

    /**Metoda rzutuje ściany 3D a później tworzy nową listę ścian 3D.*/
    public ArrayList<Edge3D> projectEdgesList(ArrayList<Edge3D> edgesList) {
        ArrayList<Edge3D> projectedEdges = new ArrayList<Edge3D>();
        for (Edge3D edge3D : edgesList) {
            projectedEdges.add(projectEdge3D(edge3D));
        }
        return projectedEdges;
    }

    /**Metoda służy do rzutowania zadanej ściany. Zwraca obiekt klasy Wall po przekształceniu.*/
    public Wall projectWall(Wall wall) {
        wall.setEdge1(projectEdge3D(wall.getEdge1()));
        wall.setEdge2(projectEdge3D(wall.getEdge2()));
        wall.setEdge3(projectEdge3D(wall.getEdge3()));
        wall.setEdge4(projectEdge3D(wall.getEdge4()));
        return wall;
    }

    /**Metoda tworzy listę obiektów klasy Wall; tworzy listę ścian.*/
    public ArrayList<Wall> projectWallList(ArrayList<Wall> walls) {
        ArrayList<Wall> projectedWalls = new ArrayList<Wall>();
        for (Wall wall : walls) {
            projectedWalls.add(projectWall(wall));
        }
        return projectedWalls;
    }
}