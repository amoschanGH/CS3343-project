import java.util.*;

public class Calories_Record {
    public Input input;
    public double total_calories;
    public Map<String, Double> nutrients_breakdown;


    public Calories_Record(Input sim_input) {   //can change how we import data from csv
        this.input = sim_input;
        this.total_calories = sim_input.calories.compute_weekly_caloric_intake();
        this.nutrients_breakdown = sim_input.nutrients.macronutrients_breakdown();
    }

    public void print_total_calories() {
        System.out.println("Total Calories: " + total_calories);
    }

    public void print_nutrients_breakdown() {
        List<String> sortedKeys = new ArrayList<>(this.nutrients_breakdown.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            System.out.println(key + ": " + this.nutrients_breakdown.get(key));
        }
    }

    public void print_record() {
        print_total_calories();
        print_nutrients_breakdown();
    }

}
