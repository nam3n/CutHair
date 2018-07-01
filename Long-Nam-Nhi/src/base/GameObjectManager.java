package base;

import game.Grow;
import game.Hair;
import game.Scissor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    private boolean cutedGroup[] = new boolean[10000];
    public int scoreCount;

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
        this.scoreCount++;
        this.list.forEach(GameObject::run);
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

    public void cut() {
        for (int i = 0; i < cutedGroup.length; i++) {
            cutedGroup[i] = false;
        }
        GameObject object = this.list.get(1);
        object.countCut = 5;
        GameObjectManager.instance.list
                .stream()
                .filter(gameObject -> gameObject.position.x > (object.position.x + 30))
                .filter(gameObject -> gameObject.position.x < (object.position.x + 75))
                .filter(gameObject -> gameObject.position.y > object.position.y)
                .filter(gameObject -> gameObject.position.y < (object.position.y + 10))
                .filter(gameObject -> gameObject instanceof Hair)
                .forEach(this::down);
    }

    private void down(GameObject object) {
        if (cutedGroup[object.group]) return;
        cutedGroup[object.group] = true;
        GameObjectManager.instance.list
                .stream()
                .filter(gameObject -> gameObject instanceof Grow)
                .filter(gameObject -> gameObject.group == object.group)
                .forEach(gameObject -> gameObject.position.set(object.position));

        GameObjectManager.instance.list
                .stream()
                .filter(gameObject -> gameObject.group == object.group)
                .filter(gameObject -> (gameObject.orderNum > object.orderNum))
                .forEach(gameObject -> gameObject.velocity.set(0, 10));

    }
}
