import model.LotteryMachine;
import view.ConsoleView;
import viewmodel.RecorderConsoleView;
import interfaces.*;

public class Application {
 
    public void run(){

        LotteryMachine recorder = new LotteryMachine();
        Publisher recConsView= new RecorderConsoleView(recorder);
        ConsoleView consView = new ConsoleView(recConsView);
        consView.run();

    }
}
