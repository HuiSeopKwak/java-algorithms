package algo.study2.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 백준 14501 퇴사
 * 메모리 : 14280 KB
 * 시간 : 108 ms
 */
public class Boj14501 {
	static int N;
	static int maxSalary = Integer.MIN_VALUE;
	static int[][] tasks;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        tasks = new int[N][2];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	tasks[i][0] = Integer.parseInt(st.nextToken());	// 걸리는 시간
        	tasks[i][1] = Integer.parseInt(st.nextToken());	// 가격
        }
        
        check(0, 0);
        System.out.println(maxSalary);
	}
	
	public static void check(int day, int sum) {
		if (day <= N)
			maxSalary = Math.max(sum, maxSalary);
		if (day >= N)
			return;
		
		// 그 날 일을 하고 끝나는 날의 일 확인하러가기
		check(day + tasks[day][0], sum + tasks[day][1]);
		// 그 날 일 안하고 다음 날의 일 확인하러가기
		check(day + 1, sum);
	}

}
