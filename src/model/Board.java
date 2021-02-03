package model;

import java.util.List;

public class Board {
    public final List<Player> players;
    private boolean isTwodices;
    private int size;

    public Board(List<Player> players) {
        this.players = players;
        isTwodices = false;
        this.size = 100;
    }
    public Board(List<Player> players, boolean isTwodices){
        this(players);
        this.isTwodices = isTwodices;
    }
    public Board(List<Player> players, boolean isTwodices, int size){
        this(players, isTwodices);
        this.size = size;
    }

    public boolean isTwodices() {
        return isTwodices;
    }

    public void setTwodices(boolean twodices) {
        isTwodices = twodices;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
