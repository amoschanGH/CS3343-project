package calories_burn;

public class CaloriesBurnCalculation {
    private WorkOutType workOutType;
    private int duration;
    private int weight;

    public CaloriesBurnCalculation(WorkOutType workOutType, int duration) {
        this.workOutType = workOutType;
        this.duration = duration;
        this.weight = WeightData.getWeight();
    }

    public int calories_burn_calculation(){
        int met = workOutType.getMet();
        int calories_burned = (int) (met * weight * duration);

        return calories_burned;
    }
}