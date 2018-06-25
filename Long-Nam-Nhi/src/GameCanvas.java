import base.GameObjectManager;
import constant.Constant;
import game.Background;
import game.Grow;
import game.Nose;
import game.Scissor;
import renderer.ImageRenderer;
import scene.GamePlayScene;
import scene.Scene;
import scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Graphics graphics;
    public Grow leftGrow, rightGrow;
    public Scissor scissor;
    private Nose nose;


    public GameCanvas() {
        this.setSize(Constant.Window.WIDTH, Constant.Window.HEIGHT);
        this.setupBackBuffered();

        SceneManager.instance.changeScene(new GamePlayScene());
        this.setupCharacter();


        this.setVisible(true);
    }

    private void setupCharacter() {
//        Background background = new Background();
//        background.renderer = new ImageRenderer("resources/background.jpg", 1024, 600);
//        GameObjectManager.instance.add(background);
        System.out.println("1");
        this.leftGrow = new Grow(Constant.Grow.LEFT, Constant.Grow.TOP);
        this.rightGrow = new Grow(Constant.Grow.RIGHT, Constant.Grow.TOP);
        GameObjectManager.instance.add(this.leftGrow);
        GameObjectManager.instance.add(this.rightGrow);
        this.scissor = new Scissor(Constant.Grow.LEFT, 300);
        GameObjectManager.instance.add(this.scissor);
        this.nose = new Nose();
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
        this.nose.render(graphics);
        this.repaint();
    }
}