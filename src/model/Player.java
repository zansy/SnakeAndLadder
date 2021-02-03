package model;

import java.util.UUID;

public class Player {
    public final String name;
    private int currentPosition;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(String name) {
        this.name = name;
        this.currentPosition = 0;
    }
}
