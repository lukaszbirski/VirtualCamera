package wirtualnakamera;

import Algorithms.Matrix;
import Models.Edge3D;

import java.awt.Color;
import java.util.ArrayList;

public class TestowaScena {
    ArrayList<Edge3D> krawedzie;

    Matrix macierz;

    public TestowaScena() {
        krawedzie = new ArrayList<Edge3D>();
        macierz = new Matrix(Matrix.identityMatrix());
    }

    public static Scena stworzScene() {
        ArrayList<Edge3D> krawedzie = new ArrayList<Edge3D>();
        Matrix macierz = new Matrix(Matrix.identityMatrix());
        Scena scena = new Scena(krawedzie, macierz);
        scena.dodajNowyProstopadloscian(-40, -10, 145, -30, 20, 150, Color.BLUE);
        scena.dodajNowyProstopadloscian(-40, -10, 160, -30, 30, 170, Color.CYAN);
        scena.dodajNowyProstopadloscian(-35, -10, 125, -30, 25, 133, Color.GRAY);
        scena.dodajNowyProstopadloscian(-35, -10, 105, -30, 15, 115, Color.GREEN);
        scena.dodajNowyProstopadloscian(-20, -10, 150, -10, 10, 160, Color.MAGENTA);
        scena.dodajNowyProstopadloscian(-20, -10, 130, -10, 20, 135, Color.ORANGE);
        scena.dodajNowyProstopadloscian(-20, -10, 105, -15, 15, 115, Color.PINK);
        scena.dodajNowyProstopadloscian(5, -10, 110, 20, 20, 120, Color.LIGHT_GRAY);
        scena.dodajNowyProstopadloscian(15, -10, 125, 25, 25, 135, Color.RED);
        scena.dodajNowyProstopadloscian(10, -10, 145, 30, 15, 150, Color.BLUE);

        return scena;
    }
}
