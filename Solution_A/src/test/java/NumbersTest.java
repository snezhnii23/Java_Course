import java.util.ArrayList;

import static org.junit.Assert.*;

public class NumbersTest {

    @org.junit.Test
    public void counting() {

        String[] testInfo = {"5 2 1 2", "A 2 1 2", "5 A 1 2", "5 2 g 2", "5 1 6", "15 3 2 4 5", "5 3 1 2 2"};
        String[] results = {"[ 1 1 1 1 1,  1 1 1 2,  1 2 2]", "[Error]", "[Error]", "[Error]", "[]", "[ 2 2 2 2 2 5,  2 2 2 4 5,  2 4 4 5,  5 5 5]", "[ 1 1 1 1 1,  1 1 1 2,  1 2 2]"};

        Numbers numbers = new Numbers();

        int amount = 7;
        for (int i = 0; i < amount; i++) {
            String[] input = testInfo[i].split(" ");
            ArrayList<String> result = numbers.counting(input);
            String output = result.toString();
            assertEquals(output, results[i]);
        }

    }
}