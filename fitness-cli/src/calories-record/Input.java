import java.util.*;
import java.io.*;
import java.lang.*;

public class Input {
    Calories calories; //can decide whether we make the input_csv as an object first/ directly attract data from csv
    Nutrients nutrients;

    public Input(Calories calories, Nutrients nutrients) {
        this.calories = calories;
        this.nutrients = nutrients;
    }
}
