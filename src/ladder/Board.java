package ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {
    private List<Ladder> ladders;
    private List<Snake> snakes;
    private List<Player> players;
    private int dicesNum;
    private int size;
    private Map<Player, Integer> playersposition;

    public Board(List<Snake> snakes, List<Ladder> ladders, List<Player> players) {
        this.ladders = ladders;
        this.snakes = snakes;
        this.players = players;
        this.dicesNum = 1;
        this.size = 100;
        this.playersposition = new HashMap<>();
        for (Player p:players){
            this.playersposition.put(p, 0);
        }
    }
    public Board(List<Snake> snakes, List<Ladder> ladders, List<Player> players, int dicesNum){
        this(snakes, ladders, players);
        this.dicesNum = dicesNum;
    }
    public Board(List<Snake> snakes, List<Ladder> ladders, List<Player> players, int dicesNum, int size){
        this(snakes, ladders, players, dicesNum);
        this.size = size;
    }

    public int getDicesNum() {
        return dicesNum;
    }

    public void setDicesNum(int dicesNum) {
        this.dicesNum = dicesNum;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public int roll(){
        return (new Random().nextInt(6)+1)*this.dicesNum;
        //return new Random().nextInt(2)+5;
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
