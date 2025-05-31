import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args)
    {

      Scanner input = new Scanner(System.in);
      System.out.print("Enter what your monthly salary is: ");
      double monSal = input.nextDouble();
      System.out.print("Enter how much money you want leftover: ");
      double left = input.nextDouble(); 

      String filename = "purchases.txt";
      readPurchases(filename);

      ArrayList<Item> purchaseList = List.getList();
      for (Item item : purchaseList){
          System.out.println("Item: " + item.getName());
      }

      System.out.print("The total amount of spending per month is ");
      System.out.println(List.amountspend(purchaseList, purchaseList.size() - 1));

      BudgetSpend budget = new BudgetSpend(monSal, left);
      System.out.println("The max amount you can spend is " + budget.maxSpend());
      if (budget.maxSpend() < List.amountspend(purchaseList, purchaseList.size() - 1)){
          System.out.println("You are over budget");
      }
      else{
          System.out.println("You are under budget :)");
      }

      List.sort(purchaseList);
      System.out.println("Sorted List from least expensive to most expensive: ");
      for (Item item : purchaseList){
          System.out.println("Item: " + item.getName());
      }

      System.out.println("Enter the index of an item you want to see the frequency of: ");
      int numItem = input.nextInt();
        Frequency freq = new Frequency((purchaseList.get(numItem)).getName(), (purchaseList.get(numItem)).getCost());
        System.out.println("The frequency of " + (purchaseList.get(numItem)).getName() + " is " + freq.setFrequency(purchaseList, purchaseList.size() - 1));
          
      }


    /**
     * Reads each line in a file and converts each line into an Item object
     * 
     * Preconditions:
     * - filename is intializied and it can be found/located  
     * Postconditions:
     * - Each line in filename is converted into an Item object
     * @param filename - A string that contains all the lines in the textfile
     */    
    public static void readPurchases(String filename){
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] parts = line.split("\\s+");
                if (parts.length != 2){
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                String itemName = parts[0];
                double itemCost;

                try {
                    itemCost = Double.parseDouble(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price in line: " + line);
                    continue;
                }

                // Create Item object
                Item item = new Item(itemName, itemCost);

                // Add item to the list
                List.addToList(item);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
            }
      
    }
