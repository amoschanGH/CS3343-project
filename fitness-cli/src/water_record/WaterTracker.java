package water_record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WaterTracker {
    private List<Double> dailyIntake; // List to store daily water intake
    private double hydrationGoal; // Hydration goal in liters

    public WaterTracker() {
        this.dailyIntake = new ArrayList<>();
        this.hydrationGoal = 2.0; // Default hydration goal is 2 liters
    }

    // Method to calculate weekly water intake
    public double calculateWeeklyWaterIntake() {
        double totalIntake = 0.0;
        for (double intake : dailyIntake) {
            totalIntake += intake;
        }
        return totalIntake;
    }

    // Method to set hydration goal
    public void setHydrationGoal(double amount) {
        this.hydrationGoal = amount;
        System.out.println("Hydration goal set to: " + hydrationGoal + " liters.");
    }

    // Method to check hydration status
    public String checkHydrationStatus() {
        double weeklyIntake = calculateWeeklyWaterIntake();
        if (weeklyIntake >= hydrationGoal * 7) {
            return "You are meeting your hydration goal!";
        } else {
            return "You need to drink more water to meet your hydration goal.";
        }
    }

    // Method to generate water intake report
    public void generateWaterIntakeReport() {
        System.out.println("Weekly Water Intake Report:");
        for (int i = 0; i < dailyIntake.size(); i++) {
            System.out.printf("Day %d: %.2f liters%n", i + 1, dailyIntake.get(i));
        }
        double totalIntake = calculateWeeklyWaterIntake();
        System.out.printf("Total Water Intake for the Week: %.2f liters%n", totalIntake);
        System.out.printf("Hydration Goal: %.2f liters%n", hydrationGoal * 7);
    }

    // Method to load water intake data from a CSV file
    public void loadWaterIntakeData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                dailyIntake.add(Double.parseDouble(line.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing water intake data: " + e.getMessage());
        }
    }

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