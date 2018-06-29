package game;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
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
//        System.out.println(this.position.x + " " + this.position.y);
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
        Hair hair = (Hair) GameObjectManager.instance.list
                .stream()
                .filter(gameObject -> gameObject.position.x > (this.position.x + 15))
                .filter(gameObject -> gameObject.position.x < (this.position.x + 45))
                .filter(gameObject -> gameObject.position.y > this.position.y)
                .filter(gameObject -> gameObject.position.y < (this.position.y + 30))
                .filter(gameObject -> gameObject instanceof Hair)
                .findFirst()
                .orElse(null);
        if (hair != null) {
            GameObjectManager.instance.list
                    .stream()
                    .filter(gameObject -> gameObject instanceof Grow)
                    .filter(gameObject -> gameObject.group == hair.group)
                    .forEach(gameObject -> gameObject.position.set(hair.position));

            GameObjectManager.instance.list
                    .stream()
                    .filter(gameObject -> gameObject.group == hair.group)
                    .filter(gameObject -> (gameObject.position.y > hair.position.y))
                    .forEach(gameObject -> gameObject.velocity.set(0, 10));

        }
    }
}
