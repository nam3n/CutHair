import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;

public class Hair extends GameObject {

    private Vector2D velocity;

    public Hair() {
        this.isAlive = true;
        this.velocity = new Vector2D(0, 5);
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(Color.black);

    }

    @Override
    public void run() {
        super.run();
        if (!isAlive) {
            this.position.addUp(this.velocity);
        }
    }
}
