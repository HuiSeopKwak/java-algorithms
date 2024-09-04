package algo.study2.week3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 백준 5568 카드 놓기 
 * 메모리 : 18064 KB
 * 시간 : 180 ms
 *
 */

public class Boj5568 {
	static int n, k;	// n개의 숫자에서 k개 뽑기
	static String[] arr;	// 문자열로 저장
	static Set<String> set = new HashSet<>();
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new String[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt() + "";
		}
		// 입력끝
		
		recur("", 0);
	
		System.out.println(set.size());
	}
	
	static void recur(String s, int cnt) {
		if (cnt == k) {	// 원하는 개수만큼 뽑으면 Set에 넣고 종료
			set.add(s);
			return;
		}
		for (int i = 0; i < n; i++) {	// visited로 방문인덱스 재방문 X
			if (!visited[i]) {
				visited[i] = true;
				recur(s + arr[i], cnt + 1);
				visited[i] = false;
			}
		}
	}
	
}