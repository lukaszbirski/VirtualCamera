/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Models.Point3D;

import java.util.ArrayList;

/**
 *
 * @author rafal
 */
public class Rzutowanie {
    double d;
    Matrix macierz;
    double z_min = 0.1;

    
            

    public Rzutowanie(double d) {
        this.d = d;
        macierz = new Matrix(Matrix.projectionMatrix(d));
        //macierz = new Matrix(Matrix.macierzPp(d,z_min));
    }
    
//    Point3D rzutuj_punkt(Point3D p) {
//        double[][] wsp = Matrix.multiply(this.macierz.macierz, p.wektorWsp());
//        Point3D pkt = new Point3D(wsp[0][0], wsp[1][0], wsp[2][0], wsp[3][0]);
//        pkt.normalizuj();
//        return pkt;
//        
//    } 
    
    Point3D rzutuj_punkt(Point3D p) {
        Point3D pkt = new Point3D(p.x * this.d / p.z, p.y * this.d / p.z, this.d);
        return pkt;
    }
    
    Krawedz3D rzutuj_krawedz(Krawedz3D kr) {
        return new Krawedz3D(rzutuj_punkt(kr.punkt1), rzutuj_punkt(kr.punkt2), kr.nr_sciany1, kr.nr_sciany2);
        
    }
    
    ArrayList<Krawedz3D> rzutujKrawedzie(ArrayList<Krawedz3D> krawedzie) {
        ArrayList<Krawedz3D> zrzutowaneKrawedzie = new ArrayList<Krawedz3D>();
        for (Krawedz3D kr : krawedzie) {
            zrzutowaneKrawedzie.add(rzutuj_krawedz(kr));
        }
        return zrzutowaneKrawedzie;
    }
    
    ArrayList<Sciana> rzutujSciany(ArrayList<Sciana> sciany) {
        ArrayList<Sciana> zrzutowane = new ArrayList<Sciana>();
        for (Sciana sc : sciany) {
            zrzutowane.add(rzutujSciane(sc));
        }
        return zrzutowane;
    }
    
    Sciana rzutujSciane(Sciana sciana) {
        sciana.krawedz1 = rzutuj_krawedz(sciana.krawedz1);
        sciana.krawedz2 = rzutuj_krawedz(sciana.krawedz2);
        sciana.krawedz3 = rzutuj_krawedz(sciana.krawedz3);
        sciana.krawedz4 = rzutuj_krawedz(sciana.krawedz4);
        return sciana;
    }
}
