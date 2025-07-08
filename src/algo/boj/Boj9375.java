package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 백준 9375 패션왕 신해빈
 */
public class Boj9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int size = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                String[] temp = br.readLine().split(" ");
                map.put(temp[1], map.getOrDefault(temp[1], 0) + 1);
            }
            int answer = 1;
            for (int i : map.values()) {
                answer *= (i + 1);
            }
            System.out.println(answer - 1);
        }
    }
}
