package algo.salgoBoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {
    static int S, P;
    static String str;
    static int Acnt, Ccnt, Gcnt, Tcnt;  // A,C,G,T의 개수
    static int Amin, Cmin, Gmin, Tmin;  // A,C,G,T의 필요한 최소 개수
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(br.readLine());

        Amin = Integer.parseInt(st.nextToken());
        Cmin = Integer.parseInt(st.nextToken());
        Gmin = Integer.parseInt(st.nextToken());
        Tmin = Integer.parseInt(st.nextToken());
        // 입력 끝

        // 반복문 돌면서 문자열 뽑은 개수가 맞을때 유효성 체크하면서 개수 찾기
        for (int i = 0; i < S; i++) {
            if (str.charAt(i) == 'A')
                Acnt++;
            else if (str.charAt(i) == 'C')
                Ccnt++;
            else if (str.charAt(i) == 'G')
                Gcnt++;
            else
                Tcnt++;

            // 비밀번호 길이만큼 뽑았을때 유효성 확인
            if (Acnt + Ccnt + Gcnt + Tcnt == P) {
                if (Acnt >= Amin && Ccnt >= Cmin && Gcnt >= Gmin && Tcnt >= Tmin)
                    result++;
                if (str.charAt(i-P+1) == 'A')
                    Acnt--;
                else if (str.charAt(i-P+1) == 'C')
                    Ccnt--;
                else if (str.charAt(i-P+1) == 'G')
                    Gcnt--;
                else
                    Tcnt--;
            }
        }
        System.out.println(result);
    }
}


