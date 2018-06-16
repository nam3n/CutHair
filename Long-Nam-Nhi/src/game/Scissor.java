package game;

import base.GameObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Scissor extends GameObject {

    public Scissor(int x, int y) {
        this.position.set(x, y);
        this.renderer = new PolygonRenderer(Color.red, 20, 20);
    }
}
