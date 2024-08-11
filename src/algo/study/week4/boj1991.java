package algo.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 1991 트리 순회
 * 풀이: 
 * 메모리: 70420 KB 
 * 시간: 1096 ms
 */

public class boj1991 {
	static int N;
	
	class Node {	// 노드 객체
		char self;
		Node leftnode;
		Node rightnode;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				
			}
		} 

	}

}
