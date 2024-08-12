package algo.study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 4256 트리
 * 메모리: 
 * 시간: 
 */
public class boj4256 {
	static int testCase;
	static int n;
	static int[] preorderTree;
	static int[] inorderTree;
	
//	class Tree {
//		int self;
//		Tree leftnode;
//		Tree rightnode;
//		
//		Tree(int self) {
//			this.self = self;
//			this.leftnode = null;
//			this.rightnode = null;
//		}
//		
//		Tree(int self, Tree leftnode, Tree rightnode) {
//			this.self = self;
//			this.leftnode = leftnode;
//			this.rightnode = rightnode;
//		}
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		testCase = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < testCase; t++) {	// 테케 만큼 반복
			int root = 0;	// root 노드
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			preorderTree = new int[n];
			inorderTree = new int[n];

			st = new StringTokenizer(br.readLine());	// 전위 순회 입력 받기
			for (int i = 0; i < n; i++) {
				preorderTree[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());	// 중위 순회 입력 받기
			for (int i = 0; i < n; i++) {
				inorderTree[i] = Integer.parseInt(st.nextToken());
			}
			
			root = preorderTree[0];	// 전위순회 노드의 0번째 값이 루트 노드
			
			
		}

	}

}
