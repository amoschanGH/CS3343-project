package water_record;

public class water_record {
    public static void main(String[] args) {
        WaterTracker tracker = new WaterTracker();
        
        // Load data from CSV file
        tracker.loadWaterIntakeData("water_intake.csv");

        // Set hydration goal
        tracker.setHydrationGoal(2.5); // Example: setting goal to 2.5 liters

        // Check hydration status
        System.out.println(tracker.checkHydrationStatus());

        // Generate water intake report
        tracker.generateWaterIntakeReport();
    }
}
