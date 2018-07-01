package scene;

import base.GameObjectManager;
import game.Background;
import renderer.ImageRenderer;

public class GameIntroScene implements Scene {
    @Override
    public void init() {
        Background background = new Background();
        background.renderer = new ImageRenderer("resources/introduction.jpg", 1024, 600);
        GameObjectManager.instance.add(background);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
