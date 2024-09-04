package algo.study2.week3;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 백준 1759 이항 계수 2
 * 메모리 : 20908 KB
 * 시간 : 224 ms
 *
 */
public class Boj1759 {
	static int L, C;	// C개의 문자중에서 L개 뽑기
	static char words[];
	static String word;
	static int mo, ja;	// 모음 자음 수
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();

		words = new char[C];
		
		for (int i = 0; i < C; i++) {
			word = sc.next();
			words[i] = word.charAt(0);
		}
		Arrays.sort(words);
		dfs("", 0, 0);	// pw, start, cnt
		
		System.out.println(sb);
	}
	
	static void dfs(String pw, int start, int cnt) {
		if (cnt == L) {
			check(pw);
			return;
		}
		
		for (int i = start; i < C; i++) {
			dfs(pw + words[i], i + 1, cnt + 1);
		}
	}
	
	static void check(String pw) {
		mo = 0;
		ja = 0;
		for (int i = 0; i < L; i++) {	// 문자열길이만큼 돌면서 모음자음 개수 체크
			char A = pw.charAt(i);
			if (A == 'a' || A == 'e' || A == 'i' || A == 'o' || A == 'u')
				mo += 1;
			else
				ja += 1;
		}
		if (mo >= 1 && ja >= 2)	// 조건만족시 답에 추가
			sb.append(pw + "\n");
	}
}