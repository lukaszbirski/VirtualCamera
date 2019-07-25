package Models.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.JPanel;

import Models.Edge2D;

/**Klasa zawiera definicję sceny (widoku). Zawiera listę listę obiektów do wyświetlenia.*/
public class SceneModel extends JPanel {

    private Color backgroundColor;
    private Color lineColor;
    private int width;
    private int height;
    private ArrayList<Edge2D> listOfEdges2D;
    private BufferedImage bufferedImage;
    private boolean drawBuffer = true;

    public SceneModel(Color backgroundColor, Color lineColor, int width, int height, ArrayList<Edge2D> listOfEdges2D) throws HeadlessException {
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.width = width;
        this.height = height;
        this.listOfEdges2D = listOfEdges2D;
        init();
    }

    /**Inicjuje kolorystykę sceny*/
    public void init() {
        setBackground(backgroundColor);
        setForeground(backgroundColor);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(lineColor);
        if (drawBuffer) {
            drawBuffer(graphics);
            drawEdges2D(graphics);
        } else {
            drawEdges2D(graphics);
        }
    }

    public ArrayList<Edge2D> getListOfEdges2D() {
        return listOfEdges2D;
    }

    public void setListOfEdges2D(ArrayList<Edge2D> listOfEdges2D) {
        this.listOfEdges2D = listOfEdges2D;
    }

    /**Metoda ma za zadanie rysować krawędzie obiektów*/
    public void drawEdges2D(Graphics graphics) {
        for (Edge2D edge2D : listOfEdges2D) {
            graphics.drawLine(edge2D.getPoint1().x, edge2D.getPoint1().y, edge2D.getPoint2().x, edge2D.getPoint2().y);
        }
    }

    /**Metoda wspomaga rysowanie krawędzi obiektów*/
    public void drawListOfEdges2D(ArrayList<Edge2D> listOfEdges2D) {
        this.listOfEdges2D = listOfEdges2D;
        this.repaint();
    }

    /**Metoda wypełnia kolorem obiekty*/
    public void drawBufferedImage(BufferedImage bufferedImage) {
        this.listOfEdges2D = new ArrayList<Edge2D>();
        this.bufferedImage  = bufferedImage;
        this.repaint();
    }
    
    public void drawBuffer(Graphics graphics) {
        graphics.drawImage(bufferedImage, 0, 0, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    
    
}
