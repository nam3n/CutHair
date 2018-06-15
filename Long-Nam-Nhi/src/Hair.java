import base.GameObject;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;

public class Hair extends GameObject {

    private Vector2D velocity;
    private boolean painted;

    public Hair() {
        this.isAlive = true;
        this.painted = false;
        this.velocity = new Vector2D(0, 5);
        this.renderer = new PolygonRenderer(Color.black);
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(Color.black);

    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);
    }

    @Override
    public void run() {
        super.run();
        if (!isAlive) {
            this.position.addUp(this.velocity);
        }
    }
}
