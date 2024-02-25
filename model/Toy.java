package model;

public class Toy {

    int id;
    String name;

    public Toy(int id, String name){

        this.id=id;
        this.name=name; 

    }
    @Override
    public String toString() {
        return String.format("<%s><%s>",id,name);
    }
}
