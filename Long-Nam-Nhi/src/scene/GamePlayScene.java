package scene;

import base.GameObjectManager;
import game.Background;
import game.GrowSpawner;
import game.Scissor;
import renderer.ImageRenderer;

public class GamePlayScene implements Scene {

    @Override
    public void init() {
        GameObjectManager.instance.scoreCount = 0;
        Background background = new Background();
        background.renderer = new ImageRenderer("resources/background.jpg", 1024, 600);
        GameObjectManager.instance.add(background);
        GameObjectManager.instance.add(new Scissor(500, 400));
        GameObjectManager.instance.add(new GrowSpawner());
//        GameObjectManager.instance.add(new Grow());

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
