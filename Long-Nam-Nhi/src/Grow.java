import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;

public class Grow extends GameObject {
    private FrameCounter frameCounter;
    private Vector2D velocity;

    public Grow() {
        this.velocity = new Vector2D(0, 20);
        this.position = new Vector2D(600, 300);
        this.frameCounter = new FrameCounter(10);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Hair hair = GameObjectManager.instance.recycle(Hair.class);
            hair.position.set(this.position);
            this.position.addUp(this.velocity);
            this.frameCounter.reset();
        }
    }
}
