package life;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JFrame {
    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 828;

    private ControlPanel control;
    private Display display;


    public GameOfLife() {
        super("Game of Life");
        this.setName("GameOfLife");
        this.setTitle("Game of Life");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.initComponents();
    }

    private void initComponents() {
        this.control = new ControlPanel();
        this.add(this.control, BorderLayout.WEST);
    }

    public ControlPanel getControl() {
        return this.control;
    }

    public Display getDisplay() {
        return this.display;
    }

    public void setDisplay(Universe universe) {
        this.display = new Display(universe.getVisibleState());
        this.add(this.display, BorderLayout.CENTER);
    }
}
