package algo.study2.week7;
/* 
* 백준 1806 부분합
* 메모리 : 23752 KB
* 시간 : 244 ms
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806 {
    static int N, S;
    static int left, right;
    static int minLen = Integer.MAX_VALUE;
    static long sum;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = arr[0];
        left = 0;
        right = 0;

        while (left <= right && right < N) {
            if (sum >= S) { // 합이 최소합보다 크거나 같을때
                if (left == right) { // 한 숫자가 최소합보다 클때 탐색 멈춤
                    System.out.println('1');
                    return;
                }
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left++];
            } else { // 합이 최소값 보다 작을때
                if (right + 1 < N)
                    sum += arr[++right];
                else
                    break;
            }
        }
        if (minLen == Integer.MAX_VALUE)
            System.out.println('0');
        else 
            System.out.println(minLen);

    }

}