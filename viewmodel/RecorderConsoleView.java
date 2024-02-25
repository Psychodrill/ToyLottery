package viewmodel;
import java.util.ArrayList;

import interfaces.*;
import model.LotteryMachine;

public class RecorderConsoleView implements Publisher{

    private final LotteryMachine rec;
    private ArrayList<String> result;

    public RecorderConsoleView(LotteryMachine rec) {
        this.rec=rec;
    }

    @Override
    public void getResult(Listener<String> listener) {
        sendData(listener.getData());
        listener.showResult(result);
    }

    public void sendData(String[] data) {

        // result= rec.handleArrayData(data);
    }
    
}
