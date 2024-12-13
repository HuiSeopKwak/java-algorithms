package algo.salgoBoj;

import java.util.Scanner;

public class Boj2023 {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 소수만 판별
        find("2");
        find("3");
        find("5");
        find("7");

        System.out.println(sb);
    }

    static void find(String num) {
        // 소수가 아니면 return
        if(!check(num))
            return;
        // n개의 길이라면 결과에 추가하고 return
        if (num.length() == n) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
//            System.out.println(num);
            find(num + i);
        }
    }

    static boolean check(String num) {
        int intNum = Integer.parseInt(num);
        if (intNum == 1)
            return false;
        if (intNum == 2)
            return true;
        if (intNum % 2 == 0)
            return false;

        // 소수계산할때 제곱근 보다 작거나 같은 값만 검사 하면 된다.
        // 짝수는 이미 처리했으므로 i++이 아닌 i += 2로 검사하는 것이 불필요한 시간을 줄일 수 있다.
        for (int i = 3; i <= Math.sqrt(intNum); i += 2) {
            if (intNum % i == 0)
                return false;
        }
        return true;
    }
}
