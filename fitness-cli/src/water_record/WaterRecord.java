package water_record;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WaterRecord {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            WaterData waterData = new WaterData();
            
            System.out.println("Please input your csv: ");
            String filePath = scanner.nextLine();
            waterData.loadWaterIntakeData(filePath);
            waterData.checkData();
    
            WaterTracker waterTracker = new WaterTracker(waterData);
    
            System.out.println("\nPlease input your daily hydrational goal: ");
            double amount = scanner.nextDouble();
            waterTracker.setHydrationGoal(amount);
    
            scanner.close();
        
            System.out.println(waterTracker.checkHydrationStatus());
    
            waterTracker.generateWaterIntakeReport();
        } catch (InputMismatchException e) {
            System.out.println("Please input an appropriate number as for stating hydrational goal.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please input an appropriate CSV file for data recording.");
        }
        

    }
}
