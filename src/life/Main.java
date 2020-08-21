package life;

public class Main {
    public static void main(String[] args) {
        GameOfLife window = new GameOfLife();
        Universe universe = new Universe(40);
        window.setDisplay(universe);
        Thread gameController = new GameController(window, universe);
        gameController.start();
    }
}
