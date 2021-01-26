package ladder;

import java.util.List;

public class BoardService {
    private Board board;
    private boolean gameOver = false;
    public void core(){
        while (!gameOver){
            for (Player currentPlayer : board.getPlayers()){
                int curRollNum = board.roll();
                //---option 4 start---
                if (curRollNum == 6){
                    if (board.roll() == 6 && board.roll() == 6){
                        System.out.println(currentPlayer.getName()+" rolled 3 consecutive 6s, all the three of those get cancelled.");
                        continue;
                    }
                }
                //---option 4 end---
                System.out.print(currentPlayer.getName() + " rolled a "+curRollNum+
                        " and moved from "+board.getPlayersposition().get(currentPlayer)+" to ");
                int nextPosition = playerMoveTo(currentPlayer, curRollNum);
                System.out.println(nextPosition);
                if (nextPosition == board.getSize()){
                    System.out.println(currentPlayer.getName()+" wins the game");
                    //---option 3 start---
                    board.getPlayers().remove(currentPlayer);
                    if (board.getPlayers().size() == 1){
                        gameOver = true;
                        break;
                    }
                    //---option 3 end---
                }
            }
        }
    }

    public void start(List<Snake> snakes, List<Ladder> ladders, List<Player> players){
        board = new Board(snakes, ladders, players);
        core();
    }

    //option 1
    public void start(List<Snake> snakes, List<Ladder> ladders, List<Player> players, int dicesNum){
        board = new Board(snakes, ladders, players, dicesNum);
        core();
    }
    //option 2
    public void start(List<Snake> snakes, List<Ladder> ladders, List<Player> players, int dicesNum, int size){
        board = new Board(snakes, ladders, players, dicesNum, size);
        core();
    }

    public int playerMoveTo(Player player, int curRollNum){
        int nextPosition = board.getPlayersposition().get(player) + curRollNum;
        int temp;
        do {
            temp = nextPosition;
            for (Snake snake : board.getSnakes()){
                if (temp == snake.getStart()){
                    nextPosition = snake.getEnd();
                }
            }
            for (Ladder ladder : board.getLadders()){
                if (temp == ladder.getStart()){
                    nextPosition = ladder.getEnd();
                }
            }
        }while (temp != nextPosition);

        if (nextPosition > board.getSize()) nextPosition = board.getPlayersposition().get(player);
        board.getPlayersposition().put(player, nextPosition);

        return nextPosition;
    }
}
