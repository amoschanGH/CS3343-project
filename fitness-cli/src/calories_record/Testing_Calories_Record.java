package calories_record;

import java.util.*;
import java.lang.*;

public class Testing_Calories_Record {

    public static void main(String[] args)  {
        Calories calories = new Calories(new ArrayList<>(List.of(1.0, 2.0, 3.0, 4.0, 5.0)));
        Nutrients nutrients=new Nutrients(new ArrayList<>(List.of(1.0, 2.0, 3.0, 4.0, 5.0)), //carbs
                            new ArrayList<>(List.of(1.0, 2.0, 3.0, 4.0, 5.0)), //proteins
                            new ArrayList<>(List.of(1.0, 2.0, 3.0, 4.0, 5.0))); //fat
        Input input=new Input(calories, nutrients);

        Calories_Record calories_record=new Calories_Record(input);
        calories_record.print_record();
    }
}