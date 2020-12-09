import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args)
    {
        String[] Test_Info = {"5", "3", "1", "2", "2"};
        Numbers numbers = new Numbers();
        ArrayList<String> Result = numbers.Counting(Test_Info);
        System.out.println(Result);
    }

}
