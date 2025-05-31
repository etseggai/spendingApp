public class Item{

    private String itemName; 
    private double itemCost; 

    public Item(String itemName, double itemCost){
        this.itemName = itemName; 
        this.itemCost = itemCost; 
    }

    public double getCost(){
        return itemCost;
    }

    public String getName(){
        return itemName;
    }

}
