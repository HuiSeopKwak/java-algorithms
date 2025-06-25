package algo.boj;

import java.util.Scanner;

/**
 * 백준 14626 ISBN
 */
public class Boj14626 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int idx = 0;
        int sum = 0;

        // 모르는 값 위치 찾기
        for (int i = 0; i < n.length() - 1; i++) {
            if (n.charAt(i) == '*') {
                idx = i;
            }
            else if (i != (n.length() - 1)) {   // 끝번호 전까지 값 구해두기
                if (i % 2 == 0)
                    sum += n.charAt(i) - '0';
                else
                    sum += (n.charAt(i) - '0') * 3;
            }
        }

        int m = n.charAt(n.length() - 1) - '0';

        if (idx % 2 == 0) {
            for (int i = 0; i < 10; i++) {
                if ((10 - ((sum + i) % 10)) % 10 == m) {
                    System.out.println(i);
                    return;
                }
            }
        }
        else {
            for (int i = 0; i < 10; i++) {
                if ((10 - ((sum + i * 3) % 10)) % 10 == m) {
                    System.out.println(i);
                    return;
                }
            }
        }

    }
}
