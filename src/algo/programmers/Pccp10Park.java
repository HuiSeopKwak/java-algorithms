package algo.programmers;

/***
 * [PCCP 기출문제] 10번 / 공원
 * lv1
 */

import java.util.Arrays;

public class Pccp10Park {
    class Solution {
        public int solution(int[] mats, String[][] park) {

            /**
             들고있는 매트의 큰 순서대로 정렬 후 큰 값부터 전체 공원 탐색하면서 놔둘수있는지 체크 후 성공하면
             바로 return
             **/
            Arrays.sort(mats);

            // 큰 순서대로
            for (int i = mats.length - 1; i >= 0; i--) {
                int mat = mats[i];
                // 탐색할 범위 지정
                for (int y = 0; y < park.length - mat + 1; y++) {
                    for (int x = 0; x < park[0].length - mat + 1; x++) {
                        boolean flag = true;
                        // 탐색 부분, flag이용해 한번도 안걸리면 놓기 가능하기에 놓아줌
                        for (int ny = y; ny < y + mat; ny++) {
                            for (int nx = x; nx < x + mat; nx++) {
                                if (!park[ny][nx].equals("-1"))
                                    flag = false;
                            }
                        }
                        if (flag == true)
                            return mat;
                    }
                }
            }
            return -1;
        }
    }
}
