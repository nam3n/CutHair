package scene;

import base.GameObjectManager;
import game.Background;
import renderer.ImageRenderer;

public class GameOverScene implements Scene {

    @Override
    public void init() {
        Background background = new Background();
        background.renderer = new ImageRenderer("C:\\Users\\Long\\IdeaProjects\\N-L-N (3)\\Long-Nam-Nhi\\resources\\Game Over.jpg", 1024, 600);
        GameObjectManager.instance.add(background);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }
}
