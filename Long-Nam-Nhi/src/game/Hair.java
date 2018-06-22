package game;

import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;

public class Hair extends GameObject {

    public Vector2D velocity;

    public Hair() {
        this.renderer = new PolygonRenderer(Color.black, 5, 3);
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        if (this.position.y >= 700) {
            this.isAlive = false;
        }
    }
}
