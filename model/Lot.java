package model;

import interfaces.Lottable;

public class Lot extends Toy implements Lottable{

    public Byte chance;
    public Integer count;
    public Lot(int id, String name, Byte chance, Integer count) {
        super(id, name);
        this.chance=chance;
        this.count=count;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setChance(byte chance) {


    }
    @Override
    public int getCount() {
        return count;
    }
    @Override
    public void setCount(int count) {
        this.count=count;
    }
    @Override
    public Toy getToy() {
        return (Toy)this;
    }
    @Override
    public Byte getChance() {
        // TODO Auto-generated method stub
        return chance;
    }


    
}
