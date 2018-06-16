package base;

import game.Hair;
import game.Scissor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void add(GameObject gameObject) {
        this.tempList.add(gameObject);
    }

    public void runAll() {
        this.list.forEach(gameObject -> gameObject.run());
        this.list.addAll(this.tempList);
        this.tempList.clear();
    }

    public void renderAll(Graphics graphics) {
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

    public void cut(Scissor scissor) {
        this.list.stream()
                .filter(gameObject -> gameObject instanceof Hair)
                .filter(gameObject -> (gameObject.position.x == scissor.position.x))
                .filter(gameObject -> (gameObject.position.y > scissor.position.y))
                .forEach(gameObject -> gameObject.velocity.set(0, 10));
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        T object = (T) this.list.stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);
        if (object != null) {
            // do something
        } else {
            try {
                object = cls.newInstance();
                this.add(object);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return object;
    }
}
