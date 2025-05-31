import java.util.*;

public class List{

    private static ArrayList<Item> list = new ArrayList<Item>(); 

    public static void addToList(Item name){
        list.add(name);
    }

    public static double amountspend(ArrayList<Item> lT, int n){
        if (n < 0){
            return 0;
        }
        return (lT.get(n)).getCost() + (amountspend(lT, n - 1));
    }

    public static ArrayList<Item> getList(){
        return list;
    }

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
            // If we've exhausted right list
            else if (rightInd >= right.size()) {
                list.set(ind, left.get(leftInd));
                order(list, left, right, ind + 1, leftInd + 1, rightInd);
            }
            // Compare elements and choose smaller/larger (as needed)
            else if (left.get(leftInd).getCost() >= right.get(rightInd).getCost()) {
                list.set(ind, left.get(leftInd));
                order(list, left, right, ind + 1, leftInd + 1, rightInd);
            } else {
                list.set(ind, right.get(rightInd));
                order(list, left, right, ind + 1, leftInd, rightInd + 1);
            }
        }
    }
