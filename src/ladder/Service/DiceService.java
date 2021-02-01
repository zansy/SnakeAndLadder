package ladder.Service;

import java.util.Random;

public class DiceService {
    public int oneDice(){
        return new Random().nextInt(6)+1;
    }
    public int TwoDice(){
        return (new Random().nextInt(6)+1)*2;
    }
}
