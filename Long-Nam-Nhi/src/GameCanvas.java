import base.GameObjectManager;
import constant.Constant;
import game.Grow;
import game.GrowSpawner;
import game.Scissor;
import scene.GamePlayScene;
import scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Graphics graphics;
    public Scissor scissor;


    public GameCanvas() {
        this.setSize(Constant.Window.WIDTH, Constant.Window.HEIGHT);
        this.setupBackBuffered();

        SceneManager.instance.changeScene(new GamePlayScene());
        this.setupCharacter();


        this.setVisible(true);
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new GrowSpawner());
//        GameObjectManager.instance.add(new Grow());
        this.scissor = new Scissor(600, 300);
        GameObjectManager.instance.add(this.scissor);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        SceneManager.instance.performChangeSceneIfNeeded();
    }
    @Override
    protected void paintComponent(Graphics g) {
        // lat backbuffered
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }
}