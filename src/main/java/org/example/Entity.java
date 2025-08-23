package org.example;

public abstract class Entity {
    private int hp = 15;
    private boolean destroyed = false;
    private String name;
    public Entity(String name) {
        this.name = name;
    }
    public boolean isDestroyed(){
        return destroyed;
    }
    protected boolean damage(int dhp) {
        if(hp-dhp > 0) {
            hp -= dhp;
        }else{
            destroyed = true;
            System.out.println("Entity " + name + " was destroyed");
        }
        return isDestroyed();
    }

}
