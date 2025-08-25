package org.example;

public class Player extends Human {
    public Player(String name) {
        super(name);
    }
    public Backpack backpack = new Backpack();
    public class Backpack{
        String[] inventory = new String[100];
        public String toString() {
            StringBuilder contents = new StringBuilder();
            boolean hasItems = false;

            for (String item : inventory) {
                if (item != null) {
                    if (contents.length() > 0) {
                        contents.append(", ");
                    }
                    contents.append(item);
                    hasItems = true;
                }
            }

            if (!hasItems) {
                return "the backpack is empty";
            } else {
                return contents + " in the backpack";
            }
        }
        public void take(String item) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i]==null) {
                    inventory[i] = item;
                    break;
                }
            }
        }
    }
    public void take(String item) {
        backpack.take(item);
    }

}
