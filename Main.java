package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static int Rec(int[] num, int k, int sum, String str, int n, int kol)
    {
        if (sum == 0)
        {
            System.out.println(str);
            return kol + 1;
        }
        else
        {
            if (sum < 0)
            {
                return kol;
            }
            int kk = kol;
            for (int i = k; i < n; i++)
            {
                kk = Rec(num, i, sum - num[i], str + " " + Integer.toString(num[i]), n, kk);
            }
            return kk;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);

        System.out.println("Введите сумму");
        int sum = in.nextInt();

        if (sum < 0)
        {
            System.out.println("Ошибка, сумма не может быть отрицательной!");
            System.exit(0);
        }

        System.out.println("Введите количество купюр");
        int n = in.nextInt();

        System.out.println("Введите купюры через пробел");
        int[] num = new int[n];

        for (int i = 0; i < n; i++)
        {
            num[i] = in.nextInt();

            if (num[i] <= 0)
            {
                System.out.println("Ошибка, номинал монеты не может быть отрицательным или равен нулю");
                System.exit(0);
            }
        }

        Arrays.sort(num, 0, n);

        System.out.println("Все размены: ");

        int kol = Rec(num, 0, sum, "", n, 0);

        System.out.println("Всего вариантов: ");
        System.out.println(kol);

    }
}
