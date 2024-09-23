package algo.study.week9;
/**
 * 백준 12933 오리 
 * 메모리 : 14440 KB
 * 시간 : 120 ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj12933 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		// 소리가 올바르게 녹음되지 않은 경우 -1
		if (str.length() % 5 != 0 || str.charAt(0) != 'q') {
			System.out.println(-1);
			return;
		}

		ArrayList<Character> arr = new ArrayList<>();
		char[] ch = { 'q', 'u', 'a', 'c', 'k' };
		int idx = 0;
		int res = 0;

		// ArrayList에 값 넣어줌
		for (int x = 0; x < str.length(); x++) {
			arr.add(str.charAt(x));
		}

		while (true) {
			// 한줄씩 끝까지 가는거 반복
			for (int x = 0; x < arr.size(); x++) {
				char next = arr.get(x);
				char wanna = ch[idx];

				if (next == wanna) {
					idx = (idx + 1) % 5;
					arr.remove(x);
					x--;
				}
			}

			if (idx == 0)
				res++;
			else {
				System.out.println(-1);
				return;
			}
			if (arr.isEmpty()) {
				System.out.println(res);
				return;
			}
		}
	}
}
