package renderer;

import base.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void setPolygonPosition(Vector2D position) {
        this.verties = Arrays.asList(
                new Vector2D(position.x, position.y),
                new Vector2D(position.x + width, position.y),
                new Vector2D(position.x + width, position.y + height),
                new Vector2D(position.x, position.y + height)
        );
        this.verties.forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int) vector2D.y));
    }

    @Override
    public void render(Vector2D position, Graphics graphics) {
        graphics.setColor(this.color);
        this.setPolygonPosition(position);
        graphics.fillPolygon(this.polygon);
    }
}
