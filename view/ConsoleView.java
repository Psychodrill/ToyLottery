package view;
import java.util.Scanner;
import interfaces.Publisher;
public class ConsoleView implements interfaces.Listener{
    // public static final String ANSI_RED = "\u001B[31m";
    // public static final String ANSI_RESET = "\u001B[0m";
    private final Publisher lmConsView;
    private String[] dataStrings = new String[4];
    public ConsoleView(Publisher  lmConsView) {
        this.lmConsView = lmConsView;
    }

    public void run(){
       

        while (true) {

            Scanner scanner = new Scanner(System.in);
            //System.out.println("Input Id, Toyname, Chance, Count, separated by space ...");
            System.out.print("1 - Add Toys");
            System.out.print("2 - Edit Chance by id");
            System.out.print("3 - Launch lotteryMachine");
            String choice = scanner.nextLine();
            if(choice.equals("1")){
                System.out.println("Input Id, Toyname, Chance, Count, separated by space ...");
                String next= scanner.nextLine();
                dataStrings = next.split("\\s");
                lmConsView.addLottable(this);
            }
            else if(choice.equals("2")){
                System.out.println("Input Id and Chance, separated by space ...");
                String next= scanner.nextLine();
                dataStrings = next.split("\\s");
                lmConsView.editLottable(this);

            }
            else if(choice.equals("3")){

                lmConsView.launchLottery(this);

            }
            else{
                System.out.println("You are input unacceptable symbol");
            }
        }
    }


    public String[] getData(){
        return dataStrings;
    }

    @Override
    public void showResult(String result) {
        System.out.println(result);
        
    }

}
