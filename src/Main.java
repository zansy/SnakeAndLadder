import model.Player;
import service.Game;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int snakeNum = sc.nextInt();
        Map<Integer, Integer> snakes = new HashMap<>();
        for (int i = 0; i < snakeNum; i++){
            snakes.put(sc.nextInt(), sc.nextInt());
        }
        int ladderNum = sc.nextInt();
        Map<Integer, Integer> ladders = new HashMap<>();
        for (int i = 0; i < ladderNum; i++){
            ladders.put(sc.nextInt(), sc.nextInt());
        }
        int playerNum = sc.nextInt();
        List<Player> players = new LinkedList<>();
        for (int i = 0; i < playerNum; i++){
            players.add(new Player(sc.next()));
        }
        Game game = new Game(snakes, ladders, players, false, 200);
        game.run();
    }

}
