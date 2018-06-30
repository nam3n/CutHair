package game;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import scene.GameOverScene;
import scene.SceneManager;

import java.util.Random;

public class Grow extends GameObject {
    private FrameCounter frameCounter;
    private Random random;
    private int orderNumCount;

    public Grow() {
        orderNumCount = 1;
        this.group = 1;
        this.random = new Random();
        this.velocity.set(0, 3);
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
        this.frameCounter = new FrameCounter(2);
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
        if (random.nextInt(100) < 5) {
            int randomNum = random.nextInt(100);
            if (randomNum < 50) {
                this.velocity.set(this.velocity.rotate(10));
            } else {
                this.velocity.set(this.velocity.rotate(-10));
            }
        }
        this.position.addUp(this.velocity);
    }

    private void checkEnd() {
        if (this.position.y > 600) {
            SceneManager.instance.changeScene(new GameOverScene());
        }
    }
}