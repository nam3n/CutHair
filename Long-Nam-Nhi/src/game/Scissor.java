package game;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import constant.Constant;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;

import java.awt.*;
import java.util.List;
import java.util.stream.Stream;

public class Scissor extends GameObject {

    private boolean cutedGroup[] = new boolean[10000];

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
        for (int i = 0; i < cutedGroup.length; i++) {
            cutedGroup[i] = false;
        }
        GameObjectManager.instance.list
                .stream()
                .filter(gameObject -> gameObject.position.x > (this.position.x + 15))
                .filter(gameObject -> gameObject.position.x < (this.position.x + 45))
                .filter(gameObject -> gameObject.position.y > this.position.y)
                .filter(gameObject -> gameObject.position.y < (this.position.y + 30))
                .filter(gameObject -> gameObject instanceof Hair)
                .forEach(this::down);
    }

    private void down(GameObject object) {
        if (cutedGroup[object.group]) return;
        cutedGroup[object.group] = true;
            GameObjectManager.instance.list
                    .stream()
                    .filter(gameObject -> gameObject instanceof Grow)
                    .filter(gameObject -> gameObject.group == object.group)
                    .forEach(gameObject -> gameObject.position.set(object.position));

            GameObjectManager.instance.list
                    .stream()
                    .filter(gameObject -> gameObject.group == object.group)
                    .filter(gameObject -> (gameObject.orderNum > object.orderNum))
                    .forEach(gameObject -> gameObject.velocity.set(0, 10));

    }
}