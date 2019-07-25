package GUI;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

public class Window extends JFrame {

    public Window(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
}
