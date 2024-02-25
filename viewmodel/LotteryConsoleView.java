package viewmodel;

import interfaces.*;
import model.LotteryMachine;

public class LotteryConsoleView implements Publisher{

    private final LotteryMachine lm;
    private String result;

    public LotteryConsoleView(LotteryMachine lm) {
        this.lm=lm;
    }

    public void addLot(String []dataStrings) {

         lm.addLot(Integer.parseInt(dataStrings[0]), dataStrings[1], Byte.parseByte(dataStrings[2]), Integer.parseInt(dataStrings[3]));
    }

    @Override
    public void addLottable(Listener listener) {
        addLot(listener.getData());
        //listener.showResult(result);
    }

    public void editLot(String []dataStrings) {

        lm.editChance(Integer.parseInt(dataStrings[0]),Byte.parseByte(dataStrings[2]));
   }

    @Override
    public void editLottable(Listener listener) {
        addLot(listener.getData());
       // listener.showResult(result);
    }
    public String launchMachine() {
        result= lm.launchMachine();
        return result;
   }
    @Override
    public void launchLottery(Listener listener) {
        listener.showResult(launchMachine());
    }
    
}
