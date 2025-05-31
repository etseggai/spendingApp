public class BudgetSpend {
    
    /**
     * @param salary - The amount of money one earns in a month
     * @param leftover - The amount of money one wants to keep after a month's expense
     */ 
    private double salary;
    private double leftover; 
    
    /**
     * Construct the Budgetspend object
     * 
     * Preconditions: 
     * - salary is greater than zero
     * - leftover is greater than zero
     * Postconditions:
     * - Salary & leftover are initalized 
     * @param salary - a double value greater than zero
     * @param leftover - a double value greater than zero
     */ 
    public BudgetsSpend(double salary, double leftover){
        this.salary = salary; 
        this.leftover = leftover;
    }
    
    /**
     * Calculate the budget 
     * 
     * Preconditions:
     * - salary and leftover are initalized
     * Postconditions:
     * - The subtraction of the two values is returned
     * @return the difference between salary and leftover variables
     */ 
    public double maxSpend(){
        return salary - leftover;
    }
    
}
