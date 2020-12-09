import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Numbers {

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static ArrayList<String> Division(int[] Counts, int k, int Summa, String string, int N, ArrayList<String> Result_Arrays) {
        ArrayList<String> Result = Result_Arrays;

        if (Summa == 0) {
            Result.add(string);
            //System.out.println(string);
            return Result;
        } else {
            if (Summa < 0) {
                return Result;
            }
            for (int i = k; i < N; i++) {
                Result = Division(Counts, i, Summa - Counts[i], string + " " + Integer.toString(Counts[i]), N, Result);
            }
            return Result;
        }
    }

    public static ArrayList<String> Counting(String[] args) {

        ArrayList<String> Result = new ArrayList();

        String[] Input = args;

        //System.out.println(Input);


        //System.out.println("Введите сумму");
        if (!isNumeric(Input[0])) {
            //System.out.println("Ошибка, вы ввели не число!");
            Result.add("Error");
            return Result;
        }
        int Summa = Integer.parseInt(Input[0]);
        //System.out.println(Input[0]);

        if (Summa < 0) {
            //System.out.println("Ошибка, сумма не может быть отрицательной!");
            Result.add("Error");
            return Result;
        }

        //System.out.println("Введите количество купюр");
        if (!isNumeric(Input[1])) {
            //System.out.println("Ошибка, вы ввели не число!");
            Result.add("Error");
            return Result;
        }
        int N = Integer.parseInt(Input[1]);
        //System.out.println(Input[1]);

        //System.out.println("Введите купюры через пробел");
        int[] Counts = new int[N];

        int k = 0;
        for (int i = 0; i < N; i++) {
            if (!isNumeric(Input[i + 2])) {
                //System.out.println("Ошибка, вы ввели не число!");
                Result.add("Error");
                return Result;
            }
            int t = 1;
            for (int j = 0; j < Counts.length; j++) {
                if (Counts[j] == Integer.parseInt(Input[2 + i])) {
                    t = 0;
                }
            }

            if (Integer.parseInt(Input[2 + i]) <= 0) {
                //System.out.println("Ошибка, номинал монеты не может быть отрицательным или равен нулю");
                Result.add("Error");
                return Result;
            }

            if (t == 1) {
                Counts[k] = Integer.parseInt(Input[2 + i]);
                //System.out.print(Counts[k]);
                //System.out.print(" ");
                k++;
            }
        }

        N = k;

        Arrays.sort(Counts, 0, N);

        Result = Division(Counts, 0, Summa, "", N, Result);

        return Result;
    }
}

