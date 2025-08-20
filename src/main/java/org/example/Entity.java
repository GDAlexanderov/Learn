package org.example;

public abstract class Entity {
    private int hp;
    private String className;
    public Entity(int hp, String className) {
        this.hp = hp;
        this.className = className;
    }
    public int getHp() {
        return hp;
    }
    public String getClassName() {
        return className;
    }

    public abstract void Roar();
}
