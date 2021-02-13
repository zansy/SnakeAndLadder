package service;

import model.Board;
import model.Player;

import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    DiceService diceService = new DiceService();
    public final Map<Integer, Integer> snakes;
    public final Map<Integer, Integer> ladders;
    public boolean run(){
        while (true){
            for (Player currentPlayer : board.players){
                int curRollNum = board.isTwodices() ? diceService.roll(2) : diceService.roll(1);
                if (curRollNum == 0) continue;
                //---option 4 end---
                System.out.print(currentPlayer.name + " rolled a "+curRollNum+
                        " and moved from "+currentPlayer.getCurrentPosition()+" to ");
                int nextPosition = playerMoveTo(currentPlayer, curRollNum, snakes, ladders);
                System.out.println(nextPosition);
                if (nextPosition == board.getSize()){
                    System.out.println(currentPlayer.name+" wins the game");
                    //---option 3 start---
                    board.players.remove(currentPlayer);
                    if (board.players.size() == 1){
                        return true;
                    }
                    //---option 3 end---
                }
            }
        }
    }
    //option 1
    public Game(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players, boolean isTwoDice){
        this.snakes = snakes;
        this.ladders = ladders;
        board = new Board(players, isTwoDice);
    }
    //option 2
    public Game(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players, boolean isTwoDice, int size){
        this.snakes = snakes;
        this.ladders = ladders;
        board = new Board(players, isTwoDice, size);
    }

    public int playerMoveTo(Player player, int curRollNum, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders){
        int nextPosition = player.getCurrentPosition() + curRollNum;
        int temp;
        do {
            temp = nextPosition;
            if (snakes.get(temp) != null) nextPosition = snakes.get(temp);
            if (ladders.get(temp) != null) nextPosition = ladders.get(temp);
        }while (temp != nextPosition);

        if (nextPosition > board.getSize()) nextPosition = player.getCurrentPosition();
        player.setCurrentPosition(nextPosition);

        return nextPosition;
    }
}
