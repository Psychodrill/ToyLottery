package interfaces;

import model.*;

public interface Lottable {
    int getId();
    String getName();
    void setChance(byte chance);
    int getCount();
    void setCount(int count);
    Toy getToy();
    Byte getChance();
    
}
