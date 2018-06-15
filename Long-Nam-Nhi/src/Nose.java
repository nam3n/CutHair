import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;
import renderer.Renderer;

public class Nose extends GameObject {
    private int width;
    private int height;
    private Renderer renderer;

    public Nose() {
        System.out.println("nose");
        this.position = new Vector2D(300, 300);
        this.width = 200;
        this.height = 300;
        renderer = new ImageRenderer("resources/nose.png", this.width, this.height);
    }

}
