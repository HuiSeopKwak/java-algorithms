package algo.salgoBoj;

import java.util.Scanner;

public class Boj27433 {
    static long n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println(recur(n));
    }

    static long recur(long num) {
        if (num <= 1)
            return 1;

        return num * recur(num - 1);
    }
}
