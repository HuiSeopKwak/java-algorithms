package algo.programmers;

/**
 * 네트워크
 * programmars lv3
 */

public class Network {
    class Solution {
        static boolean visited[];
        static int len;


        public int solution(int n, int[][] computers) {
            len = computers.length;
            int answer = 0;
            visited = new boolean[len];

            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    dfs(i, computers);
                    answer++;
                }
            }

            return answer;
        }

        static public void dfs(int i, int[][] computers) {
            visited[i] = true;

            for (int j = 0; j < len; j++) {
                if (computers[i][j] == 1 && !visited[j]) {
                    dfs(j, computers);
                }
            }
        }


    }
}
