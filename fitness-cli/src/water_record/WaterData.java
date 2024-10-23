package water_record;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WaterData {
    private List<Double> dailyIntake; // List to store daily water intake

    public WaterData() {
        this.dailyIntake = new ArrayList<>();
    }

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

    public double totalWaterIntake() {
        double totalIntake = 0.0;
        for (double intake : dailyIntake) {
            totalIntake += intake;
        }
        return totalIntake;
    }

    public double waterIntakeAt(int weekDay) {
        if (dailyIntake.get(weekDay) != 0) {
            return dailyIntake.get(weekDay);
        }
        return 0;
    }

    public void checkData() throws IndexOutOfBoundsException{
        waterIntakeAt(0);
    }
}