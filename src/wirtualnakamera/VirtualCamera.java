/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wirtualnakamera;

import java.awt.Color;
import java.util.ArrayList;

import Algorithms.Matrix;
import Algorithms.ProjectionAlgorithms;
import Models.Edge2D;
import Models.Point3D;
import Models.Wall;
import zaslanianie.Algorytm;
import zaslanianie.BuforEkranu;

/**
 *
 * @author rafal
 */
public class VirtualCamera {

    Scene scena;
    public double odl_rzutni;
    double poczatkowa_odl_rzutni;
    ProjectionAlgorithms rzut;
    public Kamera kamera;
    public Widok widok;
    int wysokosc;
    int szerokosc;
    //   ArrayList<Edge3D> krawedzie;
    static final double ZOOM_STEP = 0.01;
    static final double TRANSLATION_STEP = 0.5;
    static final double ROTATION_STEP = 0.01;
    public BuforEkranu ekran;
    Color kolorTla = Color.GRAY;

    public VirtualCamera(Scene scena, double odl_rzutni, int wysokosc, int szerokosc) {
        this.poczatkowa_odl_rzutni = odl_rzutni;
        this.scena = scena;
        this.odl_rzutni = odl_rzutni;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
    }

    public void przetworzScene() {

        ArrayList<Wall> sciany = new ArrayList<Wall>();
        for (Wall s : scena.sciany) {         //transformacje scian

            Point3D npkt1 = new Point3D(Matrix.multiply(scena.matrix.getMatrix(), s.getPoint1().tmpVector()));
            npkt1.normalization();
            Point3D npkt2 = new Point3D(Matrix.multiply(scena.matrix.getMatrix(), s.getPoint2().tmpVector()));
            npkt2.normalization();
            Point3D npkt3 = new Point3D(Matrix.multiply(scena.matrix.getMatrix(), s.getPoint3().tmpVector()));
            npkt3.normalization();
            Point3D npkt4 = new Point3D(Matrix.multiply(scena.matrix.getMatrix(), s.getPoint4().tmpVector()));
            npkt4.normalization();
            Wall ns = new Wall(npkt1, npkt2, npkt3, npkt4, s.getColor());
            sciany.add(ns);
        }

        sciany = Scene.backfaceCulling(sciany);

        rzut = new ProjectionAlgorithms(odl_rzutni);
        sciany = rzut.projectWallList(sciany);
        kamera = new Kamera();
        sciany = kamera.przytnijScianyDoKamery(sciany);
        widok = new Widok(wysokosc, szerokosc, kamera);

        Algorytm algorytm = new Algorytm(widok.krawedzieNaWidoku, sciany, wysokosc, szerokosc, kolorTla, odl_rzutni, widok);
        ekran = algorytm.eliminuj();
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
        scena.matrix.setMatrix(Matrix.multiply(Matrix.translationMatrix(-1 * TRANSLATION_STEP, 0, 0), scena.matrix.getMatrix()));
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery w lewo wg. OX*/
    public void translationInLeftOX() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.translationMatrix(1 * TRANSLATION_STEP, 0, 0), scena.matrix.getMatrix()));
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery w dół wg. OY*/
    public void translationDownOY() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.translationMatrix(0, -1 * TRANSLATION_STEP, 0), scena.matrix.getMatrix()));
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery w górę wg. OY*/
    public void translationUpOY() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.translationMatrix(0, 1 * TRANSLATION_STEP, 0), scena.matrix.getMatrix()));
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery do przodu wg. OZ*/
    public void translationForwardOZ() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.translationMatrix(0, 0, -1 * TRANSLATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();

    }

    /**Metoda przesuwa widok kamery do tyłu wg. OZ*/
    public void translationBackwardOZ() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.translationMatrix(0, 0, 1 * TRANSLATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();

    }

    /**Metoda ma za zadanie obracać obiekt wg. OX przeciwnie do ruchu wskazówek zegara*/
    public void counterClockwiseRotatioOX() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.rotationMatrixOX(ROTATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OY zgodnie z ruchem wskazówek zegara*/
    public void clockwiseRotatioOX() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.rotationMatrixOX(-1 * ROTATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OY przeciwnie do ruchu wskazówek zegara*/
    public void counterClockwiseRotatioOY() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.rotationMatrixOY(ROTATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OY zgodnie z ruchem wskazówek zegara*/
    public void clockwiseRotatioOY() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.rotationMatrixOY(-1 * ROTATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OZ przeciwnie do ruchu wskazówek zegara*/
    public void counterClockwiseRotatioOZ() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.rotationMatrixOZ(ROTATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();
    }

    /**Metoda ma za zadanie obracać obiekt wg. OZ zgodnie z ruchem wskazówek zegara*/
    public void clockwiseRotatioOZ() {
        scena.matrix.setMatrix(Matrix.multiply(Matrix.rotationMatrixOZ(-1 * ROTATION_STEP), scena.matrix.getMatrix()));
        przetworzScene();
    }
    /**Metoda resetuje wszystkie przekształcenia*/
    public void resetTranslation() {
        scena.matrix.setMatrix(Matrix.identityMatrix());
        this.odl_rzutni = this.poczatkowa_odl_rzutni;
        przetworzScene();
    }
}
