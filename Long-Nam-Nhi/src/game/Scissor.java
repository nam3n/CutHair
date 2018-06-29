package game;

import base.GameObject;
import base.GameObjectManager;
import constant.Constant;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;

public class Scissor extends GameObject {

    public Scissor(int x, int y) {
        this.position.set(x, y);
        this.renderer = new ImageRenderer("resources/keo.png", 60, 60);
    }

    @Override
    public void run() {
        super.run();
        backToAbleZone();
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
        System.out.println(this.position.x + " " + this.position.y);
    }

    private void backToAbleZone() {
        if (this.position.y < Constant.Grow.TOP) {
            this.position.y = Constant.Grow.TOP;
        }
        if (this.position.y > 540) {
            this.position.y = 540;
        }
    }

    public void cut() {
        GameObjectManager.instance.list
                .stream()
                .filter(gameObject -> gameObject instanceof Hair)
                .filter(gameObject -> (gameObject.position.x == this.position.x))
                .filter(gameObject -> (gameObject.position.y > this.position.y))
                .forEach(gameObject -> gameObject.velocity.set(0, 10));
    }
}
