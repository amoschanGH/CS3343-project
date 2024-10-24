package water_record;

public class WaterTracker {
    private WaterData waterData;
    private double hydrationGoal; // Hydration goal in liters

    public WaterTracker(WaterData _waterData) {
        this.waterData = _waterData;
        this.hydrationGoal = 2.0; // Default hydration goal is 2 liters
    }

    public void setHydrationGoal(double amount) {
        this.hydrationGoal = amount;
        System.out.println("\nHydration goal set to: " + hydrationGoal + " liters.");
    }

    // Method to generate water intake report
    public void generateWaterIntakeReport() {
        System.out.println("\nWeekly Water Intake Report:");
        for (int i = 0; i < 7; i++) {
            System.out.printf("Day %d: %.2f liters%n", i + 1, waterData.waterIntakeAt(i));
        }

        double totalIntake = calculateWeeklyWaterIntake();
        System.out.printf("Total Water Intake for the Week: %.2f liters%n", totalIntake);
        System.out.printf("Hydration Goal: %.2f liters%n", hydrationGoal * 7);
    }

    // Method to calculate weekly water intake
    public double calculateWeeklyWaterIntake() {      
        return waterData.totalWaterIntake();
    }

    // Method to check hydration status
    public String checkHydrationStatus() {
        double weeklyIntake = calculateWeeklyWaterIntake();
        if (weeklyIntake >= hydrationGoal * 7) {
            return "\nYou are meeting your hydration goal!";
        } else {
            return "\nYou need to drink more water to meet your hydration goal.";
        }
    }


}