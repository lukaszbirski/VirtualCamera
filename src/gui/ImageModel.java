package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.JPanel;
import wirtualnakamera.Krawedz2D;

public class ImageModel extends JPanel {

    Color backgroundColor;
    Color lineColor;
    int width;
    int height;
    public ArrayList<Krawedz2D> krawedzieDoNarysowania;
    BufferedImage bufferedImage;
    boolean rysujBufor = true;  

    public ImageModel(Color backgroundColor, Color lineColor, int width, int height, ArrayList<Krawedz2D> krawedzieDoNarysowania) throws HeadlessException {
        this.backgroundColor = backgroundColor;
        this.lineColor = lineColor;
        this.width = width;
        this.height = height;
        this.krawedzieDoNarysowania = krawedzieDoNarysowania;
        init();
    }

    public void init() {
        setBackground(backgroundColor);
        setForeground(backgroundColor);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(lineColor);
        if (rysujBufor) {
            rysujBufor(g);
            rysujKrawedzie(g);
        } else {
            rysujKrawedzie(g);
        }
    }

    public ArrayList<Krawedz2D> getKrawedzieDoNarysowania() {
        return krawedzieDoNarysowania;
    }

    public void setKrawedzieDoNarysowania(ArrayList<Krawedz2D> krawedzieDoNarysowania) {
        this.krawedzieDoNarysowania = krawedzieDoNarysowania;
    }

    public void rysujKrawedzie(Graphics g) {
        for (Krawedz2D kr : krawedzieDoNarysowania) {
            g.drawLine(kr.punkt1.x, kr.punkt1.y, kr.punkt2.x, kr.punkt2.y);
        }
    }
    
    public void NarysujKrawedzieNaRysunku(ArrayList<Krawedz2D> krw) {
        this.krawedzieDoNarysowania = krw;
        this.repaint();
    }
    
    public void NarysujBufferedImage(BufferedImage bufferedImage) {
        this.krawedzieDoNarysowania = new ArrayList<Krawedz2D>();
        this.bufferedImage  = bufferedImage;
        this.repaint();
        
    }
    
    public void rysujBufor(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, new ImageObserver() {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    
    
}
