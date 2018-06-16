import base.GameObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Hair extends GameObject {
    public Hair() {
        this.isAlive = true;
        this.renderer = new PolygonRenderer(Color.black);
    }
}
