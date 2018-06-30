package scene;

import base.GameObjectManager;
import game.Background;
import game.Demo;
import renderer.ImageRenderer;

public class GameStartScene implements Scene {
    @Override
    public void init() {
        Background background = new Background();
        background.renderer = new ImageRenderer("resources/Game-start.jpg", 1024, 600);
        GameObjectManager.instance.add(background);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
