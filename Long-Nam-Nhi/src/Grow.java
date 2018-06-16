import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

public class Grow extends GameObject {
    private FrameCounter frameCounter;

    public Grow(int x, int y) {
        this.velocity.set(0, 3);
        this.position.set(x, y);
        this.frameCounter = new FrameCounter(2);
    }

    @Override
    public void run() {
        if (this.frameCounter.run()) {
            Hair hair = GameObjectManager.instance.recycle(Hair.class);
            hair.position.set(this.position);
            this.position.addUp(this.velocity);
            this.frameCounter.reset();
        }
    }
}
