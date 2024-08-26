package algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea6109 {

	static int T, N; // T: 테케, N: 격자 크기
	static int[][] table; // 격자 저장용
	static int[][] result;
	static String func; // func 확인용 문자열
	static int pointer; // 다음거 비교욤 포인터

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		// 테케만큼 반복
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			func = st.nextToken();
			table = new int[N][N];
			result = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			switch (func) {
			case "up":
				upfunc();
				break;
			case "down":
				downfunc();
				break;
			case "right":
				rightfunc();
				break;
			case "left":
				leftfunc();
				break;
			}

			// 결과값 출력
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	// 위로 올리는 함수
	static void upfunc() {
		for (int i = 0; i < N; i++) { // 각 열 별로 하나씩 반복
			for (int j = 0; j < N - 1; j++) {
				if (table[j][i] == 0)
					continue;

				pointer = j + 1;
				while (table[pointer][i] == 0) { // 다음게 0이면 계속 찾아봄
					if (pointer == N - 1) // 끝에도착시 브레이크
						break;

					pointer++;
				}

				if (table[pointer][i] == 0) // 끝에 도착한 값이 0이면 한 라인 반복 종료
					continue;

				if (table[pointer][i] == table[j][i]) { // 둘이 비교후 같다면 두배
					table[j][i] = table[j][i] * 2;
					table[pointer][i] = 0; // 합쳐진 값은 0으로 바꿔줌
				}
			}

			// 한 열 정리 끝났으니 result 배열에 답 넣어줌
			int idx = 0;
			for (int k = 0; k < N; k++) { // 값이 존재한다면 값 넣어주고 idx + 1
				if (table[k][i] != 0) {
					result[idx++][i] = table[k][i];
				}
			}
		}
	}

	// 아래로 내리는 함수
	static void downfunc() {
		for (int i = 0; i < N; i++) { // 각 열 별로 하나씩 반복
			for (int j = N - 1; j > 0; j--) {
				if (table[j][i] == 0)
					continue;

				pointer = j - 1;
				while (table[pointer][i] == 0) { // 다음게 0이면 계속 찾아봄
					if (pointer == 0) // 끝에도착시 브레이크
						break;

					pointer--;
				}

				if (table[pointer][i] == 0) // 끝에 도착한 값이 0이면 한 라인 반복 종료
					continue;

				if (table[pointer][i] == table[j][i]) { // 둘이 비교후 같다면 두배
					table[j][i] = table[j][i] * 2;
					table[pointer][i] = 0; // 합쳐진 값은 0으로 바꿔줌
				}
			}

			// 한 열 정리 끝났으니 result 배열에 답 넣어줌
			int idx = N - 1;
			for (int k = N - 1; k >= 0; k--) { // 값이 존재한다면 값 넣어주고 idx + 1
				if (table[k][i] != 0) {
					result[idx--][i] = table[k][i];
				}
			}
		}
	}

	// 오른쪽으로 보내는 함수
	static void rightfunc() {
		for (int i = 0; i < N; i++) { // 각 열 별로 하나씩 반복
			for (int j = N - 1; j > 0; j--) {
				if (table[i][j] == 0)
					continue;

				pointer = j - 1;
				while (table[i][pointer] == 0) { // 다음게 0이면 계속 찾아봄
					if (pointer == 0) // 끝에도착시 브레이크
						break;

					pointer--;
				}

				if (table[i][pointer] == 0) // 끝에 도착한 값이 0이면 한 라인 반복 종료
					continue;

				if (table[i][pointer] == table[i][j]) { // 둘이 비교후 같다면 두배
					table[i][j] = table[i][j] * 2;
					table[i][pointer] = 0; // 합쳐진 값은 0으로 바꿔줌
				}
			}

			// 한 열 정리 끝났으니 result 배열에 답 넣어줌
			int idx = N - 1;
			for (int k = N - 1; k >= 0; k--) { // 값이 존재한다면 값 넣어주고 idx + 1
				if (table[i][k] != 0) {
					result[i][idx--] = table[i][k];
				}
			}
		}
	}

	// 왼쪽으로 보내는 함수
	static void leftfunc() {
		for (int i = 0; i < N; i++) { // 각 열 별로 하나씩 반복
			for (int j = 0; j < N - 1; j++) {
				if (table[i][j] == 0)
					continue;

				pointer = j + 1;
				while (table[i][pointer] == 0) { // 다음게 0이면 계속 찾아봄
					if (pointer == N - 1) // 끝에도착시 브레이크
						break;

					pointer++;
				}

				if (table[i][pointer] == 0) // 끝에 도착한 값이 0이면 한 라인 반복 종료
					continue;

				if (table[i][pointer] == table[i][j]) { // 둘이 비교후 같다면 두배
					table[i][j] = table[i][j] * 2;
					table[i][pointer] = 0; // 합쳐진 값은 0으로 바꿔줌
				}
			}

			// 한 열 정리 끝났으니 result 배열에 답 넣어줌
			int idx = 0;
			for (int k = 0; k < N; k++) { // 값이 존재한다면 값 넣어주고 idx + 1
				if (table[i][k] != 0) {
					result[i][idx++] = table[i][k];
				}
			}
		}
	}

}
