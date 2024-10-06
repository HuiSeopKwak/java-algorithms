package algo.study.week11;

import java.util.Scanner;

public class Boj17135 {
	
	static int N, M, D; // N*M 맵 크기, D: 궁수 공격 사거리
	static int maxKill; // 궁수 최다 킬
	static int[][] map;	// 맵 현황
	static int[] archer; // 궁수 위치
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		archer = new int[M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	
		picked(0, 0);
		
		System.out.println(maxKill);
	}

	// 궁수 세명의 위치를 조합으로 뽑는 method
	public static void picked(int start, int cnt) {
		if (cnt == 3) {
			maxKill = Math.max(maxKill, game());
			return;
		}
		
		// 하 조합을 뽑는거 부터 연습해야겠는데?
		
		for (int i = start; i < M; i++) {
			archer[i] = i;
		}
		
	}
	
	// 게임 실행하는 method
	public static int game() {
		
		
		return 0;
	}
}
