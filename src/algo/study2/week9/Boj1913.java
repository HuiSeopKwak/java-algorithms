package algo.study2.week9;

import java.util.Scanner;

public class Boj1913 {
	static int n;
	static int num;
	static int idx = 1;
	static int arr[][];
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int direction;	// 0은 상, 1은 우, 2는 하, 3은 좌
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = sc.nextInt();
		arr = new int[n][n];
		arr[n/2][n/2] = idx++;
		direction = 0;
		
		while(idx <= n*n) {
			switch(direction) {
			case 0: 
			
			}
		}
	}
}
