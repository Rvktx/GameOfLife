package life;

import javax.swing.*;

public class GameController extends Thread {
    private final GameOfLife window;
    private Universe universe;

    private final JToggleButton pauseButton;
    private final JButton resetButton;

    private boolean paused;
    private boolean running;

    public GameController(GameOfLife window, Universe universe) {
        this.window = window;
        this.universe = universe;
        this.pauseButton = this.window.getControl().getPauseButton();
        this.resetButton = this.window.getControl().getResetButton();

        this.paused = false;
        this.running = true;
    }

    @Override
    public void run() {
        this.window.setDisplay(this.universe);

        while (running) {
            this.pauseListener();
            this.resetListener();

            if (paused) continue;

            Thread viewController = new ViewController(this.window, this.universe);
            viewController.start();

            try {
                viewController.join();
            } catch (InterruptedException e) {
                System.out.print("Error");
            }

            this.universe = this.universe.advance();

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.print("Error");
            }
        }
    }

    public void resetListener() {
        resetButton.addActionListener(event -> {
            if (pauseButton.isSelected()) pauseButton.doClick();
            paused = false;
            this.universe = new Universe(40);
        });
    }

    public void pauseListener() {
        pauseButton.addActionListener(event -> {
            if (pauseButton.isSelected()) {
                pauseButton.doClick();
                paused = !paused;
                pauseButton.setText(paused ? "RESUME" : "PAUSE");
            }
        });
    }
}

class ViewController extends Thread {
    private final GameOfLife window;
    private final Universe universe;

    public ViewController(GameOfLife window, Universe universe) {
        this.window = window;
        this.universe = universe;
    }

    @Override
    public void run() {
        this.window.getControl().getGenLabel().setText("Generation #" + this.universe.getAge());
        this.window.getControl().getGenLabel().repaint();

        this.window.getControl().getAliveLabel().setText("Alive: " + this.universe.getAliveCount());
        this.window.getControl().getAliveLabel().repaint();

        this.window.getDisplay().update(universe);
    }
}