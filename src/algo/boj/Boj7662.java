package algo.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            TreeMap<Long, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char order = st.nextToken().charAt(0);
                Long num = Long.parseLong(st.nextToken());

                if (order == 'I') {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                }
                else {
                    // 비었을땐 다음 작업으로 통과
                    if (treeMap.isEmpty())
                        continue;
                    Long key = (num == 1) ? treeMap.lastKey() : treeMap.firstKey();
                    // 1보다 크면 값 하나만 날려주는거
                    if (treeMap.get(key) > 1)
                        treeMap.put(key, treeMap.get(key) - 1);
                    // 1이면 값 아예 삭제
                    else
                        treeMap.remove(key);
                }
            }
            if (treeMap.isEmpty())
                System.out.println("EMPTY");
            else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}
