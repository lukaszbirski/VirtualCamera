/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Models.Edge2D;
import Models.Edge3D;
import Models.Point2D;
import Models.Point3D;

import java.util.ArrayList;

/**
 *
 * @author rafal
 */
public class Widok {
    int wysokosc;
    int szerokosc;
    
    ArrayList<Edge2D> krawedzieNaWidoku;
    Kamera kamera;

    public Widok(int wysokosc, int szerokosc, Kamera kamera) {
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.kamera = kamera;
        
        this.krawedzieNaWidoku = przesunKrawedzieDoWidoku(kamera.krawedzieNaKamerze);
    }



    public Widok(int wysokosc, int szerokosc, ArrayList<Edge3D> krawedzieNaKamerze, Kamera kamera) {
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.krawedzieNaWidoku = przesunKrawedzieDoWidoku(krawedzieNaKamerze);
        this.kamera = kamera;
    }
    

    Point2D przesunPunktDoWidoku(Point3D p) {
//        System.out.println(p.x + "\t" + p.y);
        int x = (int) ((p.x - kamera.x_min) * szerokosc / (kamera.x_max - kamera.x_min));
//        int y = (int) ((p.y - kamera.y_min) * wysokosc / (kamera.y_max - kamera.y_min));    //zamienic wsp - os oy w druga strone
        int y = wysokosc - ((int) ((p.y - kamera.y_min) * wysokosc / (kamera.y_max - kamera.y_min)));   //zamienione
        return new Point2D(x, y, p.z);
    }
    
    Edge2D przesunKrawedzDoWidoku(Edge3D kr) {
        return new Edge2D(przesunPunktDoWidoku(kr.getPoint1()), przesunPunktDoWidoku(kr.getPoint2()), kr.getWallNumber1(), kr.getWallNumber1());
    }
    
    ArrayList<Edge2D> przesunKrawedzieDoWidoku(ArrayList<Edge3D> krawedzieNaKamerze) {
        ArrayList<Edge2D> knw = new ArrayList<Edge2D>();
        
        for (Edge3D kr : krawedzieNaKamerze) {
            knw.add(przesunKrawedzDoWidoku(kr));
        }
        return knw;
        
    }

    public ArrayList<Edge2D> getKrawedzieNaWidoku() {
        return krawedzieNaWidoku;
    }
    
    public String wypiszKrawedzieNaWidoku() {
        String ret = new String();
        
        for (Edge2D kr :krawedzieNaWidoku) {
            ret += kr.toString();
            ret += "\n";
        }
        
        return ret;
    }
    
    public double[] wrocWspolrzedneDoKamery(double x, double y) {
        double ret[] = new double[2];
        ret[0] = x * (kamera.x_max - kamera.x_min) / szerokosc + kamera.x_min;      //wsp x
//        ret[1] = kamera.y_min - (x - wysokosc) * (kamera.y_max - kamera.y_min) / wysokosc;      //wsp y
//        ret[1] = y * (kamera.y_max - kamera.y_min) / wysokosc + kamera.y_min;
        ret[1] = (wysokosc - y) * (kamera.y_max - kamera.y_min) / wysokosc + kamera.y_min;
        
        return ret;
        
    }
    
}
    
