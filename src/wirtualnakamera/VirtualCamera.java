/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import java.awt.Color;
import java.util.ArrayList;

import Models.Edge2D;
import Models.Point3D;
import zaslanianie.Algorytm;
import zaslanianie.BuforEkranu;

/**
 *
 * @author rafal
 */
public class VirtualCamera {

    Scena scena;
    public double odl_rzutni;
    double poczatkowa_odl_rzutni;
    Rzutowanie rzut;
    public Kamera kamera;
    public Widok widok;
    int wysokosc;
    int szerokosc;
    //   ArrayList<Krawedz3D> krawedzie;
    static final double ZOOM_STEP = 0.01;
    static final double TRANSLATION_STEP = 0.5;
    static final double ROTATION_STEP = 0.01;
    public BuforEkranu ekran;
    Color kolorTla = Color.YELLOW;

    public VirtualCamera(Scena scena, double odl_rzutni, int wysokosc, int szerokosc) {
        this.poczatkowa_odl_rzutni = odl_rzutni;
        this.scena = scena;
        this.odl_rzutni = odl_rzutni;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
    }

    public void przetworzScene() {
        /*
         * for (Krawedz3D kr : scena.krawedzie) {
         * kr.punkt1.przemnozPrzezMacierzINormalizuj(scena.macierz);
         * kr.punkt2.przemnozPrzezMacierzINormalizuj(scena.macierz); }
         */
//        ArrayList<Krawedz3D> krawedzie = new ArrayList<Krawedz3D>();
//        for (Krawedz3D kr : scena.krawedzie) {
//
//            Point3D pkt1 = new Point3D(Matrix.multiply(scena.macierz.macierz, kr.punkt1.wektorWsp()));
//            Point3D pkt2 = new Point3D(Matrix.multiply(scena.macierz.macierz, kr.punkt2.wektorWsp()));
//            pkt1.normalizuj();
//            pkt2.normalizuj();
//            Krawedz3D krw = new Krawedz3D(pkt1, pkt2, kr.nr_sciany1, kr.nr_sciany2);
//            krawedzie.add(krw);
//
//
//        }
//        
        ArrayList<Sciana> sciany = new ArrayList<Sciana>();
        for (Sciana s : scena.sciany) {         //transformacje scian

            Point3D npkt1 = new Point3D(Matrix.multiply(scena.matrix.matrix, s.pkt1.tmpVector()));
            npkt1.normalization();
            Point3D npkt2 = new Point3D(Matrix.multiply(scena.matrix.matrix, s.pkt2.tmpVector()));
            npkt2.normalization();
            Point3D npkt3 = new Point3D(Matrix.multiply(scena.matrix.matrix, s.pkt3.tmpVector()));
            npkt3.normalization();
            Point3D npkt4 = new Point3D(Matrix.multiply(scena.matrix.matrix, s.pkt4.tmpVector()));
            npkt4.normalization();
            Sciana ns = new Sciana(npkt1, npkt2, npkt3, npkt4, s.kolor);
            sciany.add(ns);
        }

        sciany = Scena.backfaceCulling(sciany);
//        System.out.println(sciany);
//        ArrayList<Krawedz3D> krawedzie = new ArrayList<Krawedz3D>();


//        rzut = new Rzutowanie(odl_rzutni);
//        kamera = new Kamera(rzut.rzutujKrawedzie(krawedzie));
//        widok = new Widok(wysokosc, szerokosc, kamera);

        rzut = new Rzutowanie(odl_rzutni);
        sciany = rzut.rzutujSciany(sciany);
        kamera = new Kamera();
        sciany = kamera.przytnijScianyDoKamery(sciany);
        widok = new Widok(wysokosc, szerokosc, kamera);


        Algorytm algorytm = new Algorytm(widok.krawedzieNaWidoku, sciany, wysokosc, szerokosc, kolorTla, odl_rzutni, widok);
        ekran = algorytm.eliminuj();
        //System.out.println(getKrawedzieDoNarysowania());
        //  System.out.println(algorytm.tablicaKrawedzi.lista);
        //        for (int i = 0 ; i < algorytm.tablicaKrawedzi.lista.size(); i++) {
        //            System.out.println(Integer.toString(i) + ": " + algorytm.tablicaKrawedzi.lista.get(i).toString() + "\n");
        //        }

    }

