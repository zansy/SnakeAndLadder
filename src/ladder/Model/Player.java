package ladder.Model;

import java.util.UUID;

public class Player {
    private String id;
    private String name;
    private int currentPosition;

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.currentPosition = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
