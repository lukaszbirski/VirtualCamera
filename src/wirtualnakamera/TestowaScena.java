/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Models.Edge3D;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author rafal
 */
public class TestowaScena {
    ArrayList<Edge3D> krawedzie;
    
    /*
    Edge3D OX = new Edge3D(new Point3D(-100, 0, 0), new Point3D(100, 0, 0));
    Edge3D OY = new Edge3D(new Point3D(0, -100, 0), new Point3D(0, 100, 0));
    Edge3D OZ = new Edge3D(new Point3D(0, 0, -100), new Point3D(0, 0, 100));
    Edge3D a = new Edge3D(new Point3D(-10, -10, 10), new Point3D(10, -10, 10));
    Edge3D b = new Edge3D(new Point3D(10, -10, 10), new Point3D(10, -10, 20));
    Edge3D c = new Edge3D(new Point3D(-10, -10, 20), new Point3D(10, -10, 20));
    Edge3D d = new Edge3D(new Point3D(-10, -10, 10), new Point3D(-10, -10, 20));
    Edge3D e = new Edge3D(new Point3D(-10, 10, 10), new Point3D(10, 10, 10));
    Edge3D f = new Edge3D(new Point3D(10, 10, 10), new Point3D(10, 10, 20));
    Edge3D g = new Edge3D(new Point3D(-10, 10, 20), new Point3D(10, 10, 20));
    Edge3D h = new Edge3D(new Point3D(-10, 10, 10), new Point3D(-10, 10, 20));
    Edge3D i = new Edge3D(new Point3D(-10, -10, 10), new Point3D(-10, 10, 10));
    Edge3D j = new Edge3D(new Point3D(10, -10, 10), new Point3D(10, 10, 10));
    Edge3D k = new Edge3D(new Point3D(10, -10, 20), new Point3D(10, 10, 20));
    Edge3D l = new Edge3D(new Point3D(-10, -10, 20), new Point3D(-10, 10, 20));
    Edge3D a1 = new Edge3D(new Point3D(-40, -10, 15), new Point3D(-30, -10, 15));
    Edge3D b1 = new Edge3D(new Point3D(-30, -10, 15), new Point3D(-30, -10, 20));
    Edge3D c1 = new Edge3D(new Point3D(-40, -10, 20), new Point3D(-30, -10, 20));
    Edge3D d1 = new Edge3D(new Point3D(-40, -10, 15), new Point3D(-40, -10, 20));
    Edge3D e1 = new Edge3D(new Point3D(-40, 20, 15), new Point3D(-30, 20, 15));
    Edge3D f1 = new Edge3D(new Point3D(-30, 20, 15), new Point3D(-30, 20, 20));
    Edge3D g1 = new Edge3D(new Point3D(-40, 20, 20), new Point3D(-30, 20, 20));
    Edge3D h1 = new Edge3D(new Point3D(-40, 20, 15), new Point3D(-40, 20, 20));
    Edge3D i1 = new Edge3D(new Point3D(-40, -10, 15), new Point3D(-40, 20, 15));
    Edge3D j1 = new Edge3D(new Point3D(-30, -10, 15), new Point3D(-30, 20, 15));
    Edge3D k1 = new Edge3D(new Point3D(-30, -10, 20), new Point3D(-30, 20, 20));
    Edge3D l1 = new Edge3D(new Point3D(-40, -10, 20), new Point3D(-40, 20, 20));
    Edge3D a2 = new Edge3D(new Point3D(-40, -10, 25), new Point3D(-30, -10, 25));
    Edge3D b2 = new Edge3D(new Point3D(-30, -10, 25), new Point3D(-30, -10, 35));
    Edge3D c2 = new Edge3D(new Point3D(-40, -10, 35), new Point3D(-30, -10, 35));
    Edge3D d2 = new Edge3D(new Point3D(-40, -10, 25), new Point3D(-40, -10, 35));
    Edge3D e2 = new Edge3D(new Point3D(-40, 30, 25), new Point3D(-30, 30, 25));
    Edge3D f2 = new Edge3D(new Point3D(-30, 30, 25), new Point3D(-30, 30, 35));
    Edge3D g2 = new Edge3D(new Point3D(-40, 30, 35), new Point3D(-30, 30, 35));
    Edge3D h2 = new Edge3D(new Point3D(-40, 30, 25), new Point3D(-40, 30, 35));
    Edge3D i2 = new Edge3D(new Point3D(-40, -10, 25), new Point3D(-40, 30, 25));
    Edge3D j2 = new Edge3D(new Point3D(-30, -10, 25), new Point3D(-30, 30, 25));
    Edge3D k2 = new Edge3D(new Point3D(-30, -10, 35), new Point3D(-30, 30, 35));
    Edge3D l2 = new Edge3D(new Point3D(-40, -10, 35), new Point3D(-40, 30, 35));
    
    */
    Matrix macierz;

    public TestowaScena() {
        krawedzie = new ArrayList<Edge3D>();
        
        //krawedzie.add(OX);
        //krawedzie.add(OY);
        // krawedzie.add(OZ);
/*
        krawedzie.add(a);
        krawedzie.add(b);
        krawedzie.add(c);
        krawedzie.add(d);
        krawedzie.add(e);
        krawedzie.add(f);
        krawedzie.add(g);
        krawedzie.add(h);
        krawedzie.add(i);
        krawedzie.add(j);
        krawedzie.add(k);
        krawedzie.add(l);
        krawedzie.add(a1);
        krawedzie.add(b1);
        krawedzie.add(c1);
        krawedzie.add(d1);
        krawedzie.add(e1);
        krawedzie.add(f1);
        krawedzie.add(g1);
        krawedzie.add(h1);
        krawedzie.add(i1);
        krawedzie.add(j1);
        krawedzie.add(k1);
        krawedzie.add(l1);

        krawedzie.add(a2);
        krawedzie.add(b2);
        krawedzie.add(c2);
        krawedzie.add(d2);
        krawedzie.add(e2);
        krawedzie.add(f2);
        krawedzie.add(g2);
        krawedzie.add(h2);
        krawedzie.add(i2);
        krawedzie.add(j2);
        krawedzie.add(k2);
        krawedzie.add(l2);
*/
        
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
