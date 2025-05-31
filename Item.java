public class Item{
    
    /**
     * @param itemName - the String value of the object
     * @param itemCost - the double value of the object
     */
    private String itemName; 
    private double itemCost; 
    
    
    /**
    * Constructs the Item object
    * Precondition:
    * - ItemName is a strong and itemCost is a double than is greater than 0
    * Postcondition:
    * - The inputted values are assigned to each instance variable 
    * @param itemName - the String value of the Item object (name)
    * @param itemCost - the double value of the Item object (price)
    */
    public Item(String itemName, double itemCost){
        this.itemName = itemName; 
        this.itemCost = itemCost; 
    }
    
    /**
    * Retrieves the itemCost
    * Precondition: 
    * - itemCost is initialized
    * Postcondition:
    * -  the double value is returned 
    * @return the value of itemCost
    */
    public double getCost(){
        return itemCost;
    }
    
    /**
    * Retrieves the itemName
    * Precondition: 
    * - itemName is initialized
    * Postcondition:
    * -  the String value is returned 
    * @return the name of the Item object
    */
    public String getName(){
        return itemName;
    }
    
}
