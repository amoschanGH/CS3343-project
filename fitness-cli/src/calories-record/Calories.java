import java.util.ArrayList;

public class Calories {
    public ArrayList<Double> calories;

    public Calories(ArrayList<Double> calories) {
        this.calories = calories;
    }

    public double compute_weekly_caloric_intake(){
        double total=0;
        for (double c:calories){
            total+=c;
        }
        return total;
    }
}
