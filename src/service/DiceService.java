package service;

import java.util.Random;

public class DiceService {
    public int roll(int diceNum){
        int result =  (new Random().nextInt(6)+1)*diceNum;
        if (diceNum == 1 && result == 6){
            if (new Random().nextInt(6)+1 == 6 && new Random().nextInt(6)+1 == 6){
                System.out.println("This player rolled 3 consecutive 6s, all the three of those get cancelled.");
                return 0;
            }
        }
        return result;
    }
}
