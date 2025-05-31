public class BudgetSpend {

    private double salary;
    private double leftover; 

    public BudgetSpend(double salary, double leftover){
        this.salary = salary; 
        this.leftover = leftover;
    }

    public double maxSpend(){
        return salary - leftover;
    }
}
