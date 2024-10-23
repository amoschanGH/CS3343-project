package water_record;

public class HydrationController {
    private double amount;
    
    public HydrationController(double _amount) {
        this.amount = _amount;
    }

    public double setHydrationGoal() {
        System.out.println("Hydration goal set to: " + amount + " liters.");
        return amount;
    }
}
