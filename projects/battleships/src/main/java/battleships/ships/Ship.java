package battleships.ships;

import battleships.ConsoleColors;

public class Ship {

    private final int size;
    private int life;
    private final String name;
    private String color;

    public Ship(int size, String name, String color) {
        this.size = size;
        this.life = size;
        this.name = name;
        this.color = color;
    }

    public int getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isDestroyed() {
        return life <= 0;
    }

    public boolean hit() {
        if (!isDestroyed()) {
            life--;
        }
        return isDestroyed();
    }
}