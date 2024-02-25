package model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfaces.*;
import logger.Log;

public class LotteryMachine {
    private static final Logger log = Log.log(LotteryMachine.class.getName());
    // private ArrayList<String> messages = new ArrayList<String>();

    private PriorityQueue<Lottable> lots = new PriorityQueue<Lottable>();
    // public ArrayList<String> handleArrayData(String[] data) {
    //     log.log(Level.INFO, "Method handleArrayData in model package started");

    //     try{
    //         checkArrayData(data);
    //         Toy human = mappingHuman(data);
    //         if(messages.isEmpty()){
    //             String filename = human.lastname+".txt";
    //             recordData(human, filename);
    //         }
    //     }
    //     catch(RuntimeException ex){
    //         messages.add(ex.getMessage());
    //     }
    //     if(messages.isEmpty()){
    //         messages.add("Recording successfully!");
    //     }
    //     return messages;
        
    // }
    // private void recordData(Toy human, String filename) throws RuntimeException{

    //     try(FileWriter writer = new FileWriter(filename, true)){
    //         writer.write(human.toString());
    //         writer.flush();
    //     }
    //     catch(IOException ex){
    //         throw new RuntimeException("Recording failed");
    //     }
    // }

    // private void checkArrayData(String[] data) throws RuntimeException {
        
    //     System.out.println(data.length);
    //     if(data.length<6){
    //         throw new RuntimeException("Insufficient data to record");
    //     }
    //     if(data.length>6){
    //         throw new RuntimeException("Excess data to record");
    //     }

    // }
    // private Toy mappingHuman(String[] data){


    //     String lastname = data[0];
    //     String firstname = data[1];
    //     String middlename=data[2];
    //     LocalDate birthdate= LocalDate.now();
    //     Long phone=Long.MIN_VALUE;
    //     Character sex='u';
    //     try{
    //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    //         birthdate = LocalDate.parse(data[3], formatter);

    //     }
    //     catch(DateTimeParseException ex){
    //         messages.add(String.format("Next parameter is invalid: %s", data[3]));
    //     }
    //     try{
    //         phone=Long.parseUnsignedLong(data[4]); 

    //     }
    //     catch(NumberFormatException ex){
    //         messages.add(String.format("Next parameter is invalid: %s", data[4]));
    //     }
    //     sex = data[5].charAt(0);
    //     if(sex != 'm' && sex!='f'){
    //         messages.add(String.format("Next parameter is invalid: %s", data[5]));
    //     }

    //     return new Toy(lastname, firstname, middlename, birthdate, phone, sex);
    // }
    public void getPrize(){

        Double luckyNumber =Math.random()*getChanceSum();
        // Double onePercent = chanceSum/100;
        Double weightCount=0.0;
        for(Lottable item:lots){
            weightCount+=item.getChance();
            if(weightCount>luckyNumber){
               // result =remove(item.getId());
            }
        }

    }

    private Double  getChanceSum(){
        Double result=0.0;
        for(Lottable item:lots){
            result+=item.getChance();
        }
        return result;
    }
    private void addLot(int id, String name, byte chance, int count){
        Lottable newLot= new Lot(id, name, chance, count);
        this.lots.add(newLot);
    }
    
    private Lottable findItem(int id){
        Lottable result = null;
        for(Lottable item:lots){
            if(item.getId()==id){
                result = item;
            }
        }
        return result;
    } 
    private void editChance(int id, byte chance){

        Lottable editedLot= findItem(id);
        editedLot.setChance(chance);
        
    }
    private Toy remove(int id){
        Toy toy = null;
        Lottable item = findItem(id);
        Integer count = item.getCount();
        if(count>1){
            item.setCount(count-1);
            
        }//remove lot if toys count ==0
        else{
            lots.remove(item);
        }

        toy=item.getToy();
        return toy;
    }
}
