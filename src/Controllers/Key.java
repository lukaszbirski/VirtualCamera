package Controllers;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener, KeyEventDispatcher {

    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.toString());

        if (e.getKeyChar() == '=') {
            controller.drewZoomIn();

        }
        if (e.getKeyChar() == '-') {
            controller.drewZoomOut();
        }
        if (e.getKeyChar() == 'd') {
            controller.drewTranslationInRightOX();
        }
        if (e.getKeyChar() == 'a') {
            controller.drewTranslationInLeftOX();
        }
        if (e.getKeyChar() == 'q') {
            controller.drewtranslationUpOY();
        }
        if (e.getKeyChar() == 'e') {
            controller.drewtranslationDownOY();
        }
        if (e.getKeyChar() == 'w') {
            controller.drewTranslationForwardOZ();
        }
        if (e.getKeyChar() == 's') {
            controller.drewTranslationBackwardOZ();
        }
        if (e.getKeyChar() == 'l') {
            controller.drewCounterClockwiseRotatioOX();
        }
        if (e.getKeyChar() == 'j') {
            controller.drewClockwiseRotatioOX();
        }
        if (e.getKeyChar() == 'i') {
            controller.drewCounterClockwiseRotatioOY();
        }
        if (e.getKeyChar() == 'k') {
            controller.drewClockwiseRotatioOY();
        }
        if (e.getKeyChar() == 'o') {
            controller.drewCounterClockwiseRotatioOZ();
        }
        if (e.getKeyChar() == 'u') {
            controller.drewClockwiseRotatioOZ();
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            controller.resetTransformation();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getKeyChar() == '=') {
            controller.drewZoomIn();

        }
        if (e.getKeyChar() == '-') {
            controller.drewZoomOut();
        }
        if (e.getKeyChar() == 'd') {
            controller.drewTranslationInRightOX();
        }
        if (e.getKeyChar() == 'a') {
            controller.drewTranslationInLeftOX();
        }
        if (e.getKeyChar() == 'q') {
            controller.drewtranslationUpOY();
        }
        if (e.getKeyChar() == 'e') {
            controller.drewtranslationDownOY();
        }
        if (e.getKeyChar() == 'w') {
            controller.drewTranslationForwardOZ();
        }
        if (e.getKeyChar() == 's') {
            controller.drewTranslationBackwardOZ();
        }
        if (e.getKeyChar() == 'l') {
            controller.drewClockwiseRotatioOY();
        }
        if (e.getKeyChar() == 'j') {
            controller.drewCounterClockwiseRotatioOY();
        }
        if (e.getKeyChar() == 'i') {
            controller.drewCounterClockwiseRotatioOX();
        }
        if (e.getKeyChar() == 'k') {
            controller.drewClockwiseRotatioOX();
        }
        if (e.getKeyChar() == 'o') {
            controller.drewCounterClockwiseRotatioOZ();
        }
        if (e.getKeyChar() == 'u') {
            controller.drewClockwiseRotatioOZ();
        }
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            controller.resetTransformation();
        }
        if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            controller.turnOnDrowing();
        }
        return false;
    }
}
