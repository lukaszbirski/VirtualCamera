/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Models.Edge3D;
import Models.Point3D;
import Models.Wall;

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
    
    public ArrayList<Wall> przytnijScianyDoKamery(ArrayList<Wall> sciany) {
        this.krawedzieNaKamerze = new ArrayList<Edge3D>();
        ArrayList<Wall> noweSciany = new ArrayList<Wall>();
        for (Wall sc : sciany) {
            if (czyKrawedzJestNaKamerze(sc.getEdge1()) && czyKrawedzJestNaKamerze(sc.getEdge2())
                    && czyKrawedzJestNaKamerze(sc.getEdge3()) && czyKrawedzJestNaKamerze(sc.getEdge4())) {
                krawedzieNaKamerze.add(sc.getEdge1());
                krawedzieNaKamerze.add(sc.getEdge2());
                krawedzieNaKamerze.add(sc.getEdge3());
                krawedzieNaKamerze.add(sc.getEdge4());
                noweSciany.add(sc);
            }
        }
        for (int i = 0; i < noweSciany.size() ; i++) {
            Wall sc = noweSciany.get(i);
            sc.getEdge1().setWallNumber1(i);
            sc.getEdge2().setWallNumber1(i);
            sc.getEdge3().setWallNumber1(i);
            sc.getEdge4().setWallNumber1(i);
            
            
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
