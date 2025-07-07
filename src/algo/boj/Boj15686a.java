package algo.boj;
/**
 * 백준 15686 치킨 배달
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj15686a {
    static class POINT {
        int y;
        int x;

        POINT(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, m;
    static int sum = 0;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<POINT> chicken = new ArrayList<>();
    static ArrayList<POINT> home = new ArrayList<>();
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(str[j]);
                if (a == 2) chicken.add(new POINT(i, j));
                else if (a == 1) home.add(new POINT(i, j));
            }
        }
        check = new boolean[chicken.size()];
        // 입력 끝

        dfs(0, 0);
        System.out.println(answer);

    }
    public static void dfs(int depth, int start) {
        if (depth == m) {
            sum = 0;
            for (int i = 0; i < home.size(); i++) {
                int minV = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (check[j])
                        minV = Math.min(minV, Math.abs(chicken.get(j).y - home.get(i).y) + Math.abs(chicken.get(j).x - home.get(i).x));
                }
//                System.out.println(minV);
                sum += minV;
            }
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            check[i] = true;
            dfs(depth + 1, i + 1);
            check[i] = false;
        }
    }
}
