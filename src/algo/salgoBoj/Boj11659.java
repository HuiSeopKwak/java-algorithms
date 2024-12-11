package algo.salgoBoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11659 {
    static int n, m;
    static int[] sumNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sumNum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sumNum[i] = sumNum[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            sb.append(sumNum[right] - sumNum[left-1]).append("\n");
        }
        System.out.println(sb);
    }
}
