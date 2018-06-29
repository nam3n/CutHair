package game;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class Demo extends GameObject {

    public Demo() {
        this.position.set(40, 80);
        this.renderer = new TextRenderer(
                "Space to play.",
                Color.BLACK,
                "resources/FiraMono-Bold.ttf",
                100
        );
    }
}
