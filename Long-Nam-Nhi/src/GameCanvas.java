import base.GameObjectManager;
import game.Background;
import game.Grow;
import game.Nose;
import game.Scissor;
import scene.GamePlayScene;
import scene.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    private BufferedImage backBuffered;
    private Graphics graphics;
    public Grow leftGrow, rightGrow;
    public Scissor scissor;


    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();

        SceneManager.instance.changeScene(new GamePlayScene());
        this.setupCharacter();


        this.setVisible(true);
    }

    private void setupCharacter() {
        this.leftGrow = new Grow(450, 189);
        this.rightGrow = new Grow(550, 189);
        GameObjectManager.instance.add(this.leftGrow);
        GameObjectManager.instance.add(this.rightGrow);
        this.scissor = new Scissor(450, 300);
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