package algo.programmers;

/**
 * 피로도
 * programmars lv2
 */
public class Fatigue {
    class Solution {
        static int answer = -1;
        static boolean[] visited;

        public int solution(int k, int[][] dungeons) {
            int len = dungeons.length;
            visited = new boolean[len];

            recur(0, dungeons, len, 0, k);

            return answer;
        }

        static public void recur(int depth, int[][] dungeons, int len, int cnt, int k) {
            if (depth == len) {
                answer = Math.max(answer, cnt);
                return;
            }
            for (int i = 0; i < len; i++) {
                if (!visited[i] && dungeons[i][0] <= k) {
                    visited[i] = true;
                    recur(depth + 1, dungeons, len, cnt + 1, k - dungeons[i][1]);
                    visited[i] = false;
                }
                else if (!visited[i] && dungeons[i][0] > k) {
                    visited[i] = true;
                    recur(depth + 1, dungeons, len, cnt, k);
                    visited[i] = false;
                }
            }
        }
    }
}
