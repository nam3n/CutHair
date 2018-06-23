package game;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Nose extends GameObject {

    public Nose() {
        this.position = new Vector2D(500, 100);
        int width = 200;
        int height = 265;
        renderer = new ImageRenderer("resources/nose0.png", width, height);
    }

}
