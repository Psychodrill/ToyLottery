package model;

import interfaces.Lottable;


public class Lot extends Toy implements Lottable, Comparable<Lot>{

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
    public Byte getChance() {
        // TODO Auto-generated method stub
        return chance;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lot itPharmacy = (Lot) obj;
        return getId() == itPharmacy.getId();
    }

    @Override
    public int hashCode() {

        return getId();
    }
    @Override
    public int compareTo(Lot obj) {

       return Integer.compare(this.getId(), obj.getId());
    }

    
}
