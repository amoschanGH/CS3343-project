import java.util.*;

public class Nutrients {
    ArrayList<Double> carbs;
    ArrayList<Double> proteins;
    ArrayList<Double> fats;

    public Nutrients(ArrayList<Double> carbs, ArrayList<Double> proteins, ArrayList<Double> fats) {
        this.carbs = carbs;
        this.proteins = proteins;
        this.fats = fats;
    }

    public Map<String, Double> macronutrients_breakdown(){
        Map<String, Double> breakdown = new HashMap<>();
        int counter=1;
        for (double c: carbs) {
            if (breakdown.containsKey("carbs_total")) {
                breakdown.put("carbs_total", breakdown.get("carbs_total") + c);
            }else{
                breakdown.put("carbs_total", c);
            }
            breakdown.put("carbs_average", breakdown.get("carbs_total")/counter);
            counter++;
        }

        counter=1;
        for (double p: proteins) {
            if (breakdown.containsKey("proteins_total")) {
                breakdown.put("proteins_total", breakdown.get("proteins_total") + p);
            }else{
                breakdown.put("proteins_total", p);
            }
            breakdown.put("proteins_average", breakdown.get("proteins_total")/counter);
            counter++;
        }

        counter=1;
        for (double f: fats) {
            if (breakdown.containsKey("fats_total")) {
                breakdown.put("fats_total", breakdown.get("fats_total") + f);
            }else{
                breakdown.put("fats_total", f);
            }
            breakdown.put("fats_average", breakdown.get("fats_total")/counter);
            counter++;
        }

        return breakdown;
    }

}
