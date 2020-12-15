import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumbersTest {

    @org.junit.Test
    public void counting() {

        String[] Test_Info = {"5 2 1 2", "A 2 1 2", "5 A 1 2", "5 2 g 2", "5 1 6", "15 3 2 4 5", "5 3 1 2 2"};
        String[] Results = {"[ 1 1 1 1 1,  1 1 1 2,  1 2 2]", "[Error]", "[Error]", "[Error]", "[]", "[ 2 2 2 2 2 5,  2 2 2 4 5,  2 4 4 5,  5 5 5]", "[ 1 1 1 1 1,  1 1 1 2,  1 2 2]"};

        Numbers numbers = new Numbers();

        int Amount = 7;
        for (int i = 0; i < Amount; i++) {
            String[] Input = Test_Info[i].split(" ");
            ArrayList<String> Result = numbers.Counting(Input);
            String Output = Result.toString();
            assertEquals(Output, Results[i]);
        }

    }
}