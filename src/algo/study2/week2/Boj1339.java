package algo.study2.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1339 단어 수학
 * 메모리 : 14324 KB
 * 시간 : 108 ms
 *
 */
public class Boj1339 {

    static int N;    // 문자의 개수
    static String str;    // 받는 문자
    static char temp;    // 임시저장 변수
    static int arr[] = new int[26];    // 알파벳 숫자, A = '65'
    static int sum = 0;    // 총합
    static int cal = 9;    // 계산해줄 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {    // 받은 문자열 돌면서 문자의 위치만큼 가중치 더해줌
                temp = str.charAt(j);
                arr[temp - 65] += (int) Math.pow(10, str.length() - j - 1);
            }
        }
        
        Arrays.sort(arr);
        
        for (int i = 25; i > 16; i--) {    // 오름차순 정렬된 값을 돌면서 곱해줌
            sum += arr[i] * cal;
            cal--;
        }
        System.out.println(sum);
    }

}