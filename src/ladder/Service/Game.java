package ladder.Service;

import ladder.Model.Board;
import ladder.Model.Player;

import java.util.List;
import java.util.Map;

public class Game {
    private Board board;
    DiceService diceService = new DiceService();
    public void core(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders){
        while (true){
            for (Player currentPlayer : board.players){
                int curRollNum = board.isTwodices() ? diceService.roll(2) : diceService.roll(1);
                if (curRollNum == -1) continue;
                //---option 4 end---
                System.out.print(currentPlayer.getName() + " rolled a "+curRollNum+
                        " and moved from "+currentPlayer.getCurrentPosition()+" to ");
                int nextPosition = playerMoveTo(currentPlayer, curRollNum, snakes, ladders);
                System.out.println(nextPosition);
                if (nextPosition == board.getSize()){
                    System.out.println(currentPlayer.getName()+" wins the game");
                    //---option 3 start---
                    board.players.remove(currentPlayer);
                    if (board.players.size() == 1){
                        return;
                    }
                    //---option 3 end---
                }
            }
        }
    }
    //option 1
    public Game(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players, boolean isTwoDice){
        board = new Board(players, isTwoDice);
        core(snakes, ladders);
    }
    //option 2
    public Game(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders, List<Player> players, boolean isTwoDice, int size){
        board = new Board(players, isTwoDice, size);
        core(snakes, ladders);
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
