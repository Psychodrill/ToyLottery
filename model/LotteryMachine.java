package model;

import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import interfaces.*;
import logger.Log;

public class LotteryMachine {
    private static final Logger log = Log.log(LotteryMachine.class.getName());
    // private ArrayList<String> messages = new ArrayList<String>();

    private PriorityQueue<Lottable> lots = new PriorityQueue<Lottable>();

    public String launchMachine(){
        Lottable prize =getPrize();
        if(prize!=null){
            log.log(Level.INFO, String.format("Drop item: %s",prize.getName()));
            checkCount();
            return prize.toString();
        }
        else{
            return "Sorry there are no toys in machine!";
        }
        
    }

    private Lottable getPrize(){
       
        Double luckyNumber =Math.random()*getChanceSum();
        // Double onePercent = chanceSum/100;
        //System.out.println(getChanceSum());
        //System.out.println(luckyNumber);
        Double weightCount=0.0;
        for(Lottable item:lots){
            weightCount+=item.getChance();
           // System.out.println(weightCount);
            if(weightCount>luckyNumber){
             //   System.out.println("luck");
               return retrieve(item.getId());
               
            }
        }
        return null;
    }

    private Double  getChanceSum(){
        Double result=0.0;
        for(Lottable item:lots){
            result+=item.getChance();
        }
        return result;
    }
    public void addLot(int id, String name, byte chance, int count){
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
    public void editChance(int id, byte chance){

        Lottable editedLot= findItem(id);
        editedLot.setChance(chance);
        
    }
    private Lottable retrieve(int id){
        //Toy toy = null;
        Lottable item = findItem(id);
        Integer count = item.getCount();
        item.setCount(count-1);
        return item;
    }
    private void checkCount(){
        Lottable deletedLot=null;
        for(Lottable item:lots){
            if(item.getCount()==0){
                deletedLot = item;
            }
        }
        lots.remove(deletedLot);

    }
}
