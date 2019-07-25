import Controllers.Controller;
import Controllers.Key;
import Models.GUI.SceneModel;
import Models.GUI.Window;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyboardFocusManager;
import javax.swing.JTextArea;
import wirtualnakamera.Scena;
import wirtualnakamera.TestowaScena;
import wirtualnakamera.VirtualCamera;

public class Main {

    static final int SZEROKOSC_OBRAZU = 650;
    static final int WYSOKOSC_OBRAZU = 650;
    static final Color kolorTla = Color.WHITE;
    static final Color kolorLinii = Color.RED;
    static final double POCZATKOWA_ODLEGLOSC_RZUTOWANIA = 1;

    public static void main(String Args[]) {
        Window window = new Window("Wirtualna kamera - Łukasz Birski");
        Key key = new Key();
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(key);

        String instrukcja = "Sterowanie: Translacje: oś OX - a d , oś OY - w s , oś OZ - q e ; Obroty: oś OX - l j , oś OY - i k, oś OZ - o u ; Przyblizanie: = -";

        Scena scena = TestowaScena.stworzScene();

        VirtualCamera wk = new VirtualCamera(scena, POCZATKOWA_ODLEGLOSC_RZUTOWANIA, WYSOKOSC_OBRAZU, SZEROKOSC_OBRAZU);
        wk.przetworzScene();

        SceneModel rys = new SceneModel(kolorTla, kolorLinii, SZEROKOSC_OBRAZU, WYSOKOSC_OBRAZU, wk.getKrawedzieDoNarysowania());
        rys.setSize(SZEROKOSC_OBRAZU, WYSOKOSC_OBRAZU);
        
        JTextArea text= new JTextArea(instrukcja);
        text.setEditable(false);
        window.getContentPane().add(text,BorderLayout.SOUTH);
        window.setFocusable(true);

        window.getContentPane().add(rys, BorderLayout.CENTER);
        rys.init();

        Controller kontroler = new Controller(rys, wk);
        key.setController(kontroler);

        window.pack();
        window.setSize(new Dimension(SZEROKOSC_OBRAZU + 120, WYSOKOSC_OBRAZU + 50));
        window.setVisible(true);

        kontroler.draw();

    }
}
