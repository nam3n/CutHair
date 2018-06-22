package game;

import base.GameObject;
import base.GameObjectManager;
import renderer.PolygonRenderer;

import java.awt.*;

public class Scissor extends GameObject {

    public Scissor(int x, int y) {
        this.position.set(x, y);
        this.renderer = new PolygonRenderer(Color.red, 20, 20);
    }

    @Override
    public void run() {
        super.run();
        backToAbleZone();
    }

    private void backToAbleZone() {
        if (this.position.y < 190) {
            this.position.y = 190;
        }
        if (this.position.y > 540) {
            this.position.y = 540;
        }
    }

    public void cut() {
        GameObjectManager.instance.cut(this);
    }
}
