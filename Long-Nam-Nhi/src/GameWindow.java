import javax.swing.*;

public class GameWindow extends JFrame {
    private long lastTime = 0;
    GameCanvas gameCanvas;

    public GameWindow() {
        this.setSize(1024, 600); // set size window

        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
//        this.event();

        this.setVisible(true);
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }

        }
    }
}
