package game;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

public class GrowSpawner extends GameObject {
    private FrameCounter frameCounter;
    private int groupCount = 1;

    public GrowSpawner() {
        frameCounter = new FrameCounter(100);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Grow grow = new Grow();
            grow.group = ++this.groupCount;
            GameObjectManager.instance.add(grow);
            this.frameCounter.reset();
        }
    }
}
