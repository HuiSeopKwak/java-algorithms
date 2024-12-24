package algo.salgoBoj;

import java.util.Scanner;

public class Boj2576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            a = sc.nextInt();
            if (a % 2 == 1) {
                sum += a;
                if (min > a) min = a;
            }
        }
        if (sum > 0) {
            System.out.println(sum);
            System.out.println(min);
        }
        else {
            System.out.println("-1");
        }
    }
}
