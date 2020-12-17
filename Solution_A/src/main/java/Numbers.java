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

    public static ArrayList<String> division(int[] counts, int starting_Noun, int summa, String string, int amount, ArrayList<String> resultArrays) {
        ArrayList<String> result = resultArrays;

        if (summa == 0) {
            result.add(string);
            return result;
        } else {
            if (summa < 0) {
                return result;
            }
            for (int i = starting_Noun; i < amount; i++) {
                result = division(counts, i, summa - counts[i], string + " " + Integer.toString(counts[i]), amount, result);
            }
            return result;
        }
    }

    public static ArrayList<String> counting(String[] args) {

        ArrayList<String> result = new ArrayList();

        String[] input = args;

        if (!isNumeric(input[0])) {
            result.add("Error");
            return result;
        }
        int summa = Integer.parseInt(input[0]);

        if (summa < 0) {
            result.add("Error");
            return result;
        }

        if (!isNumeric(input[1])) {
            result.add("Error");
            return result;
        }
        int amount = Integer.parseInt(input[1]);
        int[] counts = new int[amount];

        int count = 0;
        for (int i = 0; i < amount; i++) {
            if (!isNumeric(input[i + 2])) {
                result.add("Error");
                return result;
            }
            int t = 1;
            for (int j = 0; j < counts.length; j++) {
                if (counts[j] == Integer.parseInt(input[2 + i])) {
                    t = 0;
                }
            }

            if (Integer.parseInt(input[2 + i]) <= 0) {
                result.add("Error");
                return result;
            }

            if (t == 1) {
                counts[count] = Integer.parseInt(input[2 + i]);
                count++;
            }
        }

        amount = count;

        Arrays.sort(counts, 0, amount);

        result = division(counts, 0, summa, "", amount, result);

        return result;
    }
}

