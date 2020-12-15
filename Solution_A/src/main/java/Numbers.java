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

    public static ArrayList<String> Division(int[] Counts, int Starting_Noun, int Summa, String string, int Amount, ArrayList<String> Result_Arrays) {
        ArrayList<String> Result = Result_Arrays;

        if (Summa == 0) {
            Result.add(string);
            return Result;
        } else {
            if (Summa < 0) {
                return Result;
            }
            for (int i = Starting_Noun; i < Amount; i++) {
                Result = Division(Counts, i, Summa - Counts[i], string + " " + Integer.toString(Counts[i]), Amount, Result);
            }
            return Result;
        }
    }

    public static ArrayList<String> Counting(String[] args) {

        ArrayList<String> Result = new ArrayList();

        String[] Input = args;

        if (!isNumeric(Input[0])) {
            Result.add("Error");
            return Result;
        }
        int Summa = Integer.parseInt(Input[0]);

        if (Summa < 0) {
            Result.add("Error");
            return Result;
        }

        if (!isNumeric(Input[1])) {
            Result.add("Error");
            return Result;
        }
        int Amount = Integer.parseInt(Input[1]);
        int[] Counts = new int[Amount];

        int Count = 0;
        for (int i = 0; i < Amount; i++) {
            if (!isNumeric(Input[i + 2])) {
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
                Result.add("Error");
                return Result;
            }

            if (t == 1) {
                Counts[Count] = Integer.parseInt(Input[2 + i]);
                Count++;
            }
        }

        Amount = Count;

        Arrays.sort(Counts, 0, Amount);

        Result = Division(Counts, 0, Summa, "", Amount, Result);

        return Result;
    }
}

