package base;

import renderer.Renderer;

import java.awt.*;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;
    public boolean isAlive;

    public GameObject() {
        this.position = new Vector2D();
    }

    public void run() {
    }

    public void render(Graphics graphics) {
        if (this.renderer == null) return;

        this.renderer.render(this.position, graphics);
    }
}
