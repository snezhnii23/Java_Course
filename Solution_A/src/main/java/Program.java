import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args)
    {
        String[] testInfo = {"5", "3", "1", "2", "2"};
        Numbers numbers = new Numbers();
        ArrayList<String> result = numbers.counting(testInfo);
        System.out.println(result);
    }

}
