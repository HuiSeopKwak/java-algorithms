package algo.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int n, w, l;	// n: 트럭의 개수, w: 다리의 길이, l: 다리의 최대하중 
	static int time = 0;
	static int bridgeWeight = 0;
	static ArrayList<Integer> trucks = new ArrayList<>();
	static int bridge[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		w = sc.nextInt();
		l = sc.nextInt();
		bridge = new int[w];

		
		for (int i = 0; i < n; i++) {
			trucks.add(sc.nextInt());
		}

		while(true) {
			time++;
			// 다리위의 트럭을 한칸씩 옮겨줌
			for (int i = 0; i < w-1; i++) {
				bridge[i] = bridge[i+1];
			}
			bridgeWeight = 0;
			
			for (int i = 0; i < w; i++) {
				bridgeWeight += bridge[i];
			}
			
			bridgeWeight -= bridge[w - 1];	// 끝에 값 제거 안되어있으니 0이던 트럭이 있던 빼줌
			
//			System.out.println(bridgeWeight + trucks.get(0));
			if (bridgeWeight + trucks.get(0) <= l) {	// 다음트럭이 올라가도된다면 
				bridge[w-1] = trucks.get(0);
				trucks.remove(0);
			}
			else {
				bridge[w-1] = 0;
				continue;
			}
			
			if(trucks.isEmpty()) {
				time += w;
				break;
			}
		}
		
		System.out.println(time);
	}

}
