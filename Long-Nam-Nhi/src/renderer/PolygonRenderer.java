package renderer;

import base.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PolygonRenderer implements Renderer {
    private Polygon polygon;
    private Color color;
    private List<Vector2D> verties;
    private int width;
    private int height;

    public PolygonRenderer(Color color) {
        this.width = 5;
        this.height = 20;
        this.verties = new ArrayList<>();
        this.color = color;
        this.polygon = new Polygon();
    }

    @Override
    public void render(Vector2D position, Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect((int) position.x, (int) position.y, width, height);
    }
}
