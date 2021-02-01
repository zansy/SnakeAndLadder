package ladder.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {
    private Map<Integer, Integer> ladders;
    private Map<Integer, Integer> snakes;
    private List<Player> players;
    private boolean isTwodices;
    private int size;
    private Map<Player, Integer> playersposition;

    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players) {
        this.ladders = ladders;
        this.snakes = snakes;
        this.players = players;
        isTwodices = false;
        this.size = 100;
        this.playersposition = new HashMap<>();
        for (Player p:players){
            this.playersposition.put(p, 0);
        }
    }
    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players, boolean isTwodices){
        this(snakes, ladders, players);
        this.isTwodices = isTwodices;
    }
    public Board(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players, boolean isTwodices, int size){
        this(snakes, ladders, players, isTwodices);
        this.size = size;
    }

    public boolean isTwodices() {
        return isTwodices;
    }

    public void setTwodices(boolean twodices) {
        isTwodices = twodices;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Integer> ladders) {
        this.ladders = ladders;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Map<Player, Integer> getPlayersposition() {
        return playersposition;
    }

    public void setPlayersposition(Map<Player, Integer> playersposition) {
        this.playersposition = playersposition;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
