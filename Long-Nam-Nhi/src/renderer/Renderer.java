package renderer;

import base.Vector2D;

import java.awt.*;

public interface Renderer {
    void render(Vector2D position, Graphics graphics);
}
