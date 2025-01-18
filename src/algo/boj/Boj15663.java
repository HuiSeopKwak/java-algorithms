package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj15663 {
    static int N, M;
    static Stack<Integer> Sta = new Stack<>();
    static int[] arr;
    static boolean[] visited;
    static Set<String> result = new LinkedHashSet<>(); // 중복 제거를 위한 Set

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        select(0);

        for (String seq : result) {
            System.out.println(seq);
        }
    }

    public static void select(int idx) {
        if (idx == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : Sta) {
                sb.append(i).append(" ");
            }
            result.add(sb.toString()); // 중복 제거를 위해 Set에 추가
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                Sta.add(arr[i]);
                select(idx + 1);
                Sta.pop();
                visited[i] = false;
            }
        }

    }
}
