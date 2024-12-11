package algo.salgoBoj;

import java.util.Scanner;

public class Boj15650 {
    static int a, b;
    static int arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        arr = new int[b];

        recur(0,0);
    }

    static void recur(int start, int idx) {
        if (idx == b) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start + 1; i <= a; i++) {
            arr[idx] = i;
            recur(i, idx + 1);
        }
    }
}
