/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import Algorithms.Rzutowanie;
import Models.Edge2D;
import Models.Edge3D;

/**
 *
 * @author rafal
 */
public class Test {
    
    public static void wykonaj_test() {
        TestowaScena testowaScena = new TestowaScena();
        double odl_rzutni = 0.6;
        Rzutowanie rzut = new Rzutowanie(odl_rzutni);
        int wysokosc = 600;
        int szerokosc = 600;
        

        Kamera kam = new Kamera(rzut.rzutujKrawedzie(testowaScena.krawedzie));
        
        for (Edge3D kr : kam.krawedzieNaKamerze) {
            System.out.println(kr.toString());
        }
        
        Widok widok = new Widok(wysokosc, szerokosc, kam);
        
        for (Edge2D kr : widok.krawedzieNaWidoku) {
            System.out.println(kr.toString());
        }
        
        
    }
    
}
