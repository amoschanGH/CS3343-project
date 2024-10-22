import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



public class Workout_record {
    public static void main(String[] args) {
        Workout_record workoutRecord = new Workout_record();
        List<WorkoutData> workoutDataList = workoutRecord.readCSV("workout_record.csv");
        System.out.println("1.calculate_total_workouts(): ");
        workoutRecord.calculate_total_workouts(workoutDataList);
        System.out.println("2.average_workout_duration() ");
        String date1 = "15/10/2024";
        String date2 = "25/10/2024";
        workoutRecord.average_workout_duration(workoutDataList, date1, date2);
        System.out.println("3.calculate_bmi(weight, height) ");
        double weight = 70;
        double height = 1.75;
        workoutRecord.calculate_bmi(weight, height);
        System.out.println("4.track_progress(startDate, endDate) ");



        workoutRecord.track_progress(date1, date2);
    }

    public void calculate_total_workouts(List<WorkoutData> workoutDataList) {
        double totalWorkouts=workoutDataList.size();
        double dailyAverage = totalWorkouts / 30.0;
        double weeklyAverage = totalWorkouts / 4.0;
        double monthlyAverage = totalWorkouts;
        System.out.println("daily average work: "+dailyAverage +" times");
        System.out.println("weekly average work: "+weeklyAverage +" times");
        System.out.println("montly average work: "+monthlyAverage+" times");
        // Calculate total workouts
    }

    public void average_workout_duration(List<WorkoutData> workoutDataList,String startDateStr, String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException e) {
            System.err.println("Error parsing dates: " + e.getMessage());

        }
        List<WorkoutData> subList = new ArrayList<>();
        for (WorkoutData workout : workoutDataList) {
            if (!workout.getDate().before(startDate) && !workout.getDate().after(endDate)) {
                subList.add(workout);
            }
        }
        int totalWorkoutsInRange = subList.size();
        //System.out.println(totalWorkoutsInRange);
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        //System.out.println(diffInMillies);
        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000) + 1; // +1 to include both start and end date
        //System.out.println(diffInDays);
        // print 1.0 is correct, since now only one day have one work
        System.out.println("Average working count " +(double) totalWorkoutsInRange / diffInDays +" times");

    }

    public void calculate_bmi(double weight, double height) {

        String text = "Your BMI is: ";
        double bmi = weight / (height * height);
        double roundedBmi = Math.round(bmi * 10.0) / 10.0;
        System.out.println(text + roundedBmi);
    }

    public void track_progress(String startDate, String endDate) {
        List<WeightData> weightDataList = new ArrayList<>();
        String line = "";
        String csvSplitBy = ",";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader("weight_record.csv"))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                Date date = dateFormat.parse(data[0]);
                double weight =Double.parseDouble(data[1]);
                //double duration = Double.parseDouble(data[2]);
                //WorkoutData workoutData = new WorkoutData(date, activity, duration);
                WeightData weightdata =new WeightData(date, weight);
                weightDataList.add(weightdata);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            System.out.println("EROROR");
        }
        //System.out.println(weightDataList);

                try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);

            List<WeightData> filteredData = weightDataList.stream()
                    .filter(data -> !data.getDate().before(start) && !data.getDate().after(end))
                    .collect(Collectors.toList());

            if (filteredData.isEmpty()) {
                System.out.println("No data available for the specified period.");
                return;
            }

            double initialWeight = filteredData.get(0).getWeight();
            double finalWeight = filteredData.get(filteredData.size() - 1).getWeight();
            double weightChange = finalWeight - initialWeight;

            System.out.println("Weight change from " + startDate + " to " + endDate + ": " + weightChange + " kg");
            System.out.println("Not finsihed yet, try to use XYChartBuilder to plot the chart");
            //plotChart(filteredData);

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Invalid date format.");
        }


       
    }
    /*
    private void plotChart(List<WeightData> weightDataList) {
        List<Date> dates = new ArrayList<>();
        List<Double> weights = new ArrayList<>();

        for (WeightData data : weightDataList) {
            dates.add(data.getDate());
            weights.add(data.getWeight());
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).title("Weight Progress").xAxisTitle("Date").yAxisTitle("Weight").build();
        chart.addSeries("Weight", dates, weights).setMarker(SeriesMarkers.NONE);

        try {
            BitmapEncoder.saveBitmap(chart, "./weight_progress", BitmapEncoder.BitmapFormat.PNG);
            System.out.println("Chart saved as weight_progress.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
         */

    public List<WorkoutData> readCSV(String filePath) {
        List<WorkoutData> workoutDataList = new ArrayList<>();
        String line = "";
        String csvSplitBy = ",";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                Date date = dateFormat.parse(data[0]);
                String activity = data[1];
                double duration = Double.parseDouble(data[2]);
                WorkoutData workoutData = new WorkoutData(date, activity, duration);
                workoutDataList.add(workoutData);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return workoutDataList;
    }
}