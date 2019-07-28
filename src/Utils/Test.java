package Utils;

import Algorithms.Matrix;
import Models.Edge3D;
import wirtualnakamera.Scene;

import java.awt.Color;
import java.util.ArrayList;

/**Zadaniem klasy jest tworzenie przykładkowej sceny w celu testowania zasadności i sprawności programu.*/
public class Test {
    private ArrayList<Edge3D> edge3DArrayList;
    private Matrix matrix;

    public Test() {
        edge3DArrayList = new ArrayList<Edge3D>();
        matrix = new Matrix(Matrix.identityMatrix());
    }

    /**Metoda tworzy przykładową scenę. Zmieniając/usuwając/dodając nowe prostokąty można modyfikować scenę.*/
    public static Scene createScene() {
        ArrayList<Edge3D> edge3DArrayList = new ArrayList<Edge3D>();
        Matrix matrix = new Matrix(Matrix.identityMatrix());
        Scene scene = new Scene(edge3DArrayList, matrix);
        scene.addNewCuboid(-40, -10, 145, -30, 20, 150, Color.BLUE);
//        scene.addNewCuboid(-40, -10, 160, -30, 30, 170, Color.CYAN);
//        scene.addNewCuboid(-35, -10, 125, -30, 25, 133, Color.GRAY);
//        scene.addNewCuboid(-35, -10, 105, -30, 15, 115, Color.GREEN);
//        scene.addNewCuboid(-20, -10, 150, -10, 10, 160, Color.MAGENTA);
//        scene.addNewCuboid(-20, -10, 130, -10, 20, 135, Color.ORANGE);
//        scene.addNewCuboid(-20, -10, 105, -15, 15, 115, Color.PINK);
//        scene.addNewCuboid(5, -10, 110, 20, 20, 120, Color.LIGHT_GRAY);
//        scene.addNewCuboid(15, -10, 125, 25, 25, 135, Color.RED);
        scene.addNewCuboid(10, -10, 145, 30, 15, 150, Color.BLUE);

        return scene;
    }
}
