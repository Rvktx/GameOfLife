package life;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Display extends JPanel {
    private boolean[][] universe;

    public Display(boolean[][] universe) {
        super();
        this.universe = universe;
        this.setLayout(null);
        this.setBounds(400, 0, 800, 800);
        this.setBorder(new EmptyBorder(0, 0, 0, 0));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.setColor(Color.BLACK);

        if (this.universe != null) {
            for (int i = 20; i < 800; i += 20)
                g.drawLine(i, 0, i, 800);

            for (int i = 20; i <= 800; i += 20)
                g.drawLine(0, i, 800, i);

            for (int i = 0; i < 40; i++)
                for (int j = 0; j < 40; j++)
                    if (universe[i][j])
                        g.fillRect(i * 20, j * 20, 20, 20);
        }
    }

    void update(Universe universe) {
        this.universe = universe.getVisibleState();
        repaint();
    }
}
