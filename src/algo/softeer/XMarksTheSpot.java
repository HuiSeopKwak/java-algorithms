package algo.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XMarksTheSpot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String T = st.nextToken();

            // x or X 위치 찾기
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == 'x' || S.charAt(j) == 'X') {
                    idx = j;
                    break;
                }
            }

            // t의 x 위치 값 추출
            char temp = T.charAt(idx);
            // lowerCase에 있는 문자라면
            if (lowerCase.indexOf(temp) != -1) {
                sb.append((char)(temp - 32));
            }
            else { // 나머지
                sb.append(temp);
            }
        }

        System.out.println(sb);
    }
}
