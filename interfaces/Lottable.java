package interfaces;

public interface Lottable {
    int getId();
    String getName();
    void setChance(byte chance);
    int getCount();
    void setCount(int count);
    Byte getChance();
    
}
