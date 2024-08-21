package algo.study2.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 백준 1946 신입사원
 * 메모리 : 299648 KB
 * 시간 : 1504 ms
 *
 */
public class Boj1946 {

    static int T, N;
    static int a, b;
    static int minRank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        // 테케만큼 반복
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            ArrayList<Score> Sco = new ArrayList<>();

            // 입력받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                Sco.add(new Score(a, b));

            }
            // 정렬
            Collections.sort(Sco);

            minRank = Sco.get(0).b;
            int sum = 1;
            
            // 정렬해준대로 돌면서 체크하기
            for (int i = 1; i < N; i++) {
                if (minRank > Sco.get(i).b) {
                    sum += 1;
                    minRank = Sco.get(i).b;
                }
            }
            
            System.out.println(sum);
        }
    }

    static class Score implements Comparable<Score> {
        int a;
        int b;

        Score(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Score o) {
            if (this.a > o.a)
                return 1;
            else
                return -1;
        }
    }
}