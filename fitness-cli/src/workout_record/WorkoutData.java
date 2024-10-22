import java.util.Date;
import java.text.SimpleDateFormat;
public class WorkoutData {
    private Date date;
    private String activity;
    private double duration;

    public WorkoutData(Date date, String activity, double duration) {
        this.date = date;
        this.activity = activity;
        this.duration = duration;
    }

    // Getters and setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "WorkoutData{" +
                "date='" + dateFormat.format(date)  + '\'' +
                ", activity='" + activity + '\'' +
                ", duration=" + duration +
                '}';
    }
}