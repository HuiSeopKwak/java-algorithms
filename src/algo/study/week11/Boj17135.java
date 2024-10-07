package algo.study.week11;

import java.util.Arrays;
import java.util.Scanner;

public class Boj17135 {
	
	static int N, M, D; // N*M 맵 크기, D: 궁수 공격 사거리
	static int maxKill = Integer.MIN_VALUE; // 궁수 최다 킬
	static int[][] map;	// 맵 현황
	static int[] archer; // 궁수 위치
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		archer = new int[3];	// 궁수는 무조건 3명
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 입력 끝
		
		picked(0, 0);
		
		System.out.println(maxKill);
	}

	// 궁수 세명의 위치를 조합으로 뽑는 method
	public static void picked(int start, int cnt) {
		if (cnt == 3) {
			
			maxKill = Math.max(maxKill, game());
			return;
		}
		// 모든 조합을 뽑아봄
		for (int i = start; i < M; i++) {
			archer[cnt] = i;
			picked(start + 1, cnt + 1);
		}
	}
	
	// 게임 실행하는 method
	public static int game() {
		int[][] newMap = map;	// 새로운 맵에 복사해줌
		int count = 0;
		int kill = 0;
		
		while(count++ < N) {	// 리스트 내려주기 + 최단거리(킬 계산)을 행 길이 만큼 반복할거임
			for (int i = 0; i < 3; i++) {	// 궁수 세명의 활을 쏠 대상 선택 및 삭제
				kill += attack(archer[i], newMap);	// 공격해주고 죽인 숫자 return 받기
			}
			// 아래로 내려주는 logic 작성해야함
		}
		return kill;
	}
	
	public static int attack(int archerLoc, int[][] map) {
		int 
	}
	
	
}
