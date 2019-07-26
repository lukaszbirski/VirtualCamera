/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Algorithms.Matrix;
import Models.Edge3D;
import Models.Point3D;
import Models.Wall;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author rafal
 */
public class Scena {
    ArrayList<Edge3D> krawedzie;
    ArrayList<Wall> sciany;
    Matrix matrix;
    VirtualCamera wk;
    int numerOstatniejSciany;
    

    public Scena(ArrayList<Edge3D> krawedzie, Matrix matrix) {
        this.krawedzie = krawedzie;
        this.matrix = matrix;
        numerOstatniejSciany = 0;
        sciany = new ArrayList<Wall>();
    }

    public ArrayList<Edge3D> nowyProstopadloscian(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Color kolor) {
        ArrayList<Edge3D> krawedzie = new ArrayList<Edge3D>();
        Point3D pkt1 = new Point3D(minX, minY, minZ);
        Point3D pkt2 = new Point3D(maxX, minY, minZ);
        Point3D pkt3 = new Point3D(maxX, minY, maxZ);
        Point3D pkt4 = new Point3D(minX, minY, maxZ);
        Point3D pkt5 = new Point3D(minX, maxY, minZ);
        Point3D pkt6 = new Point3D(maxX, maxY, minZ);
        Point3D pkt7 = new Point3D(maxX, maxY, maxZ);
        Point3D pkt8 = new Point3D(minX, maxY, maxZ);
        
        //sciany maja punkty zorientowane zgodnie z ruchem wskazowek zegara
        //normalne scian sa skierowane na zewnatrz bryly
        
        Wall scianaA = new Wall(pkt1, pkt2, pkt3, pkt4, kolor);     //dolna podstawa
        Wall scianaB = new Wall(pkt8, pkt7, pkt6, pkt5, kolor);     //gorna podstawa
        Wall scianaC = new Wall(pkt5, pkt6, pkt2, pkt1, kolor);     //przednia sciana
        Wall scianaD = new Wall(pkt6, pkt7, pkt3, pkt2, kolor);     //prawa sciana
        Wall scianaE = new Wall(pkt7, pkt8, pkt4, pkt3, kolor);     //tylna sciana
        Wall scianaF = new Wall(pkt8, pkt5, pkt1, pkt4, kolor);     //lewa sciana
        
        sciany.add(scianaA);
        sciany.add(scianaB);
        sciany.add(scianaC);
        sciany.add(scianaD);
        sciany.add(scianaE);
        sciany.add(scianaF);


        Edge3D kra = new Edge3D(pkt1, pkt2, sciany.indexOf(scianaA), sciany.indexOf(scianaC));
        Edge3D krb = new Edge3D(pkt2, pkt3, sciany.indexOf(scianaA), sciany.indexOf(scianaD));
        Edge3D krc = new Edge3D(pkt3, pkt4, sciany.indexOf(scianaA), sciany.indexOf(scianaE));
        Edge3D krd = new Edge3D(pkt4, pkt1, sciany.indexOf(scianaA), sciany.indexOf(scianaF));
        
        Edge3D kre = new Edge3D(pkt5, pkt6, sciany.indexOf(scianaB), sciany.indexOf(scianaC));
        Edge3D krf = new Edge3D(pkt6, pkt7, sciany.indexOf(scianaB), sciany.indexOf(scianaD));
        Edge3D krg = new Edge3D(pkt7, pkt8, sciany.indexOf(scianaB), sciany.indexOf(scianaE));
        Edge3D krh = new Edge3D(pkt8, pkt5, sciany.indexOf(scianaB), sciany.indexOf(scianaF));
        
        Edge3D kri = new Edge3D(pkt1, pkt5, sciany.indexOf(scianaC), sciany.indexOf(scianaF));
        Edge3D krj = new Edge3D(pkt2, pkt6, sciany.indexOf(scianaC), sciany.indexOf(scianaD));
        Edge3D krk = new Edge3D(pkt3, pkt7, sciany.indexOf(scianaD), sciany.indexOf(scianaE));
        Edge3D krl = new Edge3D(pkt4, pkt8, sciany.indexOf(scianaE), sciany.indexOf(scianaF));
        
//        sciany.get(sciany.indexOf(scianaA)).krawedz1 = kra;
//        sciany.get(sciany.indexOf(scianaA)).krawedz2 = krb;
//        sciany.get(sciany.indexOf(scianaA)).krawedz3 = krc;
//        sciany.get(sciany.indexOf(scianaA)).krawedz4 = krd;
//        
//        sciany.get(sciany.indexOf(scianaB)).krawedz1 = kre;
//        sciany.get(sciany.indexOf(scianaB)).krawedz2 = krf;
//        sciany.get(sciany.indexOf(scianaB)).krawedz3 = krg;
//        sciany.get(sciany.indexOf(scianaB)).krawedz4 = krh;
//        
//        sciany.get(sciany.indexOf(scianaC)).krawedz1 = kra;
//        sciany.get(sciany.indexOf(scianaC)).krawedz2 = krj;
//        sciany.get(sciany.indexOf(scianaC)).krawedz3 = kre;
//        sciany.get(sciany.indexOf(scianaC)).krawedz4 = kri;
//        
//        sciany.get(sciany.indexOf(scianaD)).krawedz1 = kre;
//        sciany.get(sciany.indexOf(scianaD)).krawedz2 = krf;
//        sciany.get(sciany.indexOf(scianaD)).krawedz3 = krg;
//        sciany.get(sciany.indexOf(scianaD)).krawedz4 = krh;
        
        krawedzie.add(kra);
        krawedzie.add(krb);
        krawedzie.add(krc);
        krawedzie.add(krd);
        
        krawedzie.add(kre);
        krawedzie.add(krf);
        krawedzie.add(krg);
        krawedzie.add(krh);
        
        krawedzie.add(kri);
        krawedzie.add(krj);
        krawedzie.add(krk);
        krawedzie.add(krl);
        
        
        /*
        krawedzie.add(new Edge3D(new Point3D(minX, minY, minZ), new Point3D(maxX, minY, minZ) )); //a
        krawedzie.add(new Edge3D(new Point3D(maxX, minY, minZ), new Point3D(maxX, minY, maxZ) )); //b
        krawedzie.add(new Edge3D(new Point3D(minX, minY, maxZ), new Point3D(maxX, minY, maxZ))); //c
        krawedzie.add(new Edge3D(new Point3D(minX, minY, minZ), new Point3D(minX, minY, maxZ))); //d

        
        krawedzie.add(new Edge3D(new Point3D(minX, maxY, minZ), new Point3D(maxX, maxY, minZ))); //e
        krawedzie.add(new Edge3D(new Point3D(maxX, maxY, minZ), new Point3D(maxX, maxY, maxZ))); //f
        krawedzie.add(new Edge3D(new Point3D(minX, maxY, maxZ), new Point3D(maxX, maxY, maxZ))); //g
        krawedzie.add(new Edge3D(new Point3D(minX, maxY, minZ), new Point3D(minX, maxY, maxZ))); //h
        
        krawedzie.add(new Edge3D(new Point3D(minX, minY, minZ), new Point3D(minX, maxY, minZ))); //i
        krawedzie.add(new Edge3D(new Point3D(maxX, minY, minZ), new Point3D(maxX, maxY, minZ))); //j
        krawedzie.add(new Edge3D(new Point3D(maxX, minY, maxZ), new Point3D(maxX, maxY, maxZ))); //k
        krawedzie.add(new Edge3D(new Point3D(minX, minY, maxZ), new Point3D(minX, maxY, maxZ))); //l
        */
        
        return krawedzie;
        
    }
    
    public void dodajNowyProstopadloscian(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Color kolor) {
        this.krawedzie.addAll(this.nowyProstopadloscian(minX, minY, minZ, maxX, maxY, maxZ, kolor));
        
    }

    @Override
    public String toString() {
        return "Scena{" + "krawedzie=" + krawedzie + ", sciany=" + sciany + '}';
    }
    
    public static ArrayList<Wall> backfaceCulling(ArrayList<Wall> sciany) {
        ArrayList<Wall> noweSciany = new ArrayList<Wall>();
        for (Wall s : sciany) {
            double wsp = s.getA() * s.getPoint1().x + s.getB() * s.getPoint1().y + s.getC() * s.getPoint1().z;
            if (wsp < 0) {
                noweSciany.add(s);
            }
        }
        
        
        
        return noweSciany;
    }
}