    public ArrayList<Edge2D> getKrawedzieDoNarysowania() {
        return this.widok.getKrawedzieNaWidoku();
    }

    public BuforEkranu getBuforEkranu() {
        return this.ekran;
    }

    /**Metoda przybliża widok kamery do obiektu*/
    public void zoomIn() {
        this.odl_rzutni += ZOOM_STEP;
        przetworzScene();

    }

    /**Metoda oddala widok kamery od obiektu*/
    public void zoomOut() {
        if (this.odl_rzutni > ZOOM_STEP) {
            this.odl_rzutni -= ZOOM_STEP;
            przetworzScene();
        }
    }

    /**Metoda przesuwa widok kamery w prawo wg. OX*/
    public void translationInRightOX() {
        scena.matrix.matrix = Matrix.multiply(Matrix.translationMatrix(-1 * TRANSLATION_STEP, 0, 0), scena.matrix.matrix);
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery w lewo wg. OX*/
    public void translationInLeftOX() {
        scena.matrix.matrix = Matrix.multiply(Matrix.translationMatrix(1 * TRANSLATION_STEP, 0, 0), scena.matrix.matrix);
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery w dół wg. OY*/
    public void translationDownOY() {
        scena.matrix.matrix = Matrix.multiply(Matrix.translationMatrix(0, -1 * TRANSLATION_STEP, 0), scena.matrix.matrix);
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery w górę wg. OY*/
    public void translationUpOY() {
        scena.matrix.matrix = Matrix.multiply(Matrix.translationMatrix(0, 1 * TRANSLATION_STEP, 0), scena.matrix.matrix);
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery do przodu wg. OZ*/
    public void translationForwardOZ() {
        scena.matrix.matrix = Matrix.multiply(Matrix.translationMatrix(0, 0, -1 * TRANSLATION_STEP), scena.matrix.matrix);
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery do tyłu wg. OZ*/
    public void translationBackwardOZ() {
        scena.matrix.matrix = Matrix.multiply(Matrix.translationMatrix(0, 0, 1 * TRANSLATION_STEP), scena.matrix.matrix);
        przetworzScene();

    }

    /**Metoda ma za zadanie obracać obiekt wg. OX przeciwnie do ruchu wskazówek zegara*/
    public void counterClockwiseRotatioOX() {
        scena.matrix.matrix = Matrix.multiply(Matrix.rotationMatrixOX(ROTATION_STEP), scena.matrix.matrix);
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OY zgodnie z ruchem wskazówek zegara*/
    public void clockwiseRotatioOX() {
        scena.matrix.matrix = Matrix.multiply(Matrix.rotationMatrixOX(-1 * ROTATION_STEP), scena.matrix.matrix);
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OY przeciwnie do ruchu wskazówek zegara*/
    public void counterClockwiseRotatioOY() {
        scena.matrix.matrix = Matrix.multiply(Matrix.rotationMatrixOY(ROTATION_STEP), scena.matrix.matrix);
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OY zgodnie z ruchem wskazówek zegara*/
    public void clockwiseRotatioOY() {
        scena.matrix.matrix = Matrix.multiply(Matrix.rotationMatrixOY(-1 * ROTATION_STEP), scena.matrix.matrix);
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OZ przeciwnie do ruchu wskazówek zegara*/
    public void counterClockwiseRotatioOZ() {
        scena.matrix.matrix = Matrix.multiply(Matrix.rotationMatrixOZ(ROTATION_STEP), scena.matrix.matrix);
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OZ zgodnie z ruchem wskazówek zegara*/
    public void clockwiseRotatioOZ() {
        scena.matrix.matrix = Matrix.multiply(Matrix.rotationMatrixOZ(-1 * ROTATION_STEP), scena.matrix.matrix);
        przetworzScene();
    }
    /**Metoda resetuje wszystkie przekształcenia*/
    public void resetTranslation() {
        scena.matrix.matrix = Matrix.identityMatrix();
        this.odl_rzutni = this.poczatkowa_odl_rzutni;
        przetworzScene();
    }
}
