package game;

import base.FrameCounter;
import base.GameObject;
import renderer.BackgroundRenderer;
import renderer.ImageRenderer;
import scene.GameIntroScene;
import scene.SceneManager;

import java.awt.*;

public class Background extends GameObject {
    public boolean autoChangeScene;
    private FrameCounter frameCounter;
    public Background() {
        frameCounter = new FrameCounter(80);
        autoChangeScene = false;
    }

    @Override
    public void run() {
        super.run();
        if (autoChangeScene) {
            if (frameCounter.run()) {
                autoChangeScene = false;
                SceneManager.instance.changeScene(new GameIntroScene());
            }
        }
    }
}
