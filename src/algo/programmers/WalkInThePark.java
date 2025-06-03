package algo.programmers;

/***
 * 공원 산책
 * programmars lv1
 */
public class WalkInThePark {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            boolean move;

            // park = new String[] {"OOO", "OSX", "OXO"};
            // routes = new String[] {"E 1"};

            // 시작 위치 찾기
            int[] loc = new int[2];
            for (int i = 0; i < park.length; i++) {
                for (int j = 0; j < park[0].length(); j++) {
                    if (park[i].charAt(j) == 'S') {
                        loc = new int[] {i, j};
                    }
                }
            }

            // 명령문 순서대로 진행
            FirstLoop:
            for (int i = 0; i < routes.length; i++) {
                String[] temp = routes[i].split(" ");
                int len = Integer.parseInt(temp[1]);

                if (routes[i].charAt(0) == 'N') {
                    if (move = boundaryCheck(loc[0] - len, loc[1], park)) {
                        for (int y = loc[0]; y >= loc[0] - len; y--) {
                            if (park[y].charAt(loc[1]) == 'X')
                                continue FirstLoop;
                        }
                        loc[0] = loc[0] - len;
                    }
                }
                else if (routes[i].charAt(0) == 'S') {
                    if (move = boundaryCheck(loc[0] + len, loc[1], park)) {
                        for (int y = loc[0]; y <= loc[0] + len; y++) {
                            if (park[y].charAt(loc[1]) == 'X')
                                continue FirstLoop;
                        }
                        loc[0] = loc[0] + len;

                    }
                }
                else if (routes[i].charAt(0) == 'E') {
                    if (move = boundaryCheck(loc[0], loc[1] + len, park)) {
                        for (int x = loc[1]; x <= loc[1] + len; x++) {
                            if (park[loc[0]].charAt(x) == 'X')
                                continue FirstLoop;
                        }
                        loc[1] = loc[1] + len;
                    }
                }
                else {  // W
                    if (move = boundaryCheck(loc[0], loc[1] - len, park)) {
                        for (int x = loc[1]; x >= loc[1] - len; x--) {
                            if (park[loc[0]].charAt(x) == 'X')
                                continue FirstLoop;
                        }
                        loc[1] = loc[1] - len;
                    }
                }
                System.out.println(i + "번째 명령 실행 결과 : " + loc[0] + " " + loc[1]);
            }

            return loc;
        }

        static public boolean boundaryCheck(int y, int x, String[] park) {
            if (y >= 0 && y < park.length && x >= 0 && x < park[0].length())
                return true;
            else
                return false;
        }
    }
}
