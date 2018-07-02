package scene;

import base.GameObjectManager;
import game.Background;
import game.Score;
import renderer.ImageRenderer;
import utils.Utils;

import javax.sound.sampled.Clip;

public class GameOverScene implements Scene {
    private Clip clip;

    @Override
    public void init() {
        this.clip = Utils.loadAudio("resources/GoatScreamSoundEffect.wav");
        this.clip.start();
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
        this.clip.stop();
    }
}