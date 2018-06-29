import constant.Constant;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    private long lastTime = 0;
    private GameCanvas gameCanvas;

    public GameWindow() {
        this.setSize(Constant.Window.WIDTH, Constant.Window.HEIGHT); // set size window

        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.event();

        this.setVisible(true);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.scissor.velocity.x = -5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.scissor.velocity.x = 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gameCanvas.scissor.velocity.y = -5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.scissor.velocity.y = 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    gameCanvas.scissor.cut();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.scissor.velocity.x = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.scissor.velocity.x = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gameCanvas.scissor.velocity.y = 0;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.scissor.velocity.y = 0;
                }
            }
        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
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
