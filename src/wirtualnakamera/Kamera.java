/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Models.Edge3D;
import Models.Point3D;

import java.util.ArrayList;

/**
 *
 * @author rafal
 */
public class Kamera {
    double x_min = -1;
    double x_max = 1;
    double y_min = -1;
    double y_max = 1;
    
    ArrayList<Edge3D> krawedzieNaKamerze;
    


    public Kamera(ArrayList<Edge3D> krawedzieNaRzutni) {
        krawedzieNaKamerze = new ArrayList<Edge3D>();
        for(Edge3D kr : krawedzieNaRzutni) {
            if (czyKrawedzJestNaKamerze(kr)) {
                krawedzieNaKamerze.add(kr);
            }
        }
    }

    public Kamera() {
    }
    
    public ArrayList<Sciana> przytnijScianyDoKamery(ArrayList<Sciana> sciany) {
        this.krawedzieNaKamerze = new ArrayList<Edge3D>();
        ArrayList<Sciana> noweSciany = new ArrayList<Sciana>();
        for (Sciana sc : sciany) {
            if (czyKrawedzJestNaKamerze(sc.krawedz1) && czyKrawedzJestNaKamerze(sc.krawedz2)
                    && czyKrawedzJestNaKamerze(sc.krawedz3) && czyKrawedzJestNaKamerze(sc.krawedz4)) {
                krawedzieNaKamerze.add(sc.krawedz1);
                krawedzieNaKamerze.add(sc.krawedz2);
                krawedzieNaKamerze.add(sc.krawedz3);
                krawedzieNaKamerze.add(sc.krawedz4);
                noweSciany.add(sc);
            }
        }
        for (int i = 0; i < noweSciany.size() ; i++) {
            Sciana sc = noweSciany.get(i);
            sc.krawedz1.setWallNumber1(i);
            sc.krawedz2.setWallNumber1(i);
            sc.krawedz3.setWallNumber1(i);
            sc.krawedz4.setWallNumber1(i);
            
            
        }
        return noweSciany;
    }

    
    private boolean czyPunktJestNaKamerze(Point3D p) {
        if (p.x >= x_min && p.x <= x_max && p.y >= y_min && p.y <= y_max) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean czyKrawedzJestNaKamerze(Edge3D kr) {
        if (czyPunktJestNaKamerze(kr.getPoint1()) && czyPunktJestNaKamerze(kr.getPoint2())) {
            return true;
        }
        else {
            return false;
        }
    }
}
