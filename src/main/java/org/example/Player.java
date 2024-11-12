package org.example;

public class Player {
    private String name;
    private boolean isHuman;

    public Player(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public String getName() {
        return name;
    }
}