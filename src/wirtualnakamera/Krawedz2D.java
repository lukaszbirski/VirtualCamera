/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Models.Point2D;

/**
 *
 * @author rafal
 */
public class Krawedz2D {
    public Point2D punkt1;
    public Point2D punkt2;
    public int nr_sciany1;
    public int nr_sciany2;

    public Krawedz2D(Point2D punkt1, Point2D punkt2) {
        this.punkt1 = punkt1;
        this.punkt2 = punkt2;
    }

    public Krawedz2D(Point2D punkt1, Point2D punkt2, int nr_sciany1, int nr_sciany2) {
        this.punkt1 = punkt1;
        this.punkt2 = punkt2;
        this.nr_sciany1 = nr_sciany1;
        this.nr_sciany2 = nr_sciany2;
    }

    
    
    @Override
    public String toString() {
        return "Krawedz2D{" + "punkt1=" + punkt1 + ", punkt2=" + punkt2 + '}' + "\n";
    }
    
    
}
