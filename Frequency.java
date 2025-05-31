import java.util.*;

public class Frequency extends Item{

    private int frequency; 

    public Frequency(String name, double price){
        super(name, price);
        this.frequency = 0;
    }

    public int setFrequency(ArrayList<Item> list, int size){
        if (size < 0){
            return frequency; 
        }

        if(((list.get(size)).getName()).equals(getName())){
            frequency++;
        }
        size--;

        return setFrequency(list, size);
    }

    public int getFrequency(){
        return frequency;
    }
}
