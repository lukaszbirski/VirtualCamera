package Controllers;

import Models.GUI.SceneModel;
import wirtualnakamera.VirtualCamera;

/**Klasa służy do połączenia obsługi klawiszy z przekształceniami (macierzami przekształceń)*/
public class Controller {

    SceneModel drawing;
    VirtualCamera virtualCamera;
    private boolean checkIfBoardersAreVisible = false;

    public Controller(SceneModel drawing, VirtualCamera virtualCamera) {
        this.drawing = drawing;
        this.virtualCamera = virtualCamera;
    }

    /**Metoda rysuje scenę po przybliżeniu*/
    public void drewZoomIn() {
        this.virtualCamera.zoomIn();
        this.draw();
    }

    /**Metoda rysuje scenę po oddaleniu*/
    public void drewZoomOut() {
        this.virtualCamera.zoomOut();
        this.draw();
    }

    /**Metoda rysuje widok po przesunięciu widoku kamery w prawo*/
    public void drewTranslationInRightOX() {
        this.virtualCamera.translationInRightOX();
        this.draw();
    }

    /**Metoda rysuje widok po przesunięciu widoku kamery w lewo*/
    public void drewTranslationInLeftOX() {
        this.virtualCamera.translationInLeftOX();
        this.draw();
    }

    /**Metoda rysuje widok po przesunięciu widoku kamery w dół*/
    public void drewtranslationDownOY() {
        this.virtualCamera.translationDownOY();
        this.draw();
    }

    /**Metoda rysuje widok po przesunięciu widoku kamery w górę*/
    public void drewtranslationUpOY() {
        this.virtualCamera.translationUpOY();
        this.draw();
    }

    /**Metoda rysuje widok po przesunięciu widoku kamery do przodu*/
    public void drewTranslationForwardOZ() {
        this.virtualCamera.translationForwardOZ();
        this.draw();
    }

    /**Metoda rysuje widok po przesunięciu widoku kamery do tyłu*/
    public void drewTranslationBackwardOZ() {
        this.virtualCamera.translationBackwardOZ();
        this.draw();
    }

    /**Metoda rysuje obiekt po obróceniu go wg. OX przeciwnie do ruchu wskazówek zegara*/
    public void drewCounterClockwiseRotatioOX() {
        this.virtualCamera.counterClockwiseRotatioOX();
        this.draw();
    }

    /**Metoda rysuje obiekt po obróceniu go wg. OX zgodnie z ruchem wskazówek zegara*/
    public void drewClockwiseRotatioOX() {
        this.virtualCamera.clockwiseRotatioOX();
        this.draw();
    }

    /**Metoda rysuje obiekt po obróceniu go wg. OY przeciwnie do ruchu wskazówek zegara*/
    public void drewCounterClockwiseRotatioOY() {
        this.virtualCamera.counterClockwiseRotatioOY();
        this.draw();
    }

    /**Metoda rysuje obiekt po obróceniu go wg. OY zgodnie z ruchem wskazówek zegara*/
    public void drewClockwiseRotatioOY() {
        this.virtualCamera.clockwiseRotatioOY();
        this.draw();
    }

    /**Metoda rysuje obiekt po obróceniu go wg. OZ przeciwnie do ruchu wskazówek zegara*/
    public void drewCounterClockwiseRotatioOZ() {
        this.virtualCamera.counterClockwiseRotatioOZ();
        this.draw();
    }

    /**Metoda rysuje obiekt po obróceniu go wg. OZ zgodnie z ruchem wskazówek zegara*/
    public void drewClockwiseRotatioOZ() {
        this.virtualCamera.clockwiseRotatioOZ();
        this.draw();
    }

    /**Metoda ma za zadanie naryzować pierwotne ustawienie widoku*/
    public void resetTransformation() {
        this.virtualCamera.resetTranslation();
        this.draw();
    }

    /**Metoda rysuje krawędzie obiektów*/
    public void turnOnDrowing() {
        this.checkIfBoardersAreVisible = ! this.checkIfBoardersAreVisible;
        this.draw();
    }

    /**Metoda rysuje obiekt*/
    public void draw() {

        this.drawing.drawBufferedImage(this.virtualCamera.getBuforEkranu().przeksztalcNaBufferedImage());
        if (checkIfBoardersAreVisible) {
            this.drawing.drawListOfEdges2D(virtualCamera.getKrawedzieDoNarysowania());
        }

    }
}

