package game;

import base.FrameCounter;
import base.GameObject;
import constant.Constant;
import renderer.ImageRenderer;
import renderer.Renderer;

import java.awt.*;

public class Scissor extends GameObject {
    private Renderer openSci;
    private Renderer closeSci;


    public Scissor(int x, int y) {
        this.position.set(x, y);
        this.openSci = new ImageRenderer("resources/keo.png", 100, 150);
        this.closeSci = new ImageRenderer("resources/closesnipper.png", 100, 150);
        this.renderer =openSci;
    }

    @Override
    public void run() {
        super.run();
        backToAbleZone();
    }

    @Override
    public void render(Graphics graphics) {
        if (countCut != 0) {
            this.countCut--;
            this.renderer = this.closeSci;
        } else {
            this.renderer = this.openSci;
        }
        super.render(graphics);
    }

    private void backToAbleZone() {
        if (this.position.y < Constant.Grow.TOP) {
            this.position.y = Constant.Grow.TOP;
        }
        if (this.position.y > 540) {
            this.position.y = 540;
        }
    }
}