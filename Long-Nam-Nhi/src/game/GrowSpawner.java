package game;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

public class GrowSpawner extends GameObject {
    private FrameCounter frameCounter;

    public GrowSpawner() {
        frameCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            GameObjectManager.instance.add(new Grow());
            this.frameCounter.reset();
        }
    }
}
