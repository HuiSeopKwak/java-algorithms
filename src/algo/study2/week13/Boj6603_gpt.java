package algo.study2.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 백준 6603 로또
 * 메모리 : 15952 -> 14300 KB
 * 시간 : 140 -> 108 ms
 */

/**
 * 1. while 문의 조건 탐색 부분이 코드가 좀 더 명확하게 바뀜 -> 시간적인 차이는 별로 없음
 * 2. sb.append(num + " ") 보다는 아래 sb.append(num).append(" "); 가 문자열 연산과정을 생략하고 바로 추가되기 때문에 더 빠름
 * 3. stack 을 사용하면 내부적으로 synchronized 키워드로 보호되기 때문에 불필요한 오버헤드가 발생.. 그래서 arraylist로 비동기적 동적 배열로서
 * 오버헤드가 적고 필요없는 메소드가 없어서 더 빠르게 실행될 수 있었다. 
 * @author winds10pro
 *
 */
public class Boj6603_gpt {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> selected = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while(!(line = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); 
            }
            
            select(0, 0);
            sb.append("\n");
        }
        
        System.out.println(sb);
    }

    public static void select(int idx, int size) {
        if (size == 6) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = idx; i < N; i++) {
            selected.add(arr[i]);
            select(i + 1, size + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
