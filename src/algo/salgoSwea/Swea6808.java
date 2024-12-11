package algo.salgoSwea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea6808 {
    static int t;
    static int gu[];
    static int in[];
    static int otherCards[];
    static boolean[] cards;
    static boolean[] selectedCards;
    static int win, guSum, inSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());

        for (int testCase = 1; testCase <= t; testCase++) {
            // 값들 초기화
            gu = new int[9];
            in = new int[9];
            otherCards = new int[9];
            cards = new boolean[19];
            selectedCards = new boolean[9];
            win = 0;

            st = new StringTokenizer(br.readLine());

            // 규영이 카드 받음
            for (int i = 0; i < 9; i++) {
                gu[i] = Integer.parseInt(st.nextToken());
                cards[gu[i]] = true;
            }
            // 인영이가 들고 있는 카드 저장
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (cards[i])
                    continue;
                else
                    otherCards[idx++] = i;
            }
            game(0);

            System.out.println("#" + testCase + " " + win + " " + (362880 - win));
        }
    }

    // 게임하는 함수
    static void game(int idx) {
        // 9개를 뽑으면 승/패 계산하기
        if (idx == 9) {
            guSum = 0; inSum = 0;
            for (int i = 0; i < 9; i++) {
                if (gu[i] > in[i])
                    guSum += gu[i] + in[i];
                else
                    inSum += gu[i] + in[i];
            }
            if (guSum > inSum)
                win++;
            return;
        }

        // 재귀로 9!개의 순서를 가진 9개 뽑기
        for (int i = 0; i < 9; i++) {
            if (selectedCards[i])
                continue;

            selectedCards[i] = true;
            in[idx] = otherCards[i];
            game(idx + 1);
            selectedCards[i] = false;
        }
    }
}
