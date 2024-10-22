import java.text.SimpleDateFormat;
import java.util.Date;

public class WeightData {
    private Date date;
    private double weight;

    public WeightData(Date date, double weight) {
        this.date = date;
        this.weight = weight;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Date: " + dateFormat.format(date) + ", Weight: " + weight;
    }

        // Getters and setters
        public Date getDate() {
            return date;
        }
    
        public void setDate(Date date) {
            this.date = date;
        }
        public double getWeight() {
            return weight;
        }
        public void setWeight(double weight) {
            this.weight = weight;
        }
        
}