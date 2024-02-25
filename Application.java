import model.LotteryMachine;
import view.ConsoleView;
import viewmodel.LotteryConsoleView;
import interfaces.*;

public class Application {
 
    public void run(){

        LotteryMachine lm = new LotteryMachine();
        Publisher lmConsView= new LotteryConsoleView(lm);
        ConsoleView consView = new ConsoleView(lmConsView);
        consView.run();

    }
}
