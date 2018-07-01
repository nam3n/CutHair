package game;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import scene.GameOverScene;
import scene.SceneManager;

import java.util.Random;

public class Grow extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private int orderNumCount;
    private Vector2D velocityRoot;

    public Grow() {
        this.velocityRoot = new Vector2D(0, 3);
        this.orderNumCount = 1;
        this.group = 1;
        this.random = new Random();
        this.velocity.set(this.velocityRoot);
        int x, y;
        if (this.random.nextInt(2) == 0) {
            y = 290;
        } else {
            y = 295;
        }
        if (y == 295) {
            x = random.nextInt(31) + 380;
        } else {
            x = random.nextInt(31) + 575;
        }
        this.position.set(x, y);
        this.frameCounter = new FrameCounter(1);
    }

    @Override
    public void run() {
        if (this.frameCounter.run()) {
            Hair hair = GameObjectManager.instance.recycle(Hair.class);
            hair.position.set(this.position);
            hair.group = this.group;
            hair.orderNum = this.orderNumCount++;
            this.move();
            this.checkEnd();
            this.frameCounter.reset();
        }
    }

    private void move() {
        if (random.nextInt(100) < 20) {
            int randomNum = random.nextInt(20) - 10;
            this.velocity.set(this.velocity.rotate(randomNum));
        }
        this.position.addUp(this.velocity);
    }

    private void checkEnd() {
        if (this.position.y > 600) {
            SceneManager.instance.changeScene(new GameOverScene());
        }
    }
}