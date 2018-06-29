package scene;

import base.GameObjectManager;
import game.Background;
import game.GrowSpawner;
import game.Scissor;
import renderer.ImageRenderer;

public class GamePlayScene implements Scene {

    @Override
    public void init() {
        Background background = new Background();
        background.renderer = new ImageRenderer("resources/background.jpg", 1024, 600);
        GameObjectManager.instance.add(background);
        GameObjectManager.instance.add(new Scissor(500, 300));
        System.out.println("2");
        GameObjectManager.instance.add(new GrowSpawner());

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
