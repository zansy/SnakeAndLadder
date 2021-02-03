package ladder;

import ladder.Model.Player;
import ladder.Service.Game;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int snakeNum = sc.nextInt();
        //List<Snake> snakes = new LinkedList<>();
        Map<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < snakeNum; i++){
            //snakes.add(new Snake(sc.nextInt(), sc.nextInt()));
            snakes.put(sc.nextInt(), sc.nextInt());
        }
        int ladderNum = sc.nextInt();
        //List<Ladder> ladders = new LinkedList<>();
        Map<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < ladderNum; i++){
            ladders.put(sc.nextInt(), sc.nextInt());
        }
        int playerNum = sc.nextInt();
        List<Player> players = new LinkedList<>();
        for (int i = 0; i < playerNum; i++){
            players.add(new Player(sc.next()));
        }
        new Game(snakes, ladders, players, false, 200);

    }

}
