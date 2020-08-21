package life;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private final JLabel genLabel;
    private final JLabel aliveLabel;
    private final JToggleButton pauseButton;
    private final JButton resetButton;

    public ControlPanel() {
        this.genLabel = new JLabel();
        this.genLabel.setName("GenerationLabel");
        this.genLabel.setText("Generation #" + 0);
        this.genLabel.setSize(new Dimension(400, 10));

        this.aliveLabel = new JLabel();
        this.aliveLabel.setName("AliveLabel");
        this.aliveLabel.setText("Alive: " + 0);
        this.aliveLabel.setBounds(5, 20, 395, 10);

        this.pauseButton = new JToggleButton();
        this.pauseButton.setText("PAUSE");
        this.pauseButton.setName("PlayToggleButton");

        this.resetButton = new JButton();
        this.resetButton.setText("RESET");
        this.resetButton.setName("ResetButton");

        JPanel statusBanner = new JPanel(new GridLayout(2, 1));
        statusBanner.setBounds(0,0,400, 40);

        statusBanner.add(genLabel);
        statusBanner.add(aliveLabel);

        JPanel buttonSection = new JPanel(new GridLayout(1, 2, 10, 20));
        buttonSection.add(pauseButton);
        buttonSection.add(resetButton);

        this.add(statusBanner, BorderLayout.NORTH);
        this.add(buttonSection, BorderLayout.CENTER);
    }

    public JToggleButton getPauseButton() {
        return pauseButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JLabel getGenLabel() {
        return genLabel;
    }

    public JLabel getAliveLabel() {
        return aliveLabel;
    }
}
