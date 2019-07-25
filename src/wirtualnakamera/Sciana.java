/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Models.Edge3D;
import Models.Point3D;

import java.awt.Color;

/**
 *
 * @author rafal
 */
public class Sciana {

    public Point3D pkt1;
    public Point3D pkt2;
    public Point3D pkt3;
    public Point3D pkt4;
    public Color kolor;
    public Edge3D krawedz1;
    public Edge3D krawedz2;
    public Edge3D krawedz3;
    public Edge3D krawedz4;
    public double A;        //wspolczynniki 
    public double B;        //rownania plaszczyzny
    public double C;        //zawierajacej
    public double D;        //te sciane

    public Sciana(Point3D pkt1, Point3D pkt2, Point3D pkt3, Point3D pkt4, Color kolor) {
        this.pkt1 = pkt1;
        this.pkt2 = pkt2;
        this.pkt3 = pkt3;
        this.pkt4 = pkt4;
        this.kolor = kolor;

        double x1, x2, x3, y1, y2, y3, z1, z2, z3;
        x1 = pkt1.x;
        y1 = pkt1.y;
        z1 = pkt1.z;

        x2 = pkt2.x;
        y2 = pkt2.y;
        z2 = pkt2.z;

        x3 = pkt3.x;
        y3 = pkt3.y;
        z3 = pkt3.z;

        this.A = y1 * z2 - y1 * z3 - y2 * z1 + y2 * z3 + y3 * z1 - y3 * z2;
        this.B = -x1 * z2 + x1 * z3 + x2 * z1 - x2 * z3 - x3 * z1 + x3 * z2;
        this.C = x1 * y2 - x1 * y3 - x2 * y1 + x2 * y3 + x3 * y1 - x3 * y2;
        this.D = -x1 * y2 * z3 + x1 * y3 * z2 + x2 * y1 * z3 - x2 * y3 * z1 - x3 * y1 * z2 + x3 * y2 * z1;
        
        this.krawedz1 = new Edge3D(pkt1, pkt2);
        this.krawedz2 = new Edge3D(pkt2, pkt3);
        this.krawedz3 = new Edge3D(pkt3, pkt4);
        this.krawedz4 = new Edge3D(pkt4, pkt1);
        

    }

//    ArrayList<Edge3D> getKrawedzie() {
//        ArrayList<Edge3D> krw = new ArrayList<Edge3D>();
//        krw.add(krawedz1);
//        krw.add(krawedz2);
//        krw.add(krawedz3);
//        krw.add(krawedz4);
//        return krw;
//                
//    }
    
    @Override
    public String toString() {
        return "Sciana{" + "pkt1=" + pkt1 + ", pkt2=" + pkt2 + ", pkt3=" + pkt3 + ", pkt4=" + pkt4 + '}' + "\n";
    }
}
