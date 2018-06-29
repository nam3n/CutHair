package base;

import game.Scissor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    public List<GameObject> list;
    private List<GameObject> tempList;

    private GameObjectManager() {
        this.list = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public void clear() {
        this.list.clear();
        this.tempList.clear();
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


    public <T extends GameObject> T recycle(Class<T> cls) {
        T object = (T) this.list.stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);
        if (object != null) {
            object.isAlive = true;
            object.velocity.set(0, 0);
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

    public Scissor findScissor() {
        return (Scissor) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Scissor)
                .findFirst()
                .orElse(null);
    }
}
