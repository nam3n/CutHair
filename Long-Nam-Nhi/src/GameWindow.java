import base.GameObjectManager;
import constant.Constant;
import scene.*;

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
                if (SceneManager.instance.currentScene instanceof GamePlayScene) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        GameObjectManager.instance.list.get(1).velocity.x = -Constant.Scissor.SPEED;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        GameObjectManager.instance.list.get(1).velocity.x = Constant.Scissor.SPEED;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        GameObjectManager.instance.list.get(1).velocity.y = -Constant.Scissor.SPEED;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        GameObjectManager.instance.list.get(1).velocity.y = Constant.Scissor.SPEED;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (SceneManager.instance.currentScene instanceof GamePlayScene) {
                        GameObjectManager.instance.cut();
                    } else if (SceneManager.instance.currentScene instanceof GameIntroScene)
                        SceneManager.instance.changeScene(new GamePlayScene());
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (SceneManager.instance.currentScene instanceof GameOverScene) {
                        SceneManager.instance.changeScene(new GamePlayScene());
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        GameObjectManager.instance.list.get(1).velocity.x = 0;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        GameObjectManager.instance.list.get(1).velocity.x = 0;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        GameObjectManager.instance.list.get(1).velocity.y = 0;
                    }
                    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        GameObjectManager.instance.list.get(1).velocity.y = 0;
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