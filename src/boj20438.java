/*****
 * 백준 20438번 출석체크
 * 학생 번호는 3 ~ n+2 까지

*/
import java.util.Scanner;

public class boj20438 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1번째줄 입력
		int n = sc.nextInt();	// 저체 학생 수
		int k = sc.nextInt();	// 조는 학생 수
		int q = sc.nextInt();	// 출석 코드 보낼 학생 수
		int m = sc.nextInt();	// 주어질 구간의 수
		
		int[] k_stu = new int[k];	// 조는 학생들의 입장 번호 배열
		int[] q_stu = new int[q];	// 출석 코드 보낼 학생들의 입장 번호 배열
		
		// 2번째줄 조는 학생 입장 번호
		for (int i = 0; i < k; i++) {
			k_stu[i] = sc.nextInt();
		}
		// 3번째줄 출석 코드 보낼 학생 번호
		for (int i = 0; i < q; i++) {
			q_stu[i] = sc.nextInt();
		}
		// 4번째줄 구간 간격
		int s = sc.nextInt();
		int e = sc.nextInt();
		
		

	}

}
