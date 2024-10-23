package algo.study2.week11;
/**
 * 백준 12789 도키도키 간식드리미
 * 메모리 : 14444KB
 * 시간 : 108 ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj12789 {
	static int N;
	static int[] arr;
	static int checkOrder;
	static Stack<Integer> wait = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		checkOrder = 1;
		
		for (int i = 1; i < N + 1; i++) {
			if (arr[i] == checkOrder) {
				checkOrder++;
				continue;
			}
			if (!wait.isEmpty() && wait.peek() == checkOrder) {
				wait.pop();
				checkOrder++;
				i--;
				continue;
			}
			else {
				wait.push(arr[i]);
			}
			
		}
		
		int stackSize = wait.size();
		for (int i = 0; i < stackSize; i++) {
			if (wait.peek() == checkOrder) {
				wait.pop();
				checkOrder++;
			}
			else
				break;
		}
		
		
		if (wait.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");
	}

}
