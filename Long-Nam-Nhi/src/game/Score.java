package game;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class Score extends GameObject {

    public Score(String string) {
        this.position.set(270, 360);
        this.renderer = new TextRenderer(
                string + "",
                Color.WHITE,
                "resources/FiraMono-Bold.ttf",
                100
        );
    }
}
