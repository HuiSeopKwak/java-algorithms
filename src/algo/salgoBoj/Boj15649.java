package algo.salgoBoj;

import java.util.Scanner;

public class Boj15649 {
    static int a, b;
    static int arr[];
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        arr = new int[b];
        visited = new boolean[a + 1];

        recur(0);
    }

    static void recur(int idx) {
        if (idx == b) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= a; i++) {
            if (visited[i] == true)
                continue;

            visited[i] = true;
            arr[idx] = i;
            recur(idx + 1);
            visited[i] = false;
        }
    }
}
