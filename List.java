import java.util.*;

public class List{
    
    
    /**
     * @param ArrayList<Item> list holds all Item values
     */ 
    private static ArrayList<Item> list = new ArrayList<Item>(); 
    
    /**
    * Adds each item in the month long financial history to the ArrayList
    *
    * Preconditions: 
    * - The object is initialized with both a String (name) and double (price) value
    * Post-conditions:
    * - Adds the object into the ArrayList
    * @param name: The Item object that will be added to the arraylist
    */
    public static void addToList(Item name){
        list.add(name);
    }
    
    /** 
    * Sums up the total amount of money spent in a month
    *
    * Preconditions:
    * - The ArrayList has a length greater than 1 
    * Post-conditions:
    * - Returns the sum of the prices of all the objects in the ArrayList
    * @param lT - The list that contains all the item values 
    * @param n - The biggest index value of the ArrayList
    * @return the sum of all the price values of each object in the ArrayList
    */
    public static double amountspend(ArrayList<Item> lT, int n){
        if (n < 0){
            return 0;
        }
        return (lT.get(n)).getCost() + (amountspend(lT, n - 1));
    }
    
    /**
    * Retrieves the list that was initialized 
    * 
    * Preconditions:
    * - List is initialized
    * Post-conditions:
    * - Returns the list
    * @return the list
    */
    public static ArrayList<Item> getList(){
        return list;
    }
    
    /**
    * Splits each list into the right side and left side to order it from increasing to decreasing value
    * Preconditions:
    * - list is initialized and has size greater than 0
    * Postconditions:
    * - Splits each list into left and right to reorder it 
    * @param list - An ArrayList that contains Item objects in unsorted order
    */
    public static void sort(ArrayList<Item> list){
        if (list.size() < 2){
            return;
        }

        int mid = list.size() / 2;

        ArrayList<Item> left = new ArrayList<Item>(list.subList(0, mid));
        ArrayList<Item> right = new ArrayList<Item>(list.subList(mid, list.size()));


        sort(left);
        sort(right);

        order(list, left, right, 0, 0, 0);
    }
    
    
    /**
    * Sorts each object in the array into decreasing value based on the price 
    * Preconditions:
    * - All parameters are initialized
    * Postconditions: 
    * -  The list is now sorted in decreasing order from the most expensive item as index
    * zero
    * @param list - the unsorted list
    * @param left - The left side of the unsorted list
    * @param right - The right side of the unsorted list
    * @param ind - The starting index 
    * @param leftind - The index of the left side of the unsorted list
    * @param rightind - The index of the right side of the unsorted list
    */
    public static void order(ArrayList<Item> list, ArrayList<Item> left, ArrayList<Item> right, int ind, int leftInd, int rightInd){
        int lsize = left.size(); 
        int rsize = right.size(); 

        if (ind >= list.size()){
            return;
        }

        if (leftInd >= left.size()) {
                list.set(ind, right.get(rightInd));
                order(list, left, right, ind + 1, leftInd, rightInd + 1);
            }
            else if (rightInd >= right.size()) {
                list.set(ind, left.get(leftInd));
                order(list, left, right, ind + 1, leftInd + 1, rightInd);
            }
            else if (left.get(leftInd).getCost() >= right.get(rightInd).getCost()) {
                list.set(ind, left.get(leftInd));
                order(list, left, right, ind + 1, leftInd + 1, rightInd);
            } else {
                list.set(ind, right.get(rightInd));
                order(list, left, right, ind + 1, leftInd, rightInd + 1);
            }
        }
    }

