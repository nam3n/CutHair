package scene;

import base.GameObjectManager;
import game.Background;
import game.Score;
import renderer.ImageRenderer;

public class GameOverScene implements Scene {

    @Override
    public void init() {
        Background background = new Background();
        background.renderer = new ImageRenderer("resources/end.jpg", 1024, 600);
        GameObjectManager.instance.add(background);
        GameObjectManager.instance.add(new Score(
                Integer.toString(GameObjectManager.instance.scoreCount / 30)
        ));
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}