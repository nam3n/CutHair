package base;

import renderer.Renderer;

import java.awt.*;

public class GameObject {
    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;
    public boolean isAlive;
    public int group;
    public int orderNum;
    public int countCut;

    public GameObject() {
        this.orderNum = 0;
        this.group = 0;
        this.velocity = new Vector2D();
        this.isAlive = true;
        this.position = new Vector2D();
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        if (this.renderer == null) return;

        this.renderer.render(this.position, graphics);
    }
}
