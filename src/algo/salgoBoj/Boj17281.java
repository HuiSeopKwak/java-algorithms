package algo.salgoBoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17281 {
    static int inning;
    static int[][] playerStat;

    static boolean[] isPlayerChecked = new boolean[10];
    static int[] lineup = new int[10];

    static int score, out;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        inning = Integer.parseInt(st.nextToken());
        playerStat = new int[inning][10];

        for (int i = 0; i < inning; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                playerStat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 입력 끝

        lineup[4] = 1;  // 4번 타자에 1번선수 고정
        isPlayerChecked[4] = true;  // 항상 true

        pickPlayer(2);

        System.out.println(max);
    }

    // 2번 선수부터 9명 뽑을때까지 반복
    static void pickPlayer(int idx) {   // idx : player count 느낌
        if (idx == 10) {
            score = play();
            max = Math.max(score, max);
        }

        for (int i = 1; i < 10; i++) {
            if (!isPlayerChecked[i]) {
                isPlayerChecked[i] = true;
                lineup[i] = idx;
                pickPlayer(idx + 1);
                isPlayerChecked[i] = false;
            }
        }
    }

    static int play() {
        int sum = 0;

        int now = 1; // 1번 타자부터 시작
        for(int r=0; r<inning; r++) {
            int inningScore = 0; // 현재 이닝에서 얻는 점수
            out = 0; // 현재 이닝에서 아웃의 수
            boolean[] base = new boolean[4]; // true : 해당 베이스에 선수가 있음, false : 해당 베이스에 선수가 없음

            // 3 아웃이 되기 전까지 반복
            while (out < 3) {
                switch (playerStat[r][lineup[now]]) {
                    // 아웃
                    case 0:
                        out++;
                        break;
                    // 1루타
                    case 1:
                        if (base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    // 2루타
                    case 2:
                        if (base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            inningScore++;
                        }
                        if (base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    // 3루타
                    case 3:
                        if (base[3]) {
                            inningScore++;
                        }
                        if (base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    // 홈런
                    case 4:
                        if (base[3]) {
                            inningScore++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            inningScore++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            inningScore++;
                            base[1] = false;
                        }
                        inningScore++;
                        break;
                }

                // 다음 타자로
                now++;
                // 만약 10번 타자가 되면 다시 1번 타자로 되돌림
                if (now >= 10) {
                    now = 1;
                }
            }

            // 해당 이닝에서 얻은 점수를 총 게임 점수에 더해줌
            sum += inningScore;
        }
        return sum;
    }
}