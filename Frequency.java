import java.util.*;

public class Frequency extends Item{
    
    /**
     * @param frequency - the number of times the object appears in a list
     */ 
    private int frequency; 
    
    /**
     * This constructs the Item object in the subclass
     * 
     * Precondition:
     * - name is a String value
     * - price is a double value greater than zero
     * Postcondition: 
     * - The item object is created and frequency is set to zero
     * @param name - The name of the Item
     * @param price - The price of the Item
     */
    public Frequency(String name, double price){
        super(name, price);
        this.frequency = 0;
    }
    
    /**
     * This sets the number of times an item appears in a list
     * 
     * Preconditions:
     * - List is initalized
     * - Size is greater or equal to 0
     * Postcondition:
     * - The freqeuncy value is updated to how many times the object appears in the list
     * @param list - the list that contains all the item objects (purchases)
     * @param size - the last index value
     * @return frequency 
     */ 
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
    
}
