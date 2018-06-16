import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Nose extends GameObject {
    private int width;
    private int height;

    public Nose() {
        this.position = new Vector2D(500, 100);
        this.width = 200;
        this.height = 265;
        renderer = new ImageRenderer("resources/nose0.png", this.width, this.height);
    }

}
